package com.poly.truongnvph29176.repositories;

import com.poly.truongnvph29176.entities.ChiTietSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, UUID> {

    @Query("select c.dongSP.ten from ChiTietSP c where c.id = :id")
    String findTenDongSP(UUID id);

    @Query("select c from ChiTietSP c where c.dongSP.ten = :ten")
    List<ChiTietSP> findCTSPByTenDongSP(String ten);

    @Query("select c from ChiTietSP c where c.dongSP.id = :id")
    Page<ChiTietSP> findCTSPByIdDongSP(UUID id, Pageable pageable);

    @Query("select c from ChiTietSP c where c.dongSP.id = :id")
    List<ChiTietSP> findAllByIdDongSP(UUID id);

    @Query("select c.soLuongTon from ChiTietSP c where c.id = :idChiTietSP")
    Integer getSoLuong(UUID idChiTietSP);

    @Query("select ctsp.giaBan from ChiTietSP ctsp where ctsp.id=:id")
    BigDecimal findByGia(UUID id);
}
