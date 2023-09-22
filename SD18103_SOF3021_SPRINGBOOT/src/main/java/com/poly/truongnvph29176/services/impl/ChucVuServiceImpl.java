package com.poly.truongnvph29176.services.impl;

import com.poly.truongnvph29176.entities.ChucVu;
import com.poly.truongnvph29176.model.dto.ChucVuDTO;
import com.poly.truongnvph29176.model.mapper.ChucVuMapper;
import com.poly.truongnvph29176.repositories.ChucVuReposirory;
import com.poly.truongnvph29176.services.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    private ChucVuReposirory chucVuReposirory;

    @Autowired
    private ChucVuMapper chucVuMapper;

    @Override
    public List<ChucVu> getAll() {
        return chucVuReposirory.findAll();
    }

    @Override
    public ChucVu createChucVu(ChucVuDTO chucVuDTO) {
        ChucVu chucVu = chucVuMapper.convertToEntity(chucVuDTO);
        return chucVuReposirory.save(chucVu);
    }

    @Override
    public ChucVu updateChucVu(ChucVuDTO chucVuDTO) {
        ChucVu chucVu = chucVuMapper.convertToEntity(chucVuDTO);
        ChucVu chucVuId = chucVuReposirory.findById(chucVu.getId()).orElse(null);
        chucVuId.setTen(chucVuDTO.getTen());
        return chucVuReposirory.save(chucVuId);
    }

    @Override
    public void deleteById(UUID id) {
        chucVuReposirory.deleteById(id);
    }
}
