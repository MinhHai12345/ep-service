package com.hai.minh.epservice.service.impl;

import com.hai.minh.epservice.dtos.carts.customitem.EPCartItemDto;
import com.hai.minh.epservice.processor.resttemplate.ApiEPCustomItemCart;
import com.hai.minh.epservice.service.CartItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private ApiEPCustomItemCart apiEPCustomItemCart;

    @Override
    public List<EPCartItemDto> getItemCart(String cartId) {
        return apiEPCustomItemCart.getCustomItemCart(cartId);
    }

    @Override
    public List<EPCartItemDto> createItemToCart(String cartId, EPCartItemDto cartItemDto) {
        return apiEPCustomItemCart.createCustomItemToCart(cartId, cartItemDto);
    }

    @Override
    public List<EPCartItemDto> updateItemCart(String cartId, EPCartItemDto cartItemDto) {
        return apiEPCustomItemCart.updateCustomItemCart(cartId, cartItemDto);
    }

    @Override
    public boolean deleteItemCart(String cartId, String itemId) {
        return apiEPCustomItemCart.deleteCustomItemCart(cartId, itemId);
    }
}