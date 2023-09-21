package com.poly.truongnvph29176.services.impl;

import com.poly.truongnvph29176.entities.KhachHang;
import com.poly.truongnvph29176.model.dto.KhachHangDTO;
import com.poly.truongnvph29176.model.mapper.KhachHangMapper;
import com.poly.truongnvph29176.repositories.KhachHangRepository;
import com.poly.truongnvph29176.services.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private KhachHangMapper khachHangMapper;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang createKhachHang(KhachHangDTO khachHangDTO) {
        KhachHang khachHang = khachHangMapper.convertToEntity(khachHangDTO);
        return khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang getKhachHangById(UUID id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public KhachHang updateKhachHang(KhachHangDTO khachHangDTO) {
        KhachHang khachHang = khachHangMapper.convertToEntity(khachHangDTO);
        KhachHang khachHangId = getKhachHangById(khachHang.getId());
        khachHangId.setTen(khachHangDTO.getTen());
        khachHangId.setTenDem(khachHangDTO.getTenDem());
        khachHangId.setHo(khachHangDTO.getHo());
        khachHangId.setNgaySinh(khachHangDTO.getNgaySinh());
        khachHangId.setSdt(khachHangDTO.getSdt());
        khachHangId.setEmail(khachHangDTO.getEmail());
        khachHangId.setDiaChi(khachHangDTO.getDiaChi());
        khachHangId.setThanhPho(khachHangDTO.getThanhPho());
        khachHangId.setQuocGia(khachHangDTO.getQuocGia());
        return khachHangRepository.save(khachHangId);
    }

    @Override
    public void remove(UUID id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public String maKHCount() {
        String code = "";
        List<KhachHang> list = getAll();
        if(list.isEmpty()) {
            code = "KH0001";
        }else {
            int max = 0;
            for(KhachHang kh : list) {
                String ma = kh.getMa();
                if(ma.length() > 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if(so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if(max < 10) {
                code = "KH000" + max;
            }else if(max < 100) {
                code = "KH00" + max;
            }else if(max < 1000) {
                code = "KH0" + max;
            }else {
                code = "KH" + max;
            }
        }
        return code;
    }
}
