package com.poly.truongnvph29176.controller.admin;

import com.poly.truongnvph29176.entities.DongSP;
import com.poly.truongnvph29176.model.dto.DongSPDTO;
import com.poly.truongnvph29176.model.mapper.DongSPMapper;
import com.poly.truongnvph29176.services.DongSPService;
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
@RequestMapping("/admin/dong-sp")
public class DongSPController {
    @Autowired
    private DongSPService dongSPService;
    @Autowired
    private DongSPMapper dongSPMapper;
    @Autowired
    private DongSPDTO dongSPDTO;

    @GetMapping("/index")
    public String index(Model model) {
        List<DongSP> listDongSP = dongSPService.getAll();
        model.addAttribute("listDongSP", listDongSP);
        model.addAttribute("views", "/views/admin/dong_sp/index.jsp");
        return "admin/home-admin";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("views", "/views/admin/dong_sp/create.jsp");
        model.addAttribute("dsp", dongSPDTO);
        model.addAttribute("action", "/admin/dong-sp/store");
        return "admin/home-admin";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("dsp") DongSPDTO dongSPDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/dong_sp/create";
        }else {
            dongSPDTO.setMa(dongSPService.maDongSPCount());
            dongSPService.saveOrUpdate(dongSPDTO);
            return "redirect:/admin/dong-sp/index";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") DongSP dongSP) {
        DongSPDTO dongSPDTO = dongSPMapper.convertToDTO(dongSP);
        model.addAttribute("dsp", dongSPDTO);
        model.addAttribute("views", "/views/admin/dong_sp/create.jsp");
        model.addAttribute("action", "/admin/dong-sp/update/" + dongSP.getId());
        return "admin/home-admin";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("dsp") DongSPDTO dongSPDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/dong_sp/create";
        }else {
            dongSPService.saveOrUpdate(dongSPDTO);
            return "redirect:/admin/dong-sp/index";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        dongSPService.deleteById(id);
        return "redirect:/admin/dong-sp/index";
    }
}
