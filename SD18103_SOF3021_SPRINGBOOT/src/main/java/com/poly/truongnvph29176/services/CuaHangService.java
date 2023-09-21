package com.poly.truongnvph29176.services;

import com.poly.truongnvph29176.entities.CuaHang;
import com.poly.truongnvph29176.model.dto.CuaHangDTO;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getAll();

    CuaHang createCuaHang(CuaHangDTO cuaHangDTO);

    CuaHang getCuaHangById(UUID id);

    CuaHang updateCuaHang(CuaHangDTO cuaHangDTO);

    void remove(UUID id);
}
