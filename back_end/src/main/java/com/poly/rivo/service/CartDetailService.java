package com.poly.rivo.service;


import com.poly.rivo.infrastructure.request.CartClientRequest;

public interface CartDetailService {
    Boolean deleteCartDetail(Long id);

    String changeQuantity(CartClientRequest cartClientRequest);
}
