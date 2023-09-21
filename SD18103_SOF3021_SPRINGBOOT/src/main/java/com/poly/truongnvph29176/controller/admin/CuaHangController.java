package com.poly.truongnvph29176.controller.admin;

import com.poly.truongnvph29176.entities.CuaHang;
import com.poly.truongnvph29176.model.dto.CuaHangDTO;
import com.poly.truongnvph29176.model.mapper.CuaHangMapper;
import com.poly.truongnvph29176.services.CuaHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/cua-hang")
public class CuaHangController {
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private CuaHangDTO cuaHangDTO;
    @Autowired
    private CuaHangMapper cuaHangMapper;

    @GetMapping("/index")
    public String index(Model model) {
        List<CuaHang> listCuaHang = cuaHangService.getAll();
        model.addAttribute("listCuaHang", listCuaHang);
        model.addAttribute("views", "/views/admin/cua_hang/index.jsp");
        return "admin/home-admin";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("ch", cuaHangDTO);
        model.addAttribute("views", "/views/admin/cua_hang/create.jsp");
        model.addAttribute("action", "/admin/cua-hang/store");
        return "admin/home-admin";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("ch") CuaHangDTO cuaHangDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/cua_hang/create";
        }else {
            cuaHangService.createCuaHang(cuaHangDTO);
        }
        return "redirect:/admin/cua-hang/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") CuaHang cuaHang) {
        CuaHangDTO cuaHangDTO = cuaHangMapper.convertToDTO(cuaHang);
        model.addAttribute("views", "/views/admin/cua_hang/create.jsp");
        model.addAttribute("ch", cuaHangDTO);
        model.addAttribute("action", "/admin/cua-hang/update/" + cuaHang.getId());
        return "admin/home-admin";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("ch") CuaHangDTO cuaHangDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/cua_hang/create";
        }else {
            cuaHangService.updateCuaHang(cuaHangDTO);
            return "redirect:/admin/cua-hang/index";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        cuaHangService.remove(id);
        return "redirect:/admin/cua-hang/index";
    }
}
