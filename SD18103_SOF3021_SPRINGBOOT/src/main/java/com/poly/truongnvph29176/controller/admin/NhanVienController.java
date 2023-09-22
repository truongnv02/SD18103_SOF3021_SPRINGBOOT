package com.poly.truongnvph29176.controller.admin;

import com.poly.truongnvph29176.entities.ChucVu;
import com.poly.truongnvph29176.entities.CuaHang;
import com.poly.truongnvph29176.entities.NhanVien;
import com.poly.truongnvph29176.model.dto.NhanVienDTO;
import com.poly.truongnvph29176.model.mapper.NhanVienMapper;
import com.poly.truongnvph29176.services.ChucVuService;
import com.poly.truongnvph29176.services.CuaHangService;
import com.poly.truongnvph29176.services.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private ChucVuService chucVuService;
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private NhanVienDTO nhanVienDTO;
    @Autowired
    private NhanVienMapper nhanVienMapper;

    @GetMapping("/index")
    public String index(Model model) {
        List<NhanVien> listNhanVien = nhanVienService.getAll();
        model.addAttribute("views", "/views/admin/nhan_vien/index.jsp");
        model.addAttribute("listNhanVien", listNhanVien);
        return "admin/home-admin";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<CuaHang> listCuaHang = cuaHangService.getAll();
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listCuaHang", listCuaHang);
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("nv", nhanVienDTO);
        model.addAttribute("views", "/views/admin/nhan_vien/create.jsp");
        model.addAttribute("action", "/admin/nhan-vien/store");
        return "admin/home-admin";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid @ModelAttribute("nv") NhanVienDTO nhanVienDTO, BindingResult result) {
        if(result.hasErrors()) {
            List<CuaHang> listCuaHang = cuaHangService.getAll();
            List<ChucVu> listChucVu = chucVuService.getAll();
            model.addAttribute("listCuaHang", listCuaHang);
            model.addAttribute("listChucVu", listChucVu);
            return "admin/nhan_vien/create";
        }else {
            nhanVienDTO.setMa(nhanVienService.maNVCount());
            nhanVienService.createNhanVien(nhanVienDTO);
            return "redirect:/admin/nhan-vien/index";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") NhanVien nhanVien) {
        NhanVienDTO nhanVienDTO = nhanVienMapper.convertToDTO(nhanVien);
        List<CuaHang> listCuaHang = cuaHangService.getAll();
        List<ChucVu> listChucVu = chucVuService.getAll();
        model.addAttribute("listCuaHang", listCuaHang);
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("nv", nhanVienDTO);
        model.addAttribute("views", "/views/admin/nhan_vien/create.jsp");
        model.addAttribute("action", "/admin/nhan-vien/update/" + nhanVien.getId());
        return "admin/home-admin";
    }

    @PostMapping("/update/{id}")
    public String update(Model model, @Valid @ModelAttribute("nv") NhanVienDTO nhanVienDTO, BindingResult result) {
        if(result.hasErrors()) {
            List<CuaHang> listCuaHang = cuaHangService.getAll();
            List<ChucVu> listChucVu = chucVuService.getAll();
            model.addAttribute("listCuaHang", listCuaHang);
            model.addAttribute("listChucVu", listChucVu);
            return "admin/nhan_vien/create";
        }else {
            nhanVienService.updateNhanVien(nhanVienDTO);
            return "redirect:/admin/nhan-vien/index";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id")UUID id) {
        nhanVienService.remove(id);
        return "redirect:/admin/nhan-vien/index";
    }
}
