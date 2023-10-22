package com.poly.truongnvph29176.services;

import com.poly.truongnvph29176.entities.GioHangChiTiet;
import com.poly.truongnvph29176.model.dto.GioHangChiTietDTO;
import com.poly.truongnvph29176.model.dto.KhachHangDTO;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {
    int index(UUID id);
    void add(UUID idCTSP, Integer soLuong, KhachHangDTO khachHangDTO);
}
