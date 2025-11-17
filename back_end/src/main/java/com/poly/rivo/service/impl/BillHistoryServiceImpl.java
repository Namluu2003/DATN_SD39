package com.poly.rivo.service.impl;

import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.converter.BillHistoryConvert;
import com.poly.rivo.infrastructure.request.BillHistoryRequest;
import com.poly.rivo.infrastructure.response.BillHistoryResponse;
import com.poly.rivo.repository.IBillHistoryRepository;
import com.poly.rivo.service.BillHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillHistoryServiceImpl implements BillHistoryService {
    @Autowired
    private IBillHistoryRepository repository;
    @Autowired
    private BillHistoryConvert billHistoryConvert;

    @Override
    public List<BillHistoryResponse> getByBill(Long idBill) {
        return repository.getByBill(idBill);
    }

    @Override
    public ResponseObject create(BillHistoryRequest request) {
        return new ResponseObject(billHistoryConvert.convertRequestToEntity(request));
    }
}
