package com.poly.rivo.service.impl;

import com.poly.rivo.entity.XuatXu;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.converter.XuatXuConvert;
import com.poly.rivo.infrastructure.exception.NgoaiLe;
import com.poly.rivo.infrastructure.request.XuatXuRequest;
import com.poly.rivo.infrastructure.response.XuatXuResponse;
import com.poly.rivo.repository.XuatXuRepository;
import com.poly.rivo.service.XuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service

public class XuatXuServiceImpl implements XuatXuService {
    @Autowired
    private XuatXuRepository repository;

    @Autowired
    private XuatXuConvert xuatXuConvert;

    public PhanTrang<XuatXuResponse> getAll(XuatXuRequest request) {
        return new PhanTrang<>(repository.getAllXuatXu(request, PageRequest.of(request.getPage() - 1, request.getSizePage())));
    }


    public XuatXu getOne(Long id) {
        return repository.findById(id).get();
    }


    public XuatXu add(XuatXuRequest request) {
        if (repository.existsByNameIgnoreCase(request.getName())) {
            throw new NgoaiLe("Xuất xứ " + request.getName() + " đã tồn tại!");
        }
        XuatXu xuatXu = xuatXuConvert.addconvertRequest(request);
        return repository.save(xuatXu);
    }

    public XuatXu update(Long id, XuatXuRequest request) {
        XuatXu name = repository.findById(id).get();
        if (repository.existsByNameIgnoreCase(request.getName())) {
            if (name.getName().equals(request.getName())){
                return repository.save(xuatXuConvert.convertRequestToEntity(name,request));
            }
            throw new NgoaiLe("Xuất xứ " + request.getName() + " đã tồn tại!");
        }
        else {
            return repository.save(xuatXuConvert.convertRequestToEntity(name,request));
        }


    }

    public XuatXu delete(Long id) {
        XuatXu xuatXu = this.getOne(id);
        xuatXu.setDeleted(!xuatXu.getDeleted());
        return repository.save(xuatXu);
    }
}
