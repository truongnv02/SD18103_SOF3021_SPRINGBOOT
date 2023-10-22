package com.poly.truongnvph29176.controller.user;

import com.poly.truongnvph29176.entities.ChiTietSP;
import com.poly.truongnvph29176.services.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ChiTietSPService chiTietSPService;

    @GetMapping("/trang-chu")
    public String home(Model model) {
        List<ChiTietSP> listCTSP = chiTietSPService.getAll();
        model.addAttribute("listCTSP", listCTSP);
        return "user/index";
    }
}
