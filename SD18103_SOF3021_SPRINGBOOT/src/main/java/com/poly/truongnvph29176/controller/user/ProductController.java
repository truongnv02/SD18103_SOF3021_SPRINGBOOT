package com.poly.truongnvph29176.controller.user;

import com.poly.truongnvph29176.entities.ChiTietSP;
import com.poly.truongnvph29176.entities.DongSP;
import com.poly.truongnvph29176.entities.MauSac;
import com.poly.truongnvph29176.entities.NSX;
import com.poly.truongnvph29176.model.dto.ChiTietSPDTO;
import com.poly.truongnvph29176.services.ChiTietSPService;
import com.poly.truongnvph29176.services.DongSPService;
import com.poly.truongnvph29176.services.MauSacService;
import com.poly.truongnvph29176.services.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private DongSPService dongSPService;
    @Autowired
    private NSXService nsxService;
    @Autowired
    private ChiTietSPService chiTietSPService;

    @GetMapping("/product")
    public String product(Model model, @RequestParam(defaultValue = "0",name = "page") Integer number) {
        Pageable pageable = PageRequest.of(number, 8);
        Page<ChiTietSP> listCTSP = chiTietSPService.findAllPage(pageable);
        List<MauSac> listMauSac = mauSacService.getAll();
        List<DongSP> listDongSP = dongSPService.getAll();
        List<NSX> listNSX = nsxService.getAll();
        model.addAttribute("listMauSac", listMauSac);
        model.addAttribute("listDongSP", listDongSP);
        model.addAttribute("listNSX", listNSX);
        model.addAttribute("listCTSP", listCTSP);
        return "user/san_pham/product";
    }

    @GetMapping("/product-detail/{id}")
    public String productDetail(Model model, @PathVariable("id") UUID id) {
        ChiTietSPDTO chiTietSP = chiTietSPService.getCTSPById(id);
        String tenDongSP = chiTietSPService.findTenDongSP(id);
        List<ChiTietSP> listCTSPByCategory = chiTietSPService.findDongSPByTen(tenDongSP);
        model.addAttribute("productDetail",chiTietSP);
        model.addAttribute("listCTSPByCategory", listCTSPByCategory);
        return "user/san_pham/product-detail";
    }

    @GetMapping("/product-category/{id}")
    public String productByCategoryId(Model model, @PathVariable("id") UUID id,
                                      @RequestParam(defaultValue = "0",name = "page") Integer number) {
        Pageable pageable = PageRequest.of(number, 8);
        Page<ChiTietSP> listCTSPByIdDongSP = chiTietSPService.findCTSPByIdDongSP(id, pageable);
        List<DongSP> listDongSP = dongSPService.getAll();
        model.addAttribute("listCTSP", listCTSPByIdDongSP);
        model.addAttribute("listDongSP", listDongSP);
        model.addAttribute("tag", id);
        return "user/san_pham/product";
    }

    @PostMapping("/search")
    public String search() {
        return null;
    }
}
