package com.poly.rivo.service;

import com.poly.rivo.entity.XuatXu;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.request.XuatXuRequest;
import com.poly.rivo.infrastructure.response.XuatXuResponse;

public interface XuatXuService {
    PhanTrang<XuatXuResponse> getAll(XuatXuRequest request);

    XuatXu getOne(Long id);

    XuatXu add(XuatXuRequest request);

    XuatXu update(Long id, XuatXuRequest request);

    XuatXu delete(Long id);
}
