package com.poly.truongnvph29176.model.mapper;

import com.poly.truongnvph29176.entities.CuaHang;
import com.poly.truongnvph29176.model.dto.CuaHangDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CuaHangMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CuaHang convertToEntity(CuaHangDTO cuaHangDTO) {
        CuaHang cuaHang = modelMapper.map(cuaHangDTO, CuaHang.class);
        return cuaHang;
    }

    public CuaHangDTO convertToDTO(CuaHang cuaHang) {
        CuaHangDTO cuaHangDTO = modelMapper.map(cuaHang, CuaHangDTO.class);
        return cuaHangDTO;
    }
}
