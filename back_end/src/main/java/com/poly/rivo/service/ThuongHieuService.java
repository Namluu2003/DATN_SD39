package com.poly.rivo.service;


import com.poly.rivo.entity.ThuongHieu;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.request.ThuongHieuRequest;
import com.poly.rivo.infrastructure.response.ThuongHieuResponse;

public interface ThuongHieuService {
    PhanTrang<ThuongHieuResponse> getAll(ThuongHieuRequest request);

    ThuongHieu getOne(Long id);

    ThuongHieu add(ThuongHieuRequest request);

    ThuongHieu update(Long id, ThuongHieuRequest request);

    ThuongHieu delete(Long id);

}
