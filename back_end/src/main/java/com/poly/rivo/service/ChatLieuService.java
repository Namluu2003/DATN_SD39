package com.poly.rivo.service;

import com.poly.rivo.entity.ChatLieu;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.request.ChatLieuRequest;
import com.poly.rivo.infrastructure.response.ChatLieuResponse;

public interface ChatLieuService {
    PhanTrang<ChatLieuResponse> getAll(ChatLieuRequest request);

    ChatLieu getOne(Long id);

    ChatLieu add(ChatLieuRequest request);

    ChatLieu update(Long id, ChatLieuRequest request);

    ChatLieu delete(Long id);
}
