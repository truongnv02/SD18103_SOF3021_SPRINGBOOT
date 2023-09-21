package com.poly.truongnvph29176.services.impl;

import com.poly.truongnvph29176.entities.DongSP;
import com.poly.truongnvph29176.entities.SanPham;
import com.poly.truongnvph29176.model.dto.DongSPDTO;
import com.poly.truongnvph29176.model.mapper.DongSPMapper;
import com.poly.truongnvph29176.repositories.DongSPRepository;
import com.poly.truongnvph29176.services.DongSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSPServiceImpl implements DongSPService {
    @Autowired
    private DongSPRepository dongSPRepository;
    @Autowired
    private DongSPMapper dongSPMapper;

    @Override
    public List<DongSP> getAll() {
        return dongSPRepository.findAll();
    }

    @Override
    public DongSP saveOrUpdate(DongSPDTO dongSPDTO) {
        DongSP dongSP = dongSPMapper.convertToEntity(dongSPDTO);
        if(dongSP.getId() == null) {
            return dongSPRepository.save(dongSP);
        }else {
            DongSP dongSPId = getDongSPById(dongSP.getId());
            dongSPId.setTen(dongSPDTO.getTen());
            return dongSPRepository.save(dongSPId);
        }
    }

    @Override
    public DongSP getDongSPById(UUID id) {
        return dongSPRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        dongSPRepository.deleteById(id);
    }

    @Override
    public String maDongSPCount() {
        String code = "";
        List<DongSP> list = getAll();
        if(list.isEmpty()) {
            code = "DSP0001";
        }else {
            int max = 0;
            for(DongSP dsp : list) {
                String ma = dsp.getMa();
                if(ma.length() > 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if(so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if(max < 10) {
                code = "DSP000" + max;
            }else if(max < 100) {
                code = "DSP00" + max;
            }else if(max < 1000) {
                code = "DSP0" + max;
            }else {
                code = "DSP" + max;
            }
        }
        return code;
    }
}
