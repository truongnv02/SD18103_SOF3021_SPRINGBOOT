package com.poly.truongnvph29176.repositories;

import com.poly.truongnvph29176.entities.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query("select nv from NhanVien nv where nv.email =: email and nv.matKhau =: matKhau")
    public NhanVien login(@Param("email") String email, @Param("matKhau") String password);
}
