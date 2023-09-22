package com.poly.truongnvph29176.controller.admin;

import com.poly.truongnvph29176.entities.ChiTietSP;
import com.poly.truongnvph29176.entities.DongSP;
import com.poly.truongnvph29176.entities.MauSac;
import com.poly.truongnvph29176.entities.NSX;
import com.poly.truongnvph29176.entities.SanPham;
import com.poly.truongnvph29176.model.dto.ChiTietSPDTO;
import com.poly.truongnvph29176.model.mapper.ChiTietSPMapper;
import com.poly.truongnvph29176.services.ChiTietSPService;
import com.poly.truongnvph29176.services.DongSPService;
import com.poly.truongnvph29176.services.MauSacService;
import com.poly.truongnvph29176.services.NSXService;
import com.poly.truongnvph29176.services.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/ctsp")
public class ChiTietSPController {
    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private ChiTietSPMapper chiTietSPMapper;
    @Autowired
    private ChiTietSPDTO chiTietSPDTO;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private NSXService nsxService;
    @Autowired
    private DongSPService dongSPService;

    @GetMapping("/index")
    public String index(Model model) {
        List<ChiTietSP> listCTSP = chiTietSPService.getAll();
        model.addAttribute("listCTSP", listCTSP);
        model.addAttribute("views", "/views/admin/ctsp/index.jsp");
        return "admin/home-admin";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<SanPham> listSanPham = sanPhamService.getAll();
        List<NSX> listNSX = nsxService.getAll();
        List<DongSP> listDongSP = dongSPService.getAll();
        List<MauSac> listMauSac = mauSacService.getAll();
        model.addAttribute("listSanPham", listSanPham);
        model.addAttribute("listNSX", listNSX);
        model.addAttribute("listDongSP", listDongSP);
        model.addAttribute("listMauSac", listMauSac);
        model.addAttribute("ctsp", chiTietSPDTO);
        model.addAttribute("views", "/views/admin/ctsp/create.jsp");
        model.addAttribute("action", "/admin/ctsp/store");
        return "admin/home-admin";
    }

    @PostMapping("/store")
    public String store( Model model, @Valid @ModelAttribute("ctsp") ChiTietSPDTO chiTietSPDTO, BindingResult result) {
        if(result.hasErrors()) {
            List<SanPham> listSanPham = sanPhamService.getAll();
            List<NSX> listNSX = nsxService.getAll();
            List<DongSP> listDongSP = dongSPService.getAll();
            List<MauSac> listMauSac = mauSacService.getAll();
            model.addAttribute("listSanPham", listSanPham);
            model.addAttribute("listNSX", listNSX);
            model.addAttribute("listDongSP", listDongSP);
            model.addAttribute("listMauSac", listMauSac);
            return "admin/ctsp/create";
        }else {
            chiTietSPService.saveOrUpdate(chiTietSPDTO);
            return "redirect:/admin/ctsp/index";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") ChiTietSP chiTietSP) {
        ChiTietSPDTO chiTietSPDTO = chiTietSPMapper.convertToDTO(chiTietSP);
        List<SanPham> listSanPham = sanPhamService.getAll();
        List<NSX> listNSX = nsxService.getAll();
        List<DongSP> listDongSP = dongSPService.getAll();
        List<MauSac> listMauSac = mauSacService.getAll();
        model.addAttribute("listSanPham", listSanPham);
        model.addAttribute("listNSX", listNSX);
        model.addAttribute("listDongSP", listDongSP);
        model.addAttribute("listMauSac", listMauSac);
        model.addAttribute("ctsp", chiTietSPDTO);
        model.addAttribute("views", "/views/admin/ctsp/create.jsp");
        model.addAttribute("action", "/admin/ctsp/update/" + chiTietSP.getId());
        return "admin/home-admin";
    }

    @PostMapping("/update/{id}")
    public String update(Model model, @Valid @ModelAttribute("ctsp") ChiTietSPDTO chiTietSPDTO, BindingResult result) {
        if(result.hasErrors()) {
            List<SanPham> listSanPham = sanPhamService.getAll();
            List<NSX> listNSX = nsxService.getAll();
            List<DongSP> listDongSP = dongSPService.getAll();
            List<MauSac> listMauSac = mauSacService.getAll();
            model.addAttribute("listSanPham", listSanPham);
            model.addAttribute("listNSX", listNSX);
            model.addAttribute("listDongSP", listDongSP);
            model.addAttribute("listMauSac", listMauSac);
            return "admin/ctsp/create";
        }else {
            chiTietSPService.saveOrUpdate(chiTietSPDTO);
            return "redirect:/admin/ctsp/index";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") ChiTietSP chiTietSP) {
        ChiTietSPDTO chiTietSPDTO = chiTietSPMapper.convertToDTO(chiTietSP);
        chiTietSPService.deleteById(chiTietSPDTO.getId());
        return "redirect:/admin/ctsp/index";
    }
}
