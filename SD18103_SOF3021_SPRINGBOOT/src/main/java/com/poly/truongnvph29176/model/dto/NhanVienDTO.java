package com.poly.truongnvph29176.model.dto;

import com.poly.truongnvph29176.entities.ChucVu;
import com.poly.truongnvph29176.entities.CuaHang;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Size(min = 1, max = 200, message = "số lượng ký tự lớn hơn 1 và nhỏ hơn 200")
    @NotBlank(message = "Không được để trống")
    private String ten;

    @Size(min = 1, max = 200, message = "số lượng ký tự lớn hơn 1 và nhỏ hơn 200")
    @NotBlank(message = "Không được để trống")
    private String tenDem;

    @Size(min = 1, max = 200, message = "số lượng ký tự lớn hơn 1 và nhỏ hơn 200")
    @NotBlank(message = "Không được để trống")
    private String ho;

    @NotNull(message = "Không được để trống")
    private String gioiTinh;

    @NotNull(message = "Không được để trống")
    private Date ngaySinh;

    @Size(min = 1, max = 200, message = "số lượng ký tự lớn hơn 1 và nhỏ hơn 200")
    @NotBlank(message = "Không được để trống")
    private String diaChi;

    @Size(min = 1, max = 200, message = "số lượng ký tự lớn hơn 1 và nhỏ hơn 200")
    @NotBlank(message = "Không được để trống")
    private String sdt;

    @NotBlank(message = "Không được để trống")
    @Email(message = "Email không đúng định dạng")
    @Size(min = 1, max = 30, message = "số lượng ký tự lớn hơn 1 và nhỏ hơn 200")
    private String email;

    @Size(min = 1, max = 200, message = "số lượng ký tự lớn hơn 1 và nhỏ hơn 200")
    @NotBlank(message = "Không được để trống")
    private String matKhau;

    @NotNull(message = "Không được để trống")
    private CuaHang cuaHang;

    @NotNull(message = "Không được để trống")
    private ChucVu chucVu;

    @NotNull(message = "Không được để trống")
    private Integer trangThai;
}
