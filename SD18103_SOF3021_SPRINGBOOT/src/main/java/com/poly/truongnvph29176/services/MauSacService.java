package com.poly.truongnvph29176.services;

import com.poly.truongnvph29176.entities.MauSac;
import com.poly.truongnvph29176.model.dto.MauSacDTO;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    List<MauSac> getAll();

    MauSac saveOrUpdate(MauSacDTO mauSacDTO);

    MauSac getMauSacById(UUID id);

    void deleteById(UUID id);

    String maMSCount();
}
