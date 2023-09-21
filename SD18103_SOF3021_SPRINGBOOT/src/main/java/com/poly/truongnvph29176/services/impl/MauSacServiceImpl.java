package com.poly.truongnvph29176.services.impl;

import com.poly.truongnvph29176.entities.MauSac;
import com.poly.truongnvph29176.model.dto.MauSacDTO;
import com.poly.truongnvph29176.model.mapper.MauSacMapper;
import com.poly.truongnvph29176.repositories.MauSacRepository;
import com.poly.truongnvph29176.services.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private MauSacMapper mauSacMapper;

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public MauSac saveOrUpdate(MauSacDTO mauSacDTO) {
        MauSac mauSac = mauSacMapper.convertToEntity(mauSacDTO);
        if(mauSac.getId() == null) {
            return mauSacRepository.save(mauSac);
        }else {
            MauSac maSacId = getMauSacById(mauSac.getId());
            maSacId.setTen(mauSacDTO.getTen());
            return mauSacRepository.save(maSacId);
        }
    }

    @Override
    public MauSac getMauSacById(UUID id) {
        return mauSacRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        mauSacRepository.deleteById(id);
    }

    @Override
    public String maMSCount() {
        String code = "";
        List<MauSac> list = getAll();
        if(list.isEmpty()) {
            code = "MS0001";
        }else {
            int max = 0;
            for(MauSac ms : list) {
                String ma = ms.getMa();
                if(ma.length() > 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if (so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if(max < 10) {
                code = "MS000" + max;
            }else if(max < 100) {
                code = "MS00" + max;
            }else if(max < 1000) {
                code = "MS0" + max;
            }else {
                code = "MS" + max;
            }
        }
        return code;
    }
}
