package com.poly.truongnvph29176.controller.admin;

import com.poly.truongnvph29176.entities.ChucVu;
import com.poly.truongnvph29176.model.dto.ChucVuDTO;
import com.poly.truongnvph29176.model.mapper.ChucVuMapper;
import com.poly.truongnvph29176.services.ChucVuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuService chucVuService;
    @Autowired
    private ChucVuDTO chucVuDTO;
    @Autowired
    private ChucVuMapper chucVuMapper;

    @GetMapping("/index")
    public String index(Model model) {
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("views", "/views/admin/chuc_vu/index.jsp");
        return "admin/home-admin";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("views", "/views/admin/chuc_vu/create.jsp");
        model.addAttribute("cv", chucVuDTO);
        model.addAttribute("action", "/admin/chuc-vu/store");
        return "admin/home-admin";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("cv") ChucVuDTO chucVuDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/chuc_vu/create";
        }else {
            chucVuService.createChucVu(chucVuDTO);
            return "redirect:/admin/chuc-vu/index";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") ChucVu chucVu) {
        ChucVuDTO chucVuDTO = chucVuMapper.convertToDTO(chucVu);
        model.addAttribute("views", "/views/admin/chuc_vu/create.jsp");
        model.addAttribute("cv", chucVuDTO);
        model.addAttribute("action", "/admin/chuc-vu/update/" + chucVu.getId());
        return "admin/home-admin";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("cv") ChucVuDTO chucVuDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/chu_vu/create";
        }else {
            chucVuService.updateChucVu(chucVuDTO);
            return "redirect:/admin/chuc-vu/index";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        chucVuService.deleteById(id);
        return "redirect:/admin/chuc-vu/index";
    }
}
