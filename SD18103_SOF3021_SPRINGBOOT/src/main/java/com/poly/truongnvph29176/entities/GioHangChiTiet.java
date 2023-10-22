package com.poly.truongnvph29176.entities;

import com.poly.truongnvph29176.model.request.GioHangChiTietRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "GioHangChiTiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(GioHangChiTietRequest.class)
public class GioHangChiTiet implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "IdGioHang")
    private GioHang gioHang;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSP chiTietSP;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;
}
