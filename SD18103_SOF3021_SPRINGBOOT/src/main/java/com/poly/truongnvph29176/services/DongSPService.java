package com.poly.truongnvph29176.services;

import com.poly.truongnvph29176.entities.DongSP;
import com.poly.truongnvph29176.model.dto.DongSPDTO;

import java.util.List;
import java.util.UUID;

public interface DongSPService {
    List<DongSP> getAll();

    DongSP saveOrUpdate(DongSPDTO dongSPDTO);

    DongSP getDongSPById(UUID id);

    void deleteById(UUID id);

    String maDongSPCount();
}
