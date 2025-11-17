package com.poly.rivo.controller.admin;

import com.poly.rivo.entity.Account;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.AccountRequest;
import com.poly.rivo.infrastructure.response.AccountResponse;
import com.poly.rivo.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private static String ROLE = "Khách hàng";
    @Autowired
    private AccountService accountService;

    @GetMapping
    public PhanTrang<AccountResponse> getAll(AccountRequest request) {
        request.setRoleName(ROLE);
        return accountService.getAll(request);
    }

    @GetMapping("/{id}")
    public Account getOne(@PathVariable Long id) {
        return accountService.getOne(id, ROLE);
    }

    @PostMapping
    public ResponseObject create(@ModelAttribute @Valid AccountRequest request) {
        return new ResponseObject(accountService.create(request, ROLE));
    }

    @PutMapping("/{id}")
    public ResponseObject update(@PathVariable Long id,
                                 @ModelAttribute @Valid AccountRequest request) {
        return new ResponseObject(accountService.update(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Long id) {
        return new ResponseObject(accountService.delete(id));

    }
}
