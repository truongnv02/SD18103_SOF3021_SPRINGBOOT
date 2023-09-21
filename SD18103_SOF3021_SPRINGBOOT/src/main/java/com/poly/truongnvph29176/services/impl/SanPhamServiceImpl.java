package com.poly.truongnvph29176.services.impl;

import com.poly.truongnvph29176.entities.SanPham;
import com.poly.truongnvph29176.model.dto.SanPhamDTO;
import com.poly.truongnvph29176.model.mapper.SanPhamMapper;
import com.poly.truongnvph29176.repositories.SanPhamRepository;
import com.poly.truongnvph29176.services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private SanPhamMapper sanPhamMapper;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham createSanPham(SanPhamDTO sanPhamDTO, Path path) {
        SanPham sanPham = sanPhamMapper.convertToEntity(sanPhamDTO);
        sanPham.setImageSP(path.toString());
        return sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham saveOrUpdate(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham getSanPhamById(UUID id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public String maSPCount() {
        String code = "";
        List<SanPham> list = getAll();
        if(list.isEmpty()) {
            code = "SP0001";
        }else {
            int max = 0;
            for(SanPham sp : list) {
                String ma = sp.getMa();
                if(ma.length() > 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if(so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if(max < 10) {
                code = "SP000" + max;
            }else if(max < 100) {
                code = "SP00" + max;
            }else if(max < 1000) {
                code = "SP0" + max;
            }else {
                code = "SP" + max;
            }
        }
        return code;
    }
}
