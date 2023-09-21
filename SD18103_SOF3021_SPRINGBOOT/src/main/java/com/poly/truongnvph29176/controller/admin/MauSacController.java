package com.poly.truongnvph29176.controller.admin;

import com.poly.truongnvph29176.entities.MauSac;
import com.poly.truongnvph29176.model.dto.MauSacDTO;
import com.poly.truongnvph29176.model.mapper.MauSacMapper;
import com.poly.truongnvph29176.services.MauSacService;
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
@RequestMapping("/admin/mau-sac")
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private MauSacMapper mauSacMapper;
    @Autowired
    private MauSacDTO mauSacDTO;

    @GetMapping("/index")
    public String index(Model model) {
        List<MauSac> listMauSac = mauSacService.getAll();
        model.addAttribute("views", "/views/admin/mau_sac/index.jsp");
        model.addAttribute("listMauSac", listMauSac);
        return "admin/home-admin";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("views", "/views/admin/mau_sac/create.jsp");
        model.addAttribute("ms", mauSacDTO);
        model.addAttribute("action", "/admin/mau-sac/store");
        return "admin/home-admin";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("ms") MauSacDTO mauSacDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/mau_sac/create";
        }else {
            mauSacDTO.setMa(mauSacService.maMSCount());
            mauSacService.saveOrUpdate(mauSacDTO);
            return "redirect:/admin/mau-sac/index";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") MauSac mauSac) {
        MauSacDTO mauSacDTO = mauSacMapper.convertToDTO(mauSac);
        model.addAttribute("ms", mauSacDTO);
        model.addAttribute("views", "/views/admin/mau_sac/create.jsp");
        model.addAttribute("action", "/admin/mau-sac/update/" + mauSac.getId());
        return "admin/home-admin";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("ms") MauSacDTO mauSacDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "amin/mau_sac/create";
        }else {
            mauSacService.saveOrUpdate(mauSacDTO);
            return "redirect:/admin/mau-sac/index";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        mauSacService.deleteById(id);
        return "redirect:/admin/mau-sac/index";
    }
}
