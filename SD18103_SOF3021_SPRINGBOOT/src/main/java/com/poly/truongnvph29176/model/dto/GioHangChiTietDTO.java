package com.poly.truongnvph29176.model.dto;

import com.poly.truongnvph29176.entities.ChiTietSP;
import com.poly.truongnvph29176.entities.GioHang;
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
public class GioHangChiTietDTO {
    private UUID id;
    private GioHang gioHang;
    private ChiTietSP chiTietSP;
    private Integer soLuong;
    private BigDecimal donGia;
    private BigDecimal donGiaKhiGiam;
}
