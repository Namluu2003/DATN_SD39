package com.poly.rivo.service;

import com.poly.rivo.entity.Account;
import com.poly.rivo.infrastructure.common.PhanTrang;
import com.poly.rivo.infrastructure.request.AccountRequest;
import com.poly.rivo.infrastructure.response.AccountResponse;

public interface AccountService {
    PhanTrang<AccountResponse> getAll(AccountRequest request);

    Account getOne(Long id, String roleName);

    Account create(AccountRequest request, String roleName);

    Account update(Long id, AccountRequest request);

    Account delete(Long id);
}
