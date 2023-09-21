package com.poly.truongnvph29176.services.impl;

import com.poly.truongnvph29176.entities.NhanVien;
import com.poly.truongnvph29176.model.dto.NhanVienDTO;
import com.poly.truongnvph29176.model.mapper.NhanVienMapper;
import com.poly.truongnvph29176.repositories.NhanVienRepository;
import com.poly.truongnvph29176.services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private NhanVienMapper nhanVienMapper;

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien createNhanVien(NhanVienDTO nhanVienDTO) {
        NhanVien nhanVien = nhanVienMapper.convertToEntity(nhanVienDTO);
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien getNhanVienById(UUID id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    @Override
    public NhanVien updateNhanVien(NhanVienDTO nhanVienDTO) {
        NhanVien nhanVien = nhanVienMapper.convertToEntity(nhanVienDTO);
        NhanVien nhanVienId = getNhanVienById(nhanVien.getId());
        return nhanVienRepository.save(nhanVienId);
    }

    @Override
    public void remove(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public String maNVCount() {
        String code = "";
        List<NhanVien> list = getAll();
        if(list.isEmpty()) {
            code = "NV0001";
        }else {
            int max = 0;
            for(NhanVien nv : list) {
                String ma = nv.getMa();
                if(ma.length() > 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if(so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if(max < 10) {
                code = "NV000" + max;
            }else if(max < 100) {
                code = "NV00" + max;
            }else if(max < 1000) {
                code = "NV0" + max;
            }else {
                code = "NV" + max;
            }
        }
        return code;
    }
}
