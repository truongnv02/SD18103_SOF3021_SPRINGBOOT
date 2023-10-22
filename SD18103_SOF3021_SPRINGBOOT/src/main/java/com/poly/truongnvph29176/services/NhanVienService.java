package com.poly.truongnvph29176.services;

import com.poly.truongnvph29176.entities.NhanVien;
import com.poly.truongnvph29176.model.dto.NhanVienDTO;
import com.poly.truongnvph29176.model.request.LoginAdminRequest;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> getAll();

    NhanVien createNhanVien(NhanVienDTO nhanVienDTO);

    NhanVien getNhanVienById(UUID id);

    NhanVien updateNhanVien(NhanVienDTO nhanVienDTO);

    void remove(UUID id);

    String maNVCount();

    NhanVienDTO checkLogin(LoginAdminRequest loginAdminRequest);
}
