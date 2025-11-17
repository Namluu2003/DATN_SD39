package com.poly.rivo.controller.admin;

import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.AddressRequest;
import com.poly.rivo.infrastructure.response.AddressResponse;
import com.poly.rivo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping("/{account}")
    public Page<AddressResponse> getByAccount(AddressRequest request){
        return addressService.getByAccount(request);
    }

    @PostMapping
    public ResponseObject create(@RequestBody AddressRequest request) {
        return new ResponseObject(addressService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id,
                                 @RequestBody AddressRequest request) {
        return new ResponseObject(addressService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id) {
        return new ResponseObject(addressService.delete(id));
    }
}
