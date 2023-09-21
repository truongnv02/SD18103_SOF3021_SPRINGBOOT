package com.poly.truongnvph29176.model.mapper;

import com.poly.truongnvph29176.entities.DongSP;
import com.poly.truongnvph29176.model.dto.DongSPDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DongSPMapper {
    @Autowired
    private ModelMapper modelMapper;

    public DongSP convertToEntity(DongSPDTO dongSPDTO) {
        DongSP dongSP = modelMapper.map(dongSPDTO, DongSP.class);
        return dongSP;
    }

    public DongSPDTO convertToDTO(DongSP dongSP) {
        DongSPDTO dongSPDTO = modelMapper.map(dongSP, DongSPDTO.class);
        return dongSPDTO;
    }
}
