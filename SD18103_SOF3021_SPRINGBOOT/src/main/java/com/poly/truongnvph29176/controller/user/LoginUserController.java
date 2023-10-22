package com.poly.truongnvph29176.controller.user;

import com.poly.truongnvph29176.entities.KhachHang;
import com.poly.truongnvph29176.model.dto.GioHangDTO;
import com.poly.truongnvph29176.model.dto.KhachHangDTO;
import com.poly.truongnvph29176.model.mapper.KhachHangMapper;
import com.poly.truongnvph29176.model.request.LoginUserRequest;
import com.poly.truongnvph29176.services.GioHangChiTietService;
import com.poly.truongnvph29176.services.KhachHangService;
import jakarta.servlet.http.HttpSession;
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

@Controller
public class LoginUserController {
    @Autowired
    private LoginUserRequest loginUserRequest;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private HttpSession session;
    @Autowired
    private KhachHangDTO khachHangDTO;
    @Autowired
    private KhachHangMapper khachHangMapper;
    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", loginUserRequest);
        return "user/dang_nhap/login";
    }

    @PostMapping("/check-login")
    public String login(Model model, @Valid @ModelAttribute("user") LoginUserRequest loginUserRequest,
                        BindingResult result) {
        KhachHangDTO khachHangDTO = khachHangService.login(loginUserRequest);
        if(result.hasErrors()) {
            return "user/dang_nhap/login";
        }
        if(khachHangDTO != null) {
            session.setAttribute("user", khachHangDTO);
            session.setAttribute("name", khachHangDTO.getTen());
            session.setAttribute("userid", khachHangDTO.getId());
            session.setAttribute("index", gioHangChiTietService.index(khachHangDTO.getId()));
            return "redirect:/trang-chu";
        } else {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
            return "user/dang_nhap/login";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("kh", khachHangDTO);
        return "user/dang_nhap/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("kh") KhachHangDTO khachHangDTO,
                           GioHangDTO gioHangDTO,
                           BindingResult result) {
        if(result.hasErrors()) {
            return "user/dang_nhap/register";
        }
        khachHangDTO.setMa(khachHangService.maKHCount());
        KhachHangDTO khachHang = khachHangService.register(khachHangDTO);
        return "redirect:/login";
    }

    @GetMapping("/my-info")
    public String myInfo() {
        return "user/dang_nhap/my-info";
    }

    @GetMapping("/log-out")
    public String logOut() {
        session.removeAttribute("user");
        return "redirect:/trang-chu";
    }

    @GetMapping("/view-user/{id}")
    public String viewsUser(Model model, @PathVariable("id") KhachHang khachHang) {
        KhachHangDTO khachHangDTO = khachHangMapper.convertToDTO(khachHang);
        model.addAttribute("kh", khachHangDTO);
        model.addAttribute("viewUser", "/views/user/dang_nhap/view-user.jsp");
        model.addAttribute("action", "/update-user/" + khachHangDTO.getId());
        return "user/dang_nhap/my-info";
    }

    @PostMapping("/update-user/{id}")
    public String updateUser(@Valid @ModelAttribute("kh") KhachHangDTO khachHangDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "user/dang_nhap/view-user";
        }else {
            khachHangService.updateKhachHang(khachHangDTO);
            return "redirect:/my-info";
        }
    }
}
