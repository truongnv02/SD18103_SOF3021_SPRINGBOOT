package com.poly.truongnvph29176.model.mapper;

import com.poly.truongnvph29176.entities.SanPham;
import com.poly.truongnvph29176.model.dto.SanPhamDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SanPhamMapper {
    @Autowired
    private ModelMapper modelMapper;

    public SanPham convertToEntity(SanPhamDTO sanPhamDTO) {
        SanPham sanPham = modelMapper.map(sanPhamDTO, SanPham.class);
        return sanPham;
    }

    public SanPhamDTO convertToDTO(SanPham sanPham) {
        SanPhamDTO sanPhamDTO = modelMapper.map(sanPham, SanPhamDTO.class);
        return sanPhamDTO;
    }
}
