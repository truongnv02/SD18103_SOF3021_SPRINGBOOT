package com.poly.truongnvph29176.model.dto;

import com.poly.truongnvph29176.entities.DongSP;
import com.poly.truongnvph29176.entities.MauSac;
import com.poly.truongnvph29176.entities.NSX;
import com.poly.truongnvph29176.entities.SanPham;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ChiTietSPDTO {
    private UUID id;

    @NotNull(message = "Không được để trống")
    private SanPham sanPham;

    @NotNull(message = "Không được để trống")
    private NSX nsx;

    @NotNull(message = "Không được để trống")
    private MauSac mauSac;

    @NotNull(message = "Không được để trống")
    private DongSP dongSP;

    @NotNull(message = "Không được để trống")
    @Max(value = 3, message = "Năm bảo hành không quá ")
    private Integer namBH;

//    @Size(min = 1, max = 200, message = "số lượng ký tự lớn hơn 1 và nhỏ hơn 200")
//    @NotBlank(message = "Không được để trống")
    private String moTa;

    @Min(value = 1, message = "Số lượng phải lớn hơn 1")
    @Max(value = 1000, message = "Số lượng phải nhỏ hơn 1000")
    @NotNull(message = "Không được để trống")
    private Integer soLuongTon;

    @DecimalMin(value = "0.0", message = "Giá nhập không được nhỏ hơn 0")
    @DecimalMax(value = "1000000000.0", message = "Giá nhập không được lớn hơn 1000000000")
    @NotNull(message = "Không được để trống")
    private BigDecimal giaNhap;

    @DecimalMin(value = "0.0", message = "Giá bán không được nhỏ hơn 0")
    @DecimalMax(value = "1000000000.0", message = "Giá bán không được lớn hơn 1000000000")
    @NotNull(message = "Không được để trống")
    private BigDecimal giaBan;
}
