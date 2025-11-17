package com.poly.rivo.service.impl;

import com.poly.rivo.entity.TayAo;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.converter.TayAoConvert;
import com.poly.rivo.infrastructure.exception.NgoaiLe;
import com.poly.rivo.infrastructure.request.TayAoRequest;
import com.poly.rivo.infrastructure.response.TayAoResponse;
import com.poly.rivo.repository.TayAoRepository;
import com.poly.rivo.service.TayAoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service

public class TayAoServiceImpl implements TayAoService {
    @Autowired
    private TayAoRepository repository;

    @Autowired
    private TayAoConvert tayAoConvert;

    public PhanTrang<TayAoResponse> getAll(TayAoRequest request) {
        return new PhanTrang<>(repository.getAllTayAo(request, PageRequest.of(request.getPage() - 1, request.getSizePage())));
    }


    public TayAo getOne(Long id) {
        return repository.findById(id).get();
    }


    public TayAo add(TayAoRequest request) {
        if (repository.existsByNameIgnoreCase(request.getName())) {
            throw new NgoaiLe("Tay áo " + request.getName() + " đã tồn tại!");
        }
        TayAo tayAo = tayAoConvert.addconvertRequest(request);
        return repository.save(tayAo);
    }

    public TayAo update(Long id, TayAoRequest request) {
        TayAo name = repository.findById(id).get();
        if (repository.existsByNameIgnoreCase(request.getName())) {
            if (name.getName().equals(request.getName())){
                return repository.save(tayAoConvert.convertRequestToEntity(name,request));
            }
            throw new NgoaiLe("Xuất xứ " + request.getName() + " đã tồn tại!");
        }
        else {
            return repository.save(tayAoConvert.convertRequestToEntity(name,request));
        }


    }

    public TayAo delete(Long id) {
        TayAo tayAo = this.getOne(id);
        tayAo.setDeleted(!tayAo.getDeleted());
        return repository.save(tayAo);
    }
}
