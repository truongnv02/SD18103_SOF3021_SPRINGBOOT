package com.poly.truongnvph29176.services;

import com.poly.truongnvph29176.entities.ChiTietSP;
import com.poly.truongnvph29176.model.dto.ChiTietSPDTO;
import jakarta.validation.constraints.DecimalMax;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    List<ChiTietSP> getAll();

    String findTenDongSP(UUID id);

    List<ChiTietSP> findDongSPByTen(String ten);

    Page<ChiTietSP> findCTSPByIdDongSP(UUID id, Pageable pageable);

    Page<ChiTietSP> findAllPage(Pageable pageable);

    ChiTietSP saveOrUpdate(ChiTietSPDTO chiTietSPDTO);

    ChiTietSPDTO getCTSPById(UUID id);

    void deleteById(UUID id);

    Integer getSoLuong(UUID idChiTietSP);

    BigDecimal findByGiaBan(UUID id);
}
