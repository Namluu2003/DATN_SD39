package com.poly.rivo.service;

import com.poly.rivo.entity.KhuyenMai;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.KhuyenMaiRequest;
import com.poly.rivo.infrastructure.response.KhuyenMaiResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KhuyenMaiService {
    PhanTrang<KhuyenMaiResponse> getAll(KhuyenMaiRequest request);
    ResponseObject create(KhuyenMaiRequest request);
    ResponseObject update(Long id,KhuyenMaiRequest request);
    KhuyenMaiResponse getOne(Long id);
    List<Long> getListIdShoePromotion(Long idPromotion);
    List<Long> getListIdShoeDetailInPromotion(@Param("idPromotion") Long idPromotion);
    void deleteAll(Long idPromotion);
    void updateStatusPromotion();
    KhuyenMai updateEndDate(Long id);
    boolean isCodeUnique(String code);
    List<Long> getAllActiveShoeDetailIds();
}
