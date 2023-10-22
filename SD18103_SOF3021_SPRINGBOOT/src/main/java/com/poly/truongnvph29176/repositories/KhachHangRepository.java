package com.poly.truongnvph29176.repositories;

import com.poly.truongnvph29176.entities.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    @Query("SELECT kh FROM KhachHang kh WHERE kh.email=:email and kh.matKhau=:matKhau")
    public KhachHang login(@Param("email") String email, @Param("matKhau") String matKhau);
}
