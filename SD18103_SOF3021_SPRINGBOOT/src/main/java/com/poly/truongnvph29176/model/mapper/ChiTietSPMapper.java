package com.poly.truongnvph29176.model.mapper;

import com.poly.truongnvph29176.entities.ChiTietSP;
import com.poly.truongnvph29176.model.dto.ChiTietSPDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChiTietSPMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ChiTietSP convertToEntity(ChiTietSPDTO chiTietSPDTO) {
        ChiTietSP chiTietSP = modelMapper.map(chiTietSPDTO, ChiTietSP.class);
        return chiTietSP;
    }

    public ChiTietSPDTO convertToDTO(ChiTietSP chiTietSP) {
        ChiTietSPDTO chiTietSPDTO = modelMapper.map(chiTietSP, ChiTietSPDTO.class);
        return chiTietSPDTO;
    }
}
