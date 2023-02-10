package com.hai.minh.epservice.service;

import com.hai.minh.epservice.dtos.carts.customitem.EPCartDto;

public interface EPCartService {
    EPCartDto createCart(EPCartDto request);

    EPCartDto getCart(String reference);

    EPCartDto updateCart(String id, EPCartDto request);

    boolean deleteCart(String id);
}