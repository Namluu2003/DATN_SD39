package com.poly.rivo.infrastructure.converter;

import com.poly.rivo.entity.Bill;
import com.poly.rivo.entity.BillDetail;
import com.poly.rivo.entity.KhuyenMaiChiTiet;
import com.poly.rivo.entity.SanPhamChiTiet;
import com.poly.rivo.infrastructure.request.BillDetailRequest;
import com.poly.rivo.repository.IBillRepository;
import com.poly.rivo.repository.KhuyenMaiChiTietRepository;
import com.poly.rivo.repository.SanPhamChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillDetailConvert {
    @Autowired
    private IBillRepository billRepository;
    @Autowired
    private SanPhamChiTietRepository shoeDetailRepository;
    @Autowired
    private KhuyenMaiChiTietRepository khuyenMaiChiTietRepository;
    public BillDetail convertRequestToEntity(BillDetailRequest request) {
        SanPhamChiTiet shoeDetail = shoeDetailRepository.findByCode(request.getShoeDetail());
        Bill bill = billRepository.findById(request.getBill()).get();
        KhuyenMaiChiTiet khuyenMaiChiTiet = khuyenMaiChiTietRepository.findByShoeDetailCode(request.getShoeDetail());
        return BillDetail.builder()
                .shoeDetail(shoeDetail)
                .bill(bill)
                .price(khuyenMaiChiTiet != null ? khuyenMaiChiTiet.getPromotionPrice() : shoeDetail.getPrice())
                .quantity(request.getQuantity())
                .build();
    }

    public BillDetail convertRequestToEntity(BillDetail entity, BillDetailRequest request) {
        SanPhamChiTiet shoeDetail = shoeDetailRepository.findByCode(request.getShoeDetail());
        Bill bill = billRepository.findById(request.getBill()).get();
        KhuyenMaiChiTiet khuyenMaiChiTiet = khuyenMaiChiTietRepository.findByShoeDetailCode(request.getShoeDetail());

        entity.setShoeDetail(shoeDetail);
        entity.setBill(bill);
        entity.setPrice((khuyenMaiChiTiet != null ? khuyenMaiChiTiet.getPromotionPrice() : shoeDetail.getPrice()));
        entity.setQuantity(entity.getQuantity() + request.getQuantity());
        return entity;
    }
}
