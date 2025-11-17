package com.poly.rivo.controller.admin;

import com.poly.rivo.entity.XuatXu;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.XuatXuRequest;
import com.poly.rivo.infrastructure.response.XuatXuResponse;
import com.poly.rivo.service.XuatXuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/xuatxu")
public class XuatXuController {
    @Autowired
    private XuatXuService xuatXuService;

    @GetMapping
    public PhanTrang<XuatXuResponse> getAll(XuatXuRequest request) {
        return xuatXuService.getAll(request);
    }

    @GetMapping("/{id}")
    public XuatXu getOne(@PathVariable Long id) {
        return xuatXuService.getOne(id);
    }

    @PostMapping
    public ResponseObject create(@RequestBody @Valid XuatXuRequest request) {
        return new ResponseObject(xuatXuService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Valid XuatXuRequest request) {
        return new ResponseObject(xuatXuService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id) {
        return new ResponseObject(xuatXuService.delete(id));

    }
}
