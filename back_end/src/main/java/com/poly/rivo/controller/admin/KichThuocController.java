package com.poly.rivo.controller.admin;


import com.poly.rivo.entity.KichCo;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.KichCoRequest;
import com.poly.rivo.infrastructure.response.KichCoResponse;
import com.poly.rivo.service.KichCoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/size")
public class KichThuocController {
    @Autowired
    private KichCoService kichCoService;

    @GetMapping
    public PhanTrang<KichCoResponse> getAll(KichCoRequest request) {
        return kichCoService.getAll(request);
    }

    @GetMapping("/{id}")
    public KichCo getOne(@PathVariable Long id) {
        return kichCoService.getOne(id);
    }

    @PostMapping
    public ResponseObject create(@RequestBody @Valid KichCoRequest request) {
        return new ResponseObject(kichCoService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id, @RequestBody @Valid KichCoRequest request) {
        return new ResponseObject(kichCoService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id) {
        return new ResponseObject(kichCoService.delete(id));
    }
}
