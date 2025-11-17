package com.poly.rivo.service.impl;

import com.poly.rivo.entity.KichCo;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.converter.KichCoConvert;
import com.poly.rivo.infrastructure.exception.NgoaiLe;
import com.poly.rivo.infrastructure.request.KichCoRequest;
import com.poly.rivo.infrastructure.response.KichCoResponse;
import com.poly.rivo.repository.KichCoRepository;
import com.poly.rivo.service.KichCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class KichCoServiceImpl implements KichCoService {
    @Autowired
    private KichCoRepository repository;

    @Autowired
    private KichCoConvert kichCoConvert;

    public PhanTrang<KichCoResponse> getAll(KichCoRequest request) {
        return new PhanTrang<>(repository.getAllKichThuoc(request, PageRequest.of(request.getPage() - 1, request.getSizePage())));
    }


    public KichCo getOne(Long id) {
        return repository.findById(id).get();
    }


    public KichCo add(KichCoRequest request) {
        if (repository.existsByNameIgnoreCase(request.getName())) {
            throw new NgoaiLe("Kích cỡ " + request.getName() + " đã tồn tại!");
        }
        KichCo kichCo = kichCoConvert.addconvertRequest(request);
        return repository.save(kichCo);
    }

    public KichCo update(Long id, KichCoRequest request) {
        KichCo name = repository.findById(id).get();
        if (repository.existsByNameIgnoreCase(request.getName())) {
           if (name.getName().equals(request.getName())){
               return repository.save(kichCoConvert.convertRequestToEntity(name,request));
           }
            throw new NgoaiLe("Kích cỡ " + request.getName() + " đã tồn tại!");
        }else {
            return repository.save(kichCoConvert.convertRequestToEntity(name,request));
        }


    }

    public KichCo delete(Long id) {
        KichCo kichCo = this.getOne(id);
        kichCo.setDeleted(!kichCo.getDeleted());
        return repository.save(kichCo);
    }
}
