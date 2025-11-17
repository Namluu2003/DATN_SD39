package com.poly.rivo.controller.admin;

import com.poly.rivo.entity.BillDetail;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.BillDetailRequest;
import com.poly.rivo.infrastructure.response.BillDetailResponse;
import com.poly.rivo.service.BillDetailTaiQuayService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/bill-detail-taiquay")
public class BillDetailTaiQuayController {
    @Autowired
    private BillDetailTaiQuayService billDetailTaiQuayService;

    @GetMapping
    public PhanTrang<BillDetailResponse> getAll(BillDetailRequest request) {
        return billDetailTaiQuayService.getAll(request);
    }

    @GetMapping("/{id}")
    public BillDetail getOne(@PathVariable Long id) {
        return billDetailTaiQuayService.getOne(id);
    }

    @PostMapping
    public ResponseObject create(@RequestBody @Valid BillDetailRequest request) {
        return new ResponseObject(billDetailTaiQuayService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseObject create(@PathVariable Long id, @RequestBody @Valid BillDetailRequest request) {
        return new ResponseObject(billDetailTaiQuayService.update(id, request));
    }

    @GetMapping("/update-quantity/{id}")
    public ResponseObject updateQuantity(@PathVariable Long id, @RequestParam(required = false, defaultValue = "0") Integer newQuantity, @RequestParam(required = false) BigDecimal price) {
        return new ResponseObject(billDetailTaiQuayService.updateQuantity(id, newQuantity, price));
    }


    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id){
        return new ResponseObject(billDetailTaiQuayService.delete(id));
    }

}