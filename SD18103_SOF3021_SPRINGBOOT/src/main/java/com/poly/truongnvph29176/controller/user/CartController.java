package com.poly.truongnvph29176.controller.user;

import com.poly.truongnvph29176.model.dto.GioHangChiTietDTO;
import com.poly.truongnvph29176.model.mapper.ChiTietSPMapper;
import com.poly.truongnvph29176.services.ChiTietSPService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class CartController {
    @Autowired
    private HttpSession session;
    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private ChiTietSPMapper chiTietSPMapper;
    @Autowired
    private GioHangChiTietDTO gioHangChiTietDTO;

    @GetMapping("/cart")
    public String cart(Model model) {
        return "user/gio_hang/cart";
    }

    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam("ctspId")UUID ctspId) {

        return "redirect:/cart";
    }
}
