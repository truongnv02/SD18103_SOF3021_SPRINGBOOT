package com.poly.truongnvph29176.model.mapper;

import com.poly.truongnvph29176.entities.ChucVu;
import com.poly.truongnvph29176.model.dto.ChucVuDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChucVuMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ChucVu convertToEntity(ChucVuDTO chucVuDTO) {
        ChucVu chucVu = modelMapper.map(chucVuDTO, ChucVu.class);
        return chucVu;
    }

    public ChucVuDTO convertToDTO(ChucVu chucVu) {
        ChucVuDTO chucVuDTO = modelMapper.map(chucVu, ChucVuDTO.class);
        return chucVuDTO;
    }
}
