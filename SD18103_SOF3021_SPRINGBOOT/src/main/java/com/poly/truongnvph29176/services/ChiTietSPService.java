package com.poly.truongnvph29176.services;

import com.poly.truongnvph29176.entities.ChiTietSP;
import com.poly.truongnvph29176.model.dto.ChiTietSPDTO;

import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    List<ChiTietSP> getAll();

    ChiTietSP saveOrUpdate(ChiTietSPDTO chiTietSPDTO);

    ChiTietSP getCTSPById(UUID id);

    void deleteById(UUID id);
}
