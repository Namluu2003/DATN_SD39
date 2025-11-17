package com.poly.rivo.controller.admin;

import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.BillHistoryRequest;
import com.poly.rivo.infrastructure.response.BillHistoryResponse;
import com.poly.rivo.service.BillHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill-history")
public class BillHistoryController {
    @Autowired
    private BillHistoryService billHistoryService;
    @GetMapping("/{idBill}")
    public List<BillHistoryResponse> getByBill(@PathVariable("idBill") Long id){
        return billHistoryService.getByBill(id);
    }
    @PostMapping
    public ResponseObject create(@RequestBody BillHistoryRequest request){
        return billHistoryService.create(request);
    }
}
