package com.poly.truongnvph29176.controller.admin;

import com.poly.truongnvph29176.entities.SanPham;
import com.poly.truongnvph29176.model.dto.SanPhamDTO;
import com.poly.truongnvph29176.model.mapper.SanPhamMapper;
import com.poly.truongnvph29176.repositories.SanPhamRepository;
import com.poly.truongnvph29176.services.SanPhamService;
import com.poly.truongnvph29176.utilities.UploadFileUtil;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private SanPhamMapper sanPhamMapper;
    @Autowired
    private SanPhamDTO sanPhamDTO;
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @GetMapping("/index")
    public String index(Model model) {
        List<SanPham> listSanPham = sanPhamRepository.findAll();
        model.addAttribute("listSanPham", listSanPham);
        model.addAttribute("views", "/views/admin/san_pham/index.jsp");
        return "admin/home-admin";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("views", "/views/admin/san_pham/create.jsp");
        model.addAttribute("sp", sanPhamDTO);
        model.addAttribute("action", "/admin/san-pham/store");
        return "admin/home-admin";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("sp") SanPhamDTO sanPhamDTO,
                        @RequestParam("imageSP") MultipartFile multipartFile,
                        BindingResult result) {
        if(result.hasErrors()) {
            return "admin/san_pham/create";
        }else {
            SanPham sanPham = sanPhamMapper.convertToEntity(sanPhamDTO);
            sanPham.setImageSP(multipartFile.getOriginalFilename());
            SanPham uploadImgSP = sanPhamService.saveOrUpdate(sanPham);
            if(uploadImgSP != null) {
                try {
                    File saveFile = new File("src/main/webapp/images/");
                    Path path = Paths.get(saveFile.getAbsolutePath()
                            + File.separator
                            + multipartFile.getOriginalFilename());
                    System.out.println(path);
                    Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return "redirect:/admin/san-pham/index";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") SanPham sanPham) {
        SanPhamDTO sanPhamDTO = sanPhamMapper.convertToDTO(sanPham);
        model.addAttribute("views", "/views/admin/san_pham/create.jsp");
        model.addAttribute("sp", sanPhamDTO);
        model.addAttribute("action", "/admin/san-pham/update/" + sanPham.getId());
        return "admin/home-admin";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("sp") SanPhamDTO sanPhamDTO,
                         @RequestParam("imageSP") MultipartFile multipartFile,
                         BindingResult result) {
        if(result.hasErrors()) {
            return "admin/san_pham/create";
        }else {
            SanPham sanPham = sanPhamMapper.convertToEntity(sanPhamDTO);
            sanPham.setImageSP(multipartFile.getOriginalFilename());
            SanPham uploadImgSP = sanPhamService.saveOrUpdate(sanPham);
            if(uploadImgSP != null) {
                try {
                    File saveFile = new File("src/main/webapp/images/");
                    Path path = Paths.get(saveFile.getAbsolutePath()
                            + File.separator
                            + multipartFile.getOriginalFilename());
                    System.out.println(path);
                    Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return "redirect:/admin/san-pham/index";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") UUID id, RedirectAttributes redirectAttributes) {
        try {
            sanPhamService.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Xóa sản phẩm thành công.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Không thể xóa sản phẩm do có bản ghi liên quan trong bảng ChiTietSP.");
        }
        return "redirect:/admin/san-pham/index";
    }
}
