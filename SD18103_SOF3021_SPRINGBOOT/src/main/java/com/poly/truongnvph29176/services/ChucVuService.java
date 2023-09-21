package com.poly.truongnvph29176.services;

import com.poly.truongnvph29176.entities.ChucVu;
import com.poly.truongnvph29176.model.dto.ChucVuDTO;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();

    ChucVu createChucVu(ChucVuDTO chucVuDTO);

    ChucVu updateChucVu(ChucVuDTO chucVuDTO);

    void deleteById(UUID id);
}
