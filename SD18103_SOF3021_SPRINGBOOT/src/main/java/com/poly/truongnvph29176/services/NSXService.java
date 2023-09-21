package com.poly.truongnvph29176.services;

import com.poly.truongnvph29176.entities.NSX;
import com.poly.truongnvph29176.model.dto.NSXDTO;

import java.util.List;
import java.util.UUID;

public interface NSXService {
    List<NSX> getAll();

    NSX createNSX(NSXDTO nsxdto);

    NSX getNSXById(UUID id);

    NSX updateNSX(NSXDTO nsxdto);

    void deleteById(UUID id);

    String maNSXCount();
}
