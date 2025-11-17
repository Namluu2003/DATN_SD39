package com.poly.rivo.service;

import com.poly.rivo.entity.TayAo;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.request.TayAoRequest;
import com.poly.rivo.infrastructure.response.TayAoResponse;

public interface TayAoService {
    PhanTrang<TayAoResponse> getAll(TayAoRequest request);

    TayAo getOne(Long id);

    TayAo add(TayAoRequest request);

    TayAo update(Long id, TayAoRequest request);

    TayAo delete(Long id);
}
