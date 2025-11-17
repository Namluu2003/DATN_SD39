package com.poly.rivo.infrastructure.converter;


import com.poly.rivo.entity.MauSac;
import com.poly.rivo.infrastructure.request.MauSacRequest;
import org.springframework.stereotype.Component;

@Component
public class MauSacConvert {

    public MauSac addconvertRequest(MauSacRequest request){
        MauSac mauSac = MauSac.builder()
                .name(request.getName())
                .build();
        return mauSac;
    }

    public MauSac convertRequestToEntity(MauSac entity, MauSacRequest request){
        entity.setName(request.getName());
        return entity;
    }
}
