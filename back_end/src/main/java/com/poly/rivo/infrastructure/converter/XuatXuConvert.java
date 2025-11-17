package com.poly.rivo.infrastructure.converter;

import com.poly.rivo.entity.XuatXu;
import com.poly.rivo.infrastructure.request.XuatXuRequest;
import org.springframework.stereotype.Component;

@Component
public class XuatXuConvert {
    public XuatXu addconvertRequest(XuatXuRequest request){
        XuatXu xuatXu = XuatXu.builder()
                .name(request.getName())
                .build();
        return xuatXu;
    }
    public XuatXu convertRequestToEntity(XuatXu entity, XuatXuRequest request){
        entity.setName(request.getName());
        return entity;
    }
}
