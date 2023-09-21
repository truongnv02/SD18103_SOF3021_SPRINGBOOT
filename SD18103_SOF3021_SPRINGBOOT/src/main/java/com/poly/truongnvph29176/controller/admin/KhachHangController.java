package com.poly.truongnvph29176.controller.admin;

import com.poly.truongnvph29176.entities.KhachHang;
import com.poly.truongnvph29176.model.dto.KhachHangDTO;
import com.poly.truongnvph29176.model.mapper.KhachHangMapper;
import com.poly.truongnvph29176.services.KhachHangService;
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
import java.util.UUID;

@Controller
@RequestMapping("/admin/khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private KhachHangDTO khachHangDTO;
    @Autowired
    private KhachHangMapper khachHangMapper;

    @GetMapping("/index")
    public String index(Model model) {
        List<KhachHang> listKhachHang = khachHangService.getAll();
        model.addAttribute("views", "/views/admin/khach_hang/index.jsp");
        model.addAttribute("listKhachHang", listKhachHang);
        return "admin/home-admin";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("kh",khachHangDTO);
        model.addAttribute("views", "/views/admin/khach_hang/create.jsp");
        model.addAttribute("action", "/admin/khach-hang/store");
        return "admin/home-admin";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("kh") KhachHangDTO khachHangDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/khach_hang/create";
        }else {
            khachHangDTO.setMa(khachHangService.maKHCount());
            khachHangService.createKhachHang(khachHangDTO);
            return "redirect:/admin/khach-hang/index";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") KhachHang khachHang) {
        KhachHangDTO khachHangDTO = khachHangMapper.convertToDTO(khachHang);
        model.addAttribute("kh", khachHangDTO);
        model.addAttribute("views", "/views/admin/khach_hang/create.jsp");
        model.addAttribute("action", "/admin/khach-hang/update/" + khachHang.getId());
        return "admin/home-admin";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("kh") KhachHangDTO khachHangDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/khach_hang/create";
        }else {
            khachHangService.updateKhachHang(khachHangDTO);
            return "redirect:/admin/khach-hang/index";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id")UUID id) {
        khachHangService.remove(id);
        return "redirect:/admin/khach-hang/index";
    }
}
