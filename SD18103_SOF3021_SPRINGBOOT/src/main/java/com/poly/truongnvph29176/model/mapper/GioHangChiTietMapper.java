package com.poly.truongnvph29176.model.mapper;

import com.poly.truongnvph29176.entities.GioHangChiTiet;
import com.poly.truongnvph29176.model.dto.GioHangChiTietDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GioHangChiTietMapper {
    @Autowired
    private ModelMapper modelMapper;

    public GioHangChiTiet convertToEntity(GioHangChiTietDTO gioHangChiTietDTO) {
        GioHangChiTiet gioHangChiTiet = modelMapper.map(gioHangChiTietDTO, GioHangChiTiet.class);
        return gioHangChiTiet;
    }

    public GioHangChiTietDTO convertToDTO(GioHangChiTiet gioHangChiTiet) {
        GioHangChiTietDTO gioHangChiTietDTO = modelMapper.map(gioHangChiTiet, GioHangChiTietDTO.class);
        return gioHangChiTietDTO;
    }
}
