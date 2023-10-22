package com.poly.truongnvph29176.services.impl;

import com.poly.truongnvph29176.entities.GioHang;
import com.poly.truongnvph29176.model.dto.ChiTietSPDTO;
import com.poly.truongnvph29176.model.dto.GioHangChiTietDTO;
import com.poly.truongnvph29176.model.dto.KhachHangDTO;
import com.poly.truongnvph29176.model.mapper.ChiTietSPMapper;
import com.poly.truongnvph29176.repositories.GioHangChiTietRepository;
import com.poly.truongnvph29176.services.ChiTietSPService;
import com.poly.truongnvph29176.services.GioHangChiTietService;
import com.poly.truongnvph29176.services.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService {
    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private GioHangChiTietDTO gioHangChiTietDTO;
    @Autowired
    private ChiTietSPMapper chiTietSPMapper;

    @Override
    public int index(UUID id) {
//        return gioHangChiTietRepository.index(id);
        return 0;
    }

    @Override
    public void add(UUID idCTSP, Integer soLuong, KhachHangDTO khachHangDTO) {
        GioHang gioHang = gioHangService.findByKhachHang(khachHangDTO.getId());
        ChiTietSPDTO chiTietSPDTO = chiTietSPService.getCTSPById(idCTSP);
        gioHangChiTietDTO.setChiTietSP(chiTietSPMapper.convertToEntity(chiTietSPDTO));
        gioHangChiTietDTO.setGioHang(gioHang);
        gioHangChiTietDTO.setSoLuong(soLuong);
        gioHangChiTietDTO.setDonGia(chiTietSPService.findByGiaBan(idCTSP));
        int soLuongCu = 0;

    }
}
