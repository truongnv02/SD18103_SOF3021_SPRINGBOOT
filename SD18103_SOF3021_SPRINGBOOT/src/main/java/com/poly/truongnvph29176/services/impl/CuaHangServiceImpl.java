package com.poly.truongnvph29176.services.impl;

import com.poly.truongnvph29176.entities.CuaHang;
import com.poly.truongnvph29176.model.dto.CuaHangDTO;
import com.poly.truongnvph29176.model.mapper.CuaHangMapper;
import com.poly.truongnvph29176.repositories.CuaHangRepository;
import com.poly.truongnvph29176.services.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {
    @Autowired
    private CuaHangRepository cuaHangRepository;
    @Autowired
    private CuaHangMapper cuaHangMapper;

    @Override
    public List<CuaHang> getAll() {
        return cuaHangRepository.findAll();
    }

    @Override
    public CuaHang createCuaHang(CuaHangDTO cuaHangDTO) {
        CuaHang cuaHang = cuaHangMapper.convertToEntity(cuaHangDTO);
        return cuaHangRepository.save(cuaHang);
    }

    @Override
    public CuaHang getCuaHangById(UUID id) {
        return cuaHangRepository.findById(id).orElse(null);
    }

    @Override
    public CuaHang updateCuaHang(CuaHangDTO cuaHangDTO) {
        CuaHang cuaHang = cuaHangMapper.convertToEntity(cuaHangDTO);
        CuaHang cuaHangId = getCuaHangById(cuaHang.getId());
        cuaHangId.setTen(cuaHangDTO.getTen());
        cuaHangId.setDiaChi(cuaHangDTO.getDiaChi());
        cuaHangId.setThanhPho(cuaHangDTO.getThanhPho());;
        cuaHangId.setQuocGia(cuaHangDTO.getQuocGia());
        return cuaHangRepository.save(cuaHangId);
    }

    @Override
    public void remove(UUID id) {
        cuaHangRepository.deleteById(id);
    }
}
