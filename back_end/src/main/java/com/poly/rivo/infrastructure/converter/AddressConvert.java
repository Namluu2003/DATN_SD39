package com.poly.rivo.infrastructure.converter;

import com.poly.rivo.entity.Address;
import com.poly.rivo.infrastructure.request.AddressRequest;
import com.poly.rivo.repository.AccountRepository;
import com.poly.rivo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressConvert {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AccountRepository accountRepository;
    public Address convertRequestToEntity(AddressRequest request) {
        return Address.builder()
                .account(request.getAccount() != null ? accountRepository.findById(request.getAccount()).orElse(null) : null)
                .name(request.getName())
                .defaultAddress(false)
                .ward(request.getWard())
                .district(request.getDistrict())
                .province(request.getProvince())
                .phoneNumber(request.getPhoneNumber())
                .specificAddress(request.getSpecificAddress())
                .build();
    }
    public Address convertRequestToEntity(Long id, AddressRequest request){
        Address address = addressRepository.findById(id).get();
        address.setSpecificAddress(request.getSpecificAddress());
        address.setDefaultAddress(request.getDefaultAddress());
        address.setName(request.getName());
        address.setWard(request.getWard());
        address.setDistrict(request.getDistrict());
        address.setProvince(request.getProvince());
        address.setPhoneNumber(request.getPhoneNumber());
        return address;
    }
}
