package com.poly.rivo.service;

import com.poly.rivo.entity.KichCo;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.request.KichCoRequest;
import com.poly.rivo.infrastructure.response.KichCoResponse;

public interface KichCoService {
    PhanTrang<KichCoResponse> getAll(KichCoRequest request);

    KichCo getOne(Long id);

    KichCo add(KichCoRequest request);

    KichCo update(Long id, KichCoRequest request);

    KichCo delete(Long id);



}
