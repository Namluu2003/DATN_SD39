package com.poly.rivo.controller.admin;

import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.FindShoeDetailRequest;
import com.poly.rivo.infrastructure.request.bill.BillSearchRequest;
import com.poly.rivo.infrastructure.response.BillResponse;
import com.poly.rivo.infrastructure.response.SanPhamChiTietReponse;
import com.poly.rivo.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/statistical")
public class ThongKeController {
    @Autowired
    private ThongKeService thongKeService;

    @GetMapping("/day")
    public ResponseObject statisticalDay() {
        return new ResponseObject(thongKeService.getAllStatisticalDay());
    }

    @GetMapping("/week")
    public ResponseObject statisticalWeek() {
        return new ResponseObject(thongKeService.getAllStatisticalWeek());
    }

    @GetMapping("/month")
    public ResponseObject statisticalMonth() {
        return new ResponseObject(thongKeService.getAllStatisticalMonth());
    }

    @GetMapping("/year")
    public ResponseObject statisticalYear() {
        return new ResponseObject(thongKeService.getAllStatisticalYear());
    }

    @GetMapping("/custom")
    public ResponseObject statisticalCustom(@RequestParam Long fromDate, @RequestParam Long toDate) {
        return new ResponseObject(thongKeService.getStatisticalCustom(fromDate, toDate));
    }

    @GetMapping("/daterange")
    public PhanTrang<BillResponse> getStatisticalByDateRange(BillSearchRequest request) {
        return thongKeService.getStatisticalByDateRange(request);
    }

    @GetMapping("/near-expired-products")
    public PhanTrang<SanPhamChiTietReponse> getNearExpiredProducts(FindShoeDetailRequest request) {
        return thongKeService.getNearExpiredProducts(request);
    }


}