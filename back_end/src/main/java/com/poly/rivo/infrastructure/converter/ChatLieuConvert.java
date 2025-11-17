package com.poly.rivo.infrastructure.converter;

import com.poly.rivo.entity.ChatLieu;
import com.poly.rivo.infrastructure.request.ChatLieuRequest;
import org.springframework.stereotype.Component;

@Component
public class ChatLieuConvert {
    public ChatLieu addconvertRequest(ChatLieuRequest request){
        ChatLieu chatLieu = ChatLieu.builder()
                .name(request.getName())
                .build();
        return chatLieu;
    }
    public ChatLieu convertRequestToEntity(ChatLieu entity, ChatLieuRequest request){
        entity.setName(request.getName());
        return entity;
    }
}
