package com.poly.rivo.controller.admin;

import com.poly.rivo.entity.SanPhamChiTiet;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.FindShoeDetailRequest;
import com.poly.rivo.infrastructure.request.SanPhamChiTietRequest;
import com.poly.rivo.infrastructure.request.SanPhamChiTietUpdateRequest;
import com.poly.rivo.service.SanPhamChiTietService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shoe-detail")
public class SanPhamChiTietController {

    @Autowired
    private SanPhamChiTietService sanPhamChiTietService;

    @GetMapping
    public PhanTrang getAll(FindShoeDetailRequest request) {
        return sanPhamChiTietService.getAll(request);
    }

    @GetMapping("/getAllBillDetail")
    public PhanTrang getAllBillDetail(FindShoeDetailRequest request) {
        return sanPhamChiTietService.getAllBillDetail(request);
    }

    @GetMapping("/{id}")
    public SanPhamChiTiet getOne(@PathVariable Long id) {
        return sanPhamChiTietService.getOne(id);
    }

    @GetMapping("/get-one/{id}")
    public ResponseObject getOneShoeDetail(@PathVariable Long id) {
        return new ResponseObject(sanPhamChiTietService.getOneShoeDetail(id));
    }


    @GetMapping("/find-min-max-price")
    public Map<String, BigDecimal> findMinAndMaxPrice() {
        return sanPhamChiTietService.findMinAndMaxPrice();
    }

    @PostMapping
    public ResponseObject create(@RequestBody List<SanPhamChiTietRequest> list) {
        list.forEach(request -> System.out.println(request));
        return new ResponseObject(sanPhamChiTietService.create(list));
    }


    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Valid SanPhamChiTietUpdateRequest request) {
        return new ResponseObject(sanPhamChiTietService.update(id, request));
    }

    @PutMapping("/update-fast")
    public ResponseObject updateFast(@RequestBody List<SanPhamChiTietRequest> list) {
        list.forEach(request -> System.out.println(request));
        return new ResponseObject(sanPhamChiTietService.updateFast(list));
    }


}
