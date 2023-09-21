package com.poly.truongnvph29176.model.mapper;

import com.poly.truongnvph29176.entities.MauSac;
import com.poly.truongnvph29176.model.dto.MauSacDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MauSacMapper {
    @Autowired
    private ModelMapper modelMapper;

    public MauSac convertToEntity(MauSacDTO mauSacDTO) {
        MauSac mauSac = modelMapper.map(mauSacDTO, MauSac.class);
        return mauSac;
    }

    public MauSacDTO convertToDTO(MauSac mauSac) {
        MauSacDTO mauSacDTO = modelMapper.map(mauSac, MauSacDTO.class);
        return mauSacDTO;
    }
}
