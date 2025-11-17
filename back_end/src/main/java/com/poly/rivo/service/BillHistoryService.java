package com.poly.rivo.service;

import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.BillHistoryRequest;
import com.poly.rivo.infrastructure.response.BillHistoryResponse;

import java.util.List;

public interface BillHistoryService {
    List<BillHistoryResponse> getByBill(Long idBill);
    ResponseObject create(BillHistoryRequest request);
}

