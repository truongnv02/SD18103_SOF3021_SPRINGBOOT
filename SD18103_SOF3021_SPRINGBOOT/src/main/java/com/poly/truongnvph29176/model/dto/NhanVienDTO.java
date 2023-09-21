package com.poly.truongnvph29176.model.dto;

import com.poly.truongnvph29176.entities.ChucVu;
import com.poly.truongnvph29176.entities.CuaHang;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class NhanVienDTO {
    private UUID id;
    private String ma;
    @NotBlank(message = "Không được để trống")
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String email;
    private String matKhau;
    private CuaHang cuaHang;
    private ChucVu chucVu;
    private Integer trangThai;
}
