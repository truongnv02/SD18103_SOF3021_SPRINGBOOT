package com.poly.truongnvph29176.controller.admin;

import com.poly.truongnvph29176.entities.NSX;
import com.poly.truongnvph29176.model.dto.NSXDTO;
import com.poly.truongnvph29176.model.mapper.NSXMapper;
import com.poly.truongnvph29176.services.NSXService;
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
@RequestMapping("/admin/nsx")
public class NSXController {
    @Autowired
    private NSXService nsxService;
    @Autowired
    private NSXMapper nsxMapper;
    @Autowired
    private NSXDTO nsxdto;

    @GetMapping("/index")
    public String index(Model model) {
        List<NSX> listNSX = nsxService.getAll();
        model.addAttribute("listNSX", listNSX);
        model.addAttribute("views", "/views/admin/nsx/index.jsp");
        return "admin/home-admin";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("views", "/views/admin/nsx/create.jsp");
        model.addAttribute("nsx", nsxdto);
        model.addAttribute("action", "/admin/nsx/store");
        return "admin/home-admin";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("nsx") NSXDTO nsxdto, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/nsx/create";
        }else {
            nsxdto.setMa(nsxService.maNSXCount());
            nsxService.createNSX(nsxdto);
            return "redirect:/admin/nsx/index";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") NSX nsx) {
        NSXDTO nsxdto = nsxMapper.convertToDTO(nsx);
        model.addAttribute("views", "/views/admin/nsx/create.jsp");
        model.addAttribute("nsx", nsxdto);
        model.addAttribute("action", "/admin/nsx/update/" + nsx.getId());
        return "admin/home-admin";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("nsx") NSXDTO nsxdto, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/nsx/create";
        }else {
            nsxService.updateNSX(nsxdto);
            return "redirect:/admin/nsx/index";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        nsxService.deleteById(id);
        return "redirect:/admin/nsx/index";
    }
}
