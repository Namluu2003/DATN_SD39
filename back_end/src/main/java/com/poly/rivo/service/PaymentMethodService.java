package com.poly.rivo.service;

import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.PaymentMethodRequest;
import com.poly.rivo.infrastructure.response.PaymentMethodResponse;

import java.util.List;

public interface PaymentMethodService {
    List<PaymentMethodResponse> getByBill(Long idBill);
    ResponseObject create(PaymentMethodRequest request);
}
