package com.poly.truongnvph29176.services;

import com.poly.truongnvph29176.entities.GioHang;
import com.poly.truongnvph29176.model.dto.GioHangDTO;

import java.util.UUID;

public interface GioHangService {
    GioHang saveOrUpdate(GioHangDTO gioHangDTO);

    GioHang findByKhachHang(UUID idKhachHang);
}
