package com.poly.rivo.controller.admin;

import com.poly.rivo.entity.ChatLieu;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.ChatLieuRequest;
import com.poly.rivo.infrastructure.response.ChatLieuResponse;
import com.poly.rivo.service.ChatLieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatlieu")
public class ChatLieuController {
    @Autowired
    private ChatLieuService chatLieuService;

    @GetMapping
    public PhanTrang<ChatLieuResponse> getAll(ChatLieuRequest request) {
        return chatLieuService.getAll(request);
    }

    @GetMapping("/{id}")
    public ChatLieu getOne(@PathVariable Long id) {
        return chatLieuService.getOne(id);
    }

    @PostMapping
    public ResponseObject create(@RequestBody @Valid ChatLieuRequest request) {
        return new ResponseObject(chatLieuService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Valid ChatLieuRequest request) {
        return new ResponseObject(chatLieuService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id) {
        return new ResponseObject(chatLieuService.delete(id));

    }
}
