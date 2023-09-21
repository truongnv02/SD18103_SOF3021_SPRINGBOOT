package com.poly.truongnvph29176.model.dto;

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
public class KhachHangDTO {
    private UUID id;
    private String ma;

    @NotBlank(message = "Không được để trống")
    private String ten;

    @NotBlank(message = "Không được để trống")
    private String tenDem;

    @NotBlank(message = "Không được để trống")
    private String ho;

    private Date ngaySinh;
    private String sdt;
    private String email;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
    private String matKhau;
}
