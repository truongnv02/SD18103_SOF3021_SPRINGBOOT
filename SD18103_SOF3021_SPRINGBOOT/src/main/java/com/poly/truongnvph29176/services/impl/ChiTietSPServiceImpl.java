package com.poly.truongnvph29176.services.impl;

import com.poly.truongnvph29176.entities.ChiTietSP;
import com.poly.truongnvph29176.model.dto.ChiTietSPDTO;
import com.poly.truongnvph29176.model.mapper.ChiTietSPMapper;
import com.poly.truongnvph29176.repositories.ChiTietSPRepository;
import com.poly.truongnvph29176.services.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSPServiceImpl implements ChiTietSPService {
    @Autowired
    private ChiTietSPRepository chiTietSPRepository;
    @Autowired
    private ChiTietSPMapper chiTietSPMapper;

    @Override
    public List<ChiTietSP> getAll() {
        return chiTietSPRepository.findAll();
    }

    @Override
    public ChiTietSP saveOrUpdate(ChiTietSPDTO chiTietSPDTO) {
        ChiTietSP chiTietSP = chiTietSPMapper.convertToEntity(chiTietSPDTO);
        if(chiTietSP.getId() == null) {
            return chiTietSPRepository.save(chiTietSP);
        }else {
            return chiTietSPRepository.save(chiTietSP);
        }
    }

    @Override
    public ChiTietSP getCTSPById(UUID id) {
        return chiTietSPRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        chiTietSPRepository.deleteById(id);
    }
}
