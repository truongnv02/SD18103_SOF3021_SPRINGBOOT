package com.poly.truongnvph29176.services;

import com.poly.truongnvph29176.entities.SanPham;
import com.poly.truongnvph29176.model.dto.SanPhamDTO;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getAll();

    SanPham createSanPham(SanPhamDTO sanPhamDTO, Path path);

    SanPham saveOrUpdate(SanPham sanPham);

    SanPham getSanPhamById(UUID id);

    void deleteById(UUID id);

    String maSPCount();
}
