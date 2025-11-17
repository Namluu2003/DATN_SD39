package com.poly.rivo.service;

import com.poly.rivo.entity.Address;
import com.poly.rivo.infrastructure.request.AddressRequest;
import com.poly.rivo.infrastructure.response.AddressResponse;
import org.springframework.data.domain.Page;

public interface AddressService {
    Page<AddressResponse> getByAccount(AddressRequest request);

    Address create(AddressRequest request);

    Address update(Long idAddress, AddressRequest request);

    Address delete(Long idAddress);
}
