package com.poly.truongnvph29176.repositories;

import com.poly.truongnvph29176.entities.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
    @Query("select gh from GioHang gh where gh.khachHang.id=:idKhachHang")
    GioHang findByKhachHang(UUID idKhachHang);
}
