package com.poly.truongnvph29176.services.impl;

import com.poly.truongnvph29176.entities.GioHang;
import com.poly.truongnvph29176.entities.KhachHang;
import com.poly.truongnvph29176.model.dto.GioHangDTO;
import com.poly.truongnvph29176.model.dto.KhachHangDTO;
import com.poly.truongnvph29176.model.mapper.GioHangMapper;
import com.poly.truongnvph29176.model.mapper.KhachHangMapper;
import com.poly.truongnvph29176.repositories.GioHangRepository;
import com.poly.truongnvph29176.services.GioHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    private GioHangRepository gioHangRepository;
    @Autowired
    private GioHangMapper gioHangMapper;

    @Override
    public GioHang saveOrUpdate(GioHangDTO gioHangDTO) {
        GioHang gioHang = gioHangMapper.convertToEntity(gioHangDTO);
        return gioHangRepository.save(gioHang);
    }

    @Override
    public GioHang findByKhachHang(UUID idKhachHang) {
        return gioHangRepository.findByKhachHang(idKhachHang);
    }
}
