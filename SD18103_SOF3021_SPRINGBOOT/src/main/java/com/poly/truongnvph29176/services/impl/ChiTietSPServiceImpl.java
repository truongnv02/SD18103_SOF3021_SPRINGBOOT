package com.poly.truongnvph29176.services.impl;

import com.poly.truongnvph29176.entities.ChiTietSP;
import com.poly.truongnvph29176.entities.MauSac;
import com.poly.truongnvph29176.model.dto.ChiTietSPDTO;
import com.poly.truongnvph29176.model.mapper.ChiTietSPMapper;
import com.poly.truongnvph29176.repositories.ChiTietSPRepository;
import com.poly.truongnvph29176.services.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
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
    public String findTenDongSP(UUID id) {
        return chiTietSPRepository.findTenDongSP(id);
    }

    @Override
    public List<ChiTietSP> findDongSPByTen(String ten) {
        return chiTietSPRepository.findCTSPByTenDongSP(ten);
    }

    @Override
    public Page<ChiTietSP> findCTSPByIdDongSP(UUID id, Pageable pageable) {
        return chiTietSPRepository.findCTSPByIdDongSP(id, pageable);
    }


    @Override
    public Page<ChiTietSP> findAllPage(Pageable pageable) {
        Page<ChiTietSP> listCTSPPage = chiTietSPRepository.findAll(pageable);
        return listCTSPPage;
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
    public ChiTietSPDTO getCTSPById(UUID id) {
        Optional<ChiTietSP> chiTietSP = chiTietSPRepository.findById(id);
        if(chiTietSP.isPresent()) {
            return chiTietSPMapper.convertToDTO(chiTietSP.get());
        }else {
            return null;
        }
    }

    @Override
    public void deleteById(UUID id) {
        chiTietSPRepository.deleteById(id);
    }

    @Override
    public Integer getSoLuong(UUID idChiTietSP) {
        return chiTietSPRepository.getSoLuong(idChiTietSP);
    }

    @Override
    public BigDecimal findByGiaBan(UUID id) {
        return chiTietSPRepository.findByGia(id);
    }
}
