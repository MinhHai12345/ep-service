package com.hai.minh.epservice.processor.resttemplate;

import com.hai.minh.epservice.dtos.carts.EPCartDto;

public interface ApiEPCart {
    EPCartDto createCartToEPCart(EPCartDto request);

    EPCartDto getCartFromEPCart(String id);

    EPCartDto updateCartToEPCart(String id, EPCartDto request);

    boolean deleteCartFromEPCart(String id);
}