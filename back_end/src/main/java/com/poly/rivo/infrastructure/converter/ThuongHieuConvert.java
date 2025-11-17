package com.poly.rivo.infrastructure.converter;


import com.poly.rivo.entity.ThuongHieu;
import com.poly.rivo.infrastructure.request.ThuongHieuRequest;
import org.springframework.stereotype.Component;

@Component
public class ThuongHieuConvert {
    public ThuongHieu addconvertRequest(ThuongHieuRequest request){
        ThuongHieu thuongHieu = ThuongHieu.builder()
                .name(request.getName())
                .build();
        return thuongHieu;
    }
    public ThuongHieu convertRequestToEntity(ThuongHieu entity, ThuongHieuRequest request){
        entity.setName(request.getName());
        return entity;
    }
}
