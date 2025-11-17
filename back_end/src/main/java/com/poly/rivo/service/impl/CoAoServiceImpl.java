package com.poly.rivo.service.impl;

import com.poly.rivo.entity.CoAo;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.converter.CoAoConvert;
import com.poly.rivo.infrastructure.exception.NgoaiLe;
import com.poly.rivo.infrastructure.request.CoAoRequest;
import com.poly.rivo.infrastructure.response.CoAoResponse;
import com.poly.rivo.repository.CoAoRepository;
import com.poly.rivo.service.CoAoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CoAoServiceImpl implements CoAoService {
    @Autowired
    private CoAoRepository repository;

    @Autowired
    private CoAoConvert coAoConvert;

    public PhanTrang<CoAoResponse> getAll(CoAoRequest request) {
        return new PhanTrang<>(repository.getAllCoAo(request, PageRequest.of(request.getPage() - 1, request.getSizePage())));
    }


    public CoAo getOne(Long id) {
        return repository.findById(id).get();
    }


    public CoAo add(CoAoRequest request) {
        if (repository.existsByNameIgnoreCase(request.getName())) {
            throw new NgoaiLe("Cổ áo " + request.getName() + " đã tồn tại!");
        }
        CoAo coAo = coAoConvert.addconvertRequest(request);
        return repository.save(coAo);
    }

    public CoAo update(Long id, CoAoRequest request) {
        CoAo name = repository.findById(id).get();
        if (repository.existsByNameIgnoreCase(request.getName())) {
            if (name.getName().equals(request.getName())){
                return repository.save(coAoConvert.convertRequestToEntity(name,request));
            }
            throw new NgoaiLe("Cổ áo " + request.getName() + " đã tồn tại!");
        }
        else {
            return repository.save(coAoConvert.convertRequestToEntity(name,request));
        }


    }

    public CoAo delete(Long id) {
        CoAo coAo = this.getOne(id);
        coAo.setDeleted(!coAo.getDeleted());
        return repository.save(coAo);
    }
}
