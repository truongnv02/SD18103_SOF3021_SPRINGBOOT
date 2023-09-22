package com.poly.truongnvph29176.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class KhachHangDTO {
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

    private Date ngaySinh;
    private String sdt;

    @NotBlank(message = "Không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    private String diaChi;
    private String thanhPho;
    private String quocGia;
    private String matKhau;
}
