package com.poly.rivo.service;

import com.poly.rivo.entity.SanPhamChiTiet;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.FindShoeDetailRequest;
import com.poly.rivo.infrastructure.request.SanPhamChiTietRequest;
import com.poly.rivo.infrastructure.request.SanPhamChiTietUpdateRequest;
import com.poly.rivo.infrastructure.response.SanPhamChiTietReponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface SanPhamChiTietService {
    PhanTrang<SanPhamChiTietReponse> getAll(FindShoeDetailRequest request);
    SanPhamChiTiet getOne(Long id);
    String create(List<SanPhamChiTietRequest> list);
    SanPhamChiTiet update(Long id, SanPhamChiTietUpdateRequest request);
    SanPhamChiTiet delete(Long id);
    ResponseObject updateFast(List<SanPhamChiTietRequest> list);
    PhanTrang<SanPhamChiTietReponse> getAllBillDetail(FindShoeDetailRequest request);
    Map<String, BigDecimal> findMinAndMaxPrice();
    SanPhamChiTietReponse getOneShoeDetail(Long id);
}
