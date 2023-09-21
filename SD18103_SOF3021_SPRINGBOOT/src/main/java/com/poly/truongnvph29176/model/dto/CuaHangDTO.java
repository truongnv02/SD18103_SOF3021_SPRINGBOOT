package com.poly.truongnvph29176.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CuaHangDTO {
    private UUID id;
    private String ma;
    private String ten;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
}
