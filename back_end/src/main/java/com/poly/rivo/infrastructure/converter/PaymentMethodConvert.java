package com.poly.rivo.infrastructure.converter;

import com.poly.rivo.entity.PaymentMethod;
import com.poly.rivo.infrastructure.request.PaymentMethodRequest;
import com.poly.rivo.repository.IBillRepository;
import com.poly.rivo.repository.IPaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodConvert {
    @Autowired
    private IPaymentMethodRepository repository;
    @Autowired
    private IBillRepository billRepository;
    public PaymentMethod convertRequestToEntity(PaymentMethodRequest request){
        return PaymentMethod.builder()
                .method(request.getMethod())
                .totalMoney(request.getTotalMoney())
                .note(request.getNote())
                .tradingCode(request.getTradingCode())
                .bill(billRepository.findById(request.getBill()).orElse(null))
                .type(request.getType())
                .build();
    }
}
