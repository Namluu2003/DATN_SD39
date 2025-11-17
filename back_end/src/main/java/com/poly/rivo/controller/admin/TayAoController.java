package com.poly.rivo.controller.admin;

import com.poly.rivo.entity.TayAo;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.TayAoRequest;
import com.poly.rivo.infrastructure.response.TayAoResponse;
import com.poly.rivo.service.TayAoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tayao")
public class TayAoController {
    @Autowired
    private TayAoService tayAoService;

    @GetMapping
    public PhanTrang<TayAoResponse> getAll(TayAoRequest request) {
        return tayAoService.getAll(request);
    }

    @GetMapping("/{id}")
    public TayAo getOne(@PathVariable Long id) {
        return tayAoService.getOne(id);
    }

    @PostMapping
    public ResponseObject create(@RequestBody @Valid TayAoRequest request) {
        return new ResponseObject(tayAoService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Valid TayAoRequest request) {
        return new ResponseObject(tayAoService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id) {
        return new ResponseObject(tayAoService.delete(id));

    }
}
