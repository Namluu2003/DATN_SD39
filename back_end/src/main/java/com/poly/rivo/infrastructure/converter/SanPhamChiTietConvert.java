package com.poly.rivo.infrastructure.converter;

import com.poly.rivo.entity.KichCo;
import com.poly.rivo.entity.MauSac;
import com.poly.rivo.entity.SanPham;
import com.poly.rivo.entity.SanPhamChiTiet;
import com.poly.rivo.infrastructure.common.GenCode;
import com.poly.rivo.infrastructure.request.SanPhamChiTietRequest;
import com.poly.rivo.repository.KichCoRepository;
import com.poly.rivo.repository.MauSacRepository;
import com.poly.rivo.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SanPhamChiTietConvert {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private KichCoRepository kichCoRepository;


    public SanPhamChiTiet convertRequestToEntity(SanPhamChiTietRequest request) {
        SanPham sanPham = sanPhamRepository.findById(request.getShoe()).get();
        MauSac mauSac = mauSacRepository.findById(request.getColor()).get();
        KichCo kichCo = kichCoRepository.findById(request.getSize()).get();

        return SanPhamChiTiet.builder()
                .shoe(sanPham)
                .color(mauSac)
                .size(kichCo)
                .code(GenCode.genCodeByName(sanPham.getCode() + "-" + mauSac.getName() + kichCo.getName())) // Thay getName bằng getCode
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .weight(request.getWeight())
                .build();
    }


public SanPhamChiTiet convertRequestToEntity(SanPhamChiTiet entity, SanPhamChiTietRequest request) {
    SanPham sanPham = sanPhamRepository.findById(request.getShoe()).get();
    MauSac mauSac = mauSacRepository.findById(request.getColor()).get();
    KichCo kichCo = kichCoRepository.findById(request.getSize()).get();

    entity.setShoe(sanPham);
    entity.setColor(mauSac);
    entity.setSize(kichCo);
    entity.setCode(GenCode.genCodeByName(sanPham.getCode() + "-" + mauSac.getName() + kichCo.getName())); // Thay getName bằng getCode
    entity.setPrice(request.getPrice());
    entity.setQuantity(request.getQuantity());
    entity.setWeight(request.getWeight());
    return entity;
}

    public SanPhamChiTiet convertRequestToEntityFast(SanPhamChiTiet entity, SanPhamChiTietRequest request) {
        entity.setPrice(request.getPrice());
        entity.setQuantity(request.getQuantity());
        entity.setWeight(request.getWeight());
        return entity;
    }
}
