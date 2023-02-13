package com.hai.minh.epservice.repository.ep;

import com.hai.minh.epservice.dtos.carts.customitem.EPCartDto;

public interface EPCartRepository {
    EPCartDto createCartToEPCart(EPCartDto request);

    EPCartDto getCartFromEPCart(String id);

    EPCartDto updateCartToEPCart(String id, EPCartDto request);

    boolean deleteCartFromEPCart(String id);
}