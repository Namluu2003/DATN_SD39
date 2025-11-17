package com.poly.rivo.service;

import com.poly.rivo.entity.BillDetail;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.request.BillDetailRequest;
import com.poly.rivo.infrastructure.response.BillDetailResponse;

import java.math.BigDecimal;

public interface BillDetailService {
    PhanTrang<BillDetailResponse> getAll(BillDetailRequest request);

    BillDetail getOne(Long id);
    BillDetail create(BillDetailRequest request);
//    BillDetail update(Long id,BillDetailRequest request);
    BillDetail delete(Long id);

    BillDetail updateQuantity(Long id, Integer newQuantity, BigDecimal price);
    Float getLatestDiscountPercent(String shoeDetailCode, Long billId);

}
