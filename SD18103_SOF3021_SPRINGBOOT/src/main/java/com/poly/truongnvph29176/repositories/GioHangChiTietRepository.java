package com.poly.truongnvph29176.repositories;

import com.poly.truongnvph29176.entities.GioHangChiTiet;
import com.poly.truongnvph29176.model.request.GioHangChiTietRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, GioHangChiTietRequest> {
}
