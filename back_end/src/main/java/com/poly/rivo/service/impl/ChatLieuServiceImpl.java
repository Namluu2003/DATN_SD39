package com.poly.rivo.service.impl;

import com.poly.rivo.entity.ChatLieu;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.converter.ChatLieuConvert;
import com.poly.rivo.infrastructure.exception.NgoaiLe;
import com.poly.rivo.infrastructure.request.ChatLieuRequest;
import com.poly.rivo.infrastructure.response.ChatLieuResponse;
import com.poly.rivo.repository.ChatLieuRepository;
import com.poly.rivo.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
    private ChatLieuRepository repository;

    @Autowired
    private ChatLieuConvert chatLieuConvert;

    public PhanTrang<ChatLieuResponse> getAll(ChatLieuRequest request) {
        return new PhanTrang<>(repository.getAllChatLieu(request, PageRequest.of(request.getPage() - 1, request.getSizePage())));
    }


    public ChatLieu getOne(Long id) {
        return repository.findById(id).get();
    }


    public ChatLieu add(ChatLieuRequest request) {
        if (repository.existsByNameIgnoreCase(request.getName())) {
            throw new NgoaiLe("Chất liệu " + request.getName() + " đã tồn tại!");
        }
        ChatLieu chatLieu = chatLieuConvert.addconvertRequest(request);
        return repository.save(chatLieu);
    }

    public ChatLieu update(Long id, ChatLieuRequest request) {
        ChatLieu name = repository.findById(id).get();
        if (repository.existsByNameIgnoreCase(request.getName())) {
            if (name.getName().equals(request.getName())){
                return repository.save(chatLieuConvert.convertRequestToEntity(name,request));
            }
            throw new NgoaiLe("Chất liệu " + request.getName() + " đã tồn tại!");
        }
        else {
            return repository.save(chatLieuConvert.convertRequestToEntity(name,request));
        }


    }

    public ChatLieu delete(Long id) {
        ChatLieu chatLieu = this.getOne(id);
        chatLieu.setDeleted(!chatLieu.getDeleted());
        return repository.save(chatLieu);
    }
}
