package com.poly.truongnvph29176.services;

import com.poly.truongnvph29176.entities.KhachHang;
import com.poly.truongnvph29176.model.dto.KhachHangDTO;
import com.poly.truongnvph29176.model.request.LoginAdminRequest;
import com.poly.truongnvph29176.model.request.LoginUserRequest;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getAll();

    KhachHang createKhachHang(KhachHangDTO khachHangDTO);

    KhachHang getKhachHangById(UUID id);

    KhachHang updateKhachHang(KhachHangDTO khachHangDTO);

    KhachHangDTO login(LoginUserRequest loginUserRequest);

    KhachHangDTO register(KhachHangDTO khachHangDTO);

    void remove(UUID id);

    String maKHCount();
}
