package com.poly.rivo.service;

import com.poly.rivo.entity.MauSac;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.request.MauSacRequest;
import com.poly.rivo.infrastructure.response.MauSacResponse;


public interface MauSacService {
    PhanTrang<MauSacResponse> getAll(MauSacRequest request);

    MauSac getOne(Long id);
    MauSac create(MauSacRequest request);
    MauSac update(Long id, MauSacRequest request);
    MauSac delete(Long id);
}
