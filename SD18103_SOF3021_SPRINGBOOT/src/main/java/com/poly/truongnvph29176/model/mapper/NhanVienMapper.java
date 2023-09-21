package com.poly.truongnvph29176.model.mapper;

import com.poly.truongnvph29176.entities.NhanVien;
import com.poly.truongnvph29176.model.dto.NhanVienDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NhanVienMapper {

    @Autowired
    private ModelMapper modelMapper;

    public NhanVien convertToEntity(NhanVienDTO nhanVienDTO) {
        NhanVien nhanVien = modelMapper.map(nhanVienDTO, NhanVien.class);
        return nhanVien;
    }

    public NhanVienDTO convertToDTO(NhanVien nhanVien) {
        NhanVienDTO nhanVienDTO = modelMapper.map(nhanVien, NhanVienDTO.class);
        return nhanVienDTO;
    }
}
