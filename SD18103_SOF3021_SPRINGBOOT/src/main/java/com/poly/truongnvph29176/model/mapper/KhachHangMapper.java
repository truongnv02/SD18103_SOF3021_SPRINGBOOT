package com.poly.truongnvph29176.model.mapper;

import com.poly.truongnvph29176.entities.KhachHang;
import com.poly.truongnvph29176.model.dto.KhachHangDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KhachHangMapper {

    @Autowired
    private ModelMapper modelMapper;

    public KhachHang convertToEntity(KhachHangDTO khachHangDTO) {
        KhachHang khachHang = modelMapper.map(khachHangDTO, KhachHang.class);
        return khachHang;
    }

    public KhachHangDTO convertToDTO(KhachHang khachHang) {
        KhachHangDTO khachHangDTO = modelMapper.map(khachHang, KhachHangDTO.class);
        return khachHangDTO;
    }
}
