package com.hai.minh.epservice.processor.resttemplate.impl;

import com.hai.minh.epservice.dtos.carts.customitem.EPCartItemDto;
import com.hai.minh.epservice.processor.resttemplate.ApiEPCustomItemCart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApiEPCustomItemCartImpl implements ApiEPCustomItemCart {
    @Override
    public EPCartItemDto createCustomItemToCart(EPCartItemDto cartItemDto) {
        return null;
    }
}