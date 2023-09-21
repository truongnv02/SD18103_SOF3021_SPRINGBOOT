package com.poly.truongnvph29176.services.impl;

import com.poly.truongnvph29176.entities.NSX;
import com.poly.truongnvph29176.model.dto.NSXDTO;
import com.poly.truongnvph29176.model.mapper.NSXMapper;
import com.poly.truongnvph29176.repositories.NSXRepository;
import com.poly.truongnvph29176.services.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NSXServiceImpl implements NSXService {
    @Autowired
    private NSXRepository nsxRepository;
    @Autowired
    private NSXMapper nsxMapper;

    @Override
    public List<NSX> getAll() {
        return nsxRepository.findAll();
    }

    @Override
    public NSX createNSX(NSXDTO nsxdto) {
        NSX nsx = nsxMapper.convertToEntity(nsxdto);
        return nsxRepository.save(nsx);
    }

    @Override
    public NSX getNSXById(UUID id) {
        return nsxRepository.findById(id).orElse(null);
    }

    @Override
    public NSX updateNSX(NSXDTO nsxdto) {
        NSX nsx = nsxMapper.convertToEntity(nsxdto);
        NSX nsxId = getNSXById(nsx.getId());
        nsxId.setTen(nsxdto.getTen());
        return nsxRepository.save(nsxId);
    }

    @Override
    public void deleteById(UUID id) {
        nsxRepository.deleteById(id);
    }

    @Override
    public String maNSXCount() {
        String code = "";
        List<NSX> list = getAll();
        if(list.isEmpty()) {
            code = "NSX0001";
        }else {
            int max = 0;
            for(NSX nsx : list) {
                String ma = nsx.getMa();
                if(ma.length() > 4) {
                    int so = Integer.parseInt(ma.substring(3));
                    if(so > max) {
                        max = so;
                    }
                }
            }
            max++;
            if(max < 10) {
                code = "NSX000" + max;
            }else if(max < 100) {
                code = "NSX00" + max;
            }else if(max < 1000) {
                code = "NSX0" + max;
            }else {
                code = "NSX" + max;
            }
        }
        return code;
    }
}
