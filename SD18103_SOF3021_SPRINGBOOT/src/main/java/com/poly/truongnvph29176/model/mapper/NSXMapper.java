package com.poly.truongnvph29176.model.mapper;

import com.poly.truongnvph29176.entities.NSX;
import com.poly.truongnvph29176.model.dto.NSXDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NSXMapper {
    @Autowired
    private ModelMapper modelMapper;

    public NSX convertToEntity(NSXDTO nsxdto) {
        NSX nsx = modelMapper.map(nsxdto, NSX.class);
        return nsx;
    }

    public NSXDTO convertToDTO(NSX nsx) {
        NSXDTO nsxdto = modelMapper.map(nsx, NSXDTO.class);
        return nsxdto;
    }
}
