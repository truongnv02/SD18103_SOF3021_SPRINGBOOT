package com.poly.truongnvph29176.model.mapper;

import com.poly.truongnvph29176.entities.GioHang;
import com.poly.truongnvph29176.model.dto.GioHangDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GioHangMapper {
    @Autowired
    private ModelMapper modelMapper;

    public GioHang convertToEntity(GioHangDTO gioHangDTO) {
        GioHang gioHang = modelMapper.map(gioHangDTO, GioHang.class);
        return gioHang;
    }

    public GioHangDTO convertToDTO(GioHang gioHang) {
        GioHangDTO gioHangDTO = modelMapper.map(gioHang, GioHangDTO.class);
        return gioHangDTO;
    }
}
