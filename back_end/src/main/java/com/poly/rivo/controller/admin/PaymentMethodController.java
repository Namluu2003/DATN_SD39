package com.poly.rivo.controller.admin;

import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.PaymentMethodRequest;
import com.poly.rivo.infrastructure.response.PaymentMethodResponse;
import com.poly.rivo.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-method")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodService service;
    @GetMapping("/{id}")
    public List<PaymentMethodResponse> getAll(@PathVariable Long id){
        return service.getByBill(id);
    }

    @PostMapping
    public ResponseObject create(@RequestBody PaymentMethodRequest request){
        return service.create(request);
    }
}
