package com.poly.rivo.service;


import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.request.CartClientRequest;
import com.poly.rivo.infrastructure.response.CartResponse;

import java.util.List;

public interface CartService {
    List<CartResponse> getListCart(Long idAccount);
    ResponseObject create(CartClientRequest request);
    ResponseObject updateQuantity(CartClientRequest request);
    ResponseObject deleteById(Long idCartDetail);
    ResponseObject deleteAll(Long idAccount);
}
