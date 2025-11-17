package com.poly.rivo.controller.admin;

import com.poly.rivo.entity.CoAo;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.CoAoRequest;
import com.poly.rivo.infrastructure.response.CoAoResponse;
import com.poly.rivo.service.CoAoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coao")
public class CoAoController {
    @Autowired
    private CoAoService coAoService;

    @GetMapping
    public PhanTrang<CoAoResponse> getAll(CoAoRequest request) {
        return coAoService.getAll(request);
    }

    @GetMapping("/{id}")
    public CoAo getOne(@PathVariable Long id) {
        return coAoService.getOne(id);
    }

    @PostMapping
    public ResponseObject create(@RequestBody @Valid CoAoRequest request) {
        return new ResponseObject(coAoService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Valid CoAoRequest request) {
        return new ResponseObject(coAoService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id) {
        return new ResponseObject(coAoService.delete(id));

    }
}
