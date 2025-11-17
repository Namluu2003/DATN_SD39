package com.poly.rivo.service;

import com.poly.rivo.entity.SanPham;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.request.FindSanPhamRequest;
import com.poly.rivo.infrastructure.request.SanPhamRequest;
import com.poly.rivo.infrastructure.response.SanPhamKhuyenMaiRespone;
import com.poly.rivo.infrastructure.response.SanPhamResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface SanPhamService {
    PhanTrang<SanPhamResponse> getAll(FindSanPhamRequest request);
    SanPham getOne(Long id);
    SanPham create(SanPhamRequest request);
    SanPham update(Long id,SanPhamRequest request);
    SanPham delete(Long id);
     SanPham changeStatus(Long id);
    List<SanPhamKhuyenMaiRespone> getAllShoeInPromotion(Long promotion);
    List<SanPhamResponse> getTopSell(Integer top);
    List<SanPhamResponse> getTopSellWithDateFilter(Integer top, LocalDateTime startDate, LocalDateTime endDate);
}
