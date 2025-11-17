package com.poly.rivo.controller.admin;


import com.poly.rivo.entity.ThuongHieu;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.ThuongHieuRequest;
import com.poly.rivo.infrastructure.response.ThuongHieuResponse;
import com.poly.rivo.service.ThuongHieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brand")
public class ThuongHieuController {

    @Autowired
    private ThuongHieuService thuongHieuService;

    @GetMapping
    public PhanTrang<ThuongHieuResponse> getAll(ThuongHieuRequest request) {
        return thuongHieuService.getAll(request);
    }

    @GetMapping("/{id}")
    public ThuongHieu getOne(@PathVariable Long id) {
        return thuongHieuService.getOne(id);
    }

    @PostMapping
    public ResponseObject create(@RequestBody @Valid ThuongHieuRequest request) {
        return new ResponseObject(thuongHieuService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Valid ThuongHieuRequest request) {
        return new ResponseObject(thuongHieuService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id) {
        return new ResponseObject(thuongHieuService.delete(id));

    }
}
