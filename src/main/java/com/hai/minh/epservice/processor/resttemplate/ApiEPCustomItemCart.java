package com.hai.minh.epservice.processor.resttemplate;

import com.hai.minh.epservice.dtos.carts.customitem.EPCartItemDto;

public interface ApiEPCustomItemCart {

    EPCartItemDto createCustomItemToCart(EPCartItemDto cartItemDto);
}
