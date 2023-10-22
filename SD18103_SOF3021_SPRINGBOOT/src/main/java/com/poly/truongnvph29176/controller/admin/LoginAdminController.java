package com.poly.truongnvph29176.controller.admin;

import com.poly.truongnvph29176.model.dto.NhanVienDTO;
import com.poly.truongnvph29176.model.request.LoginAdminRequest;
import com.poly.truongnvph29176.services.NhanVienService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LoginAdminController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private HttpSession session;
    @Autowired
    private LoginAdminRequest loginAdminRequest;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("admin", loginAdminRequest);
        return "admin/login-admin";
    }

    @GetMapping("/")
    public String homeAdmin() {
        return "admin/home-admin";
    }

    @PostMapping("/check-loginAdmin")
    public String checkLoginAdmin(Model model, @ModelAttribute("admin") LoginAdminRequest loginAdminRequest) {
        NhanVienDTO nhanVienDTO = nhanVienService.checkLogin(loginAdminRequest);
        if(nhanVienDTO != null) {
            session.setAttribute("nv", nhanVienDTO);
            return "redirect:/admin/home-admin";
        }else {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
            return "admin/login-admin";
        }
    }
}
