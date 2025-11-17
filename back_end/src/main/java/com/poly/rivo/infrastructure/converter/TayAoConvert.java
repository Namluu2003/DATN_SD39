package com.poly.rivo.infrastructure.converter;

import com.poly.rivo.entity.TayAo;
import com.poly.rivo.infrastructure.request.TayAoRequest;
import org.springframework.stereotype.Component;

@Component
public class TayAoConvert {
    public TayAo addconvertRequest(TayAoRequest request){
        TayAo tayAo = TayAo.builder()
                .name(request.getName())
                .build();
        return tayAo;
    }
    public TayAo convertRequestToEntity(TayAo entity, TayAoRequest request){
        entity.setName(request.getName());
        return entity;
    }
}
