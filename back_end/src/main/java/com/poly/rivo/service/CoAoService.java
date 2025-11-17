package com.poly.rivo.service;

import com.poly.rivo.entity.CoAo;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.request.CoAoRequest;
import com.poly.rivo.infrastructure.response.CoAoResponse;

public interface CoAoService {
    PhanTrang<CoAoResponse> getAll(CoAoRequest request);

    CoAo getOne(Long id);

    CoAo add(CoAoRequest request);

    CoAo update(Long id, CoAoRequest request);

    CoAo delete(Long id);
}
