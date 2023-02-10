package com.hai.minh.epservice.service;

import com.hai.minh.epservice.dtos.carts.customitem.EPCartItemDto;

import java.util.List;

public interface CartItemService {

    List<EPCartItemDto> getItemCart(String cartId);

    List<EPCartItemDto> createItemToCart(String cartId, EPCartItemDto cartItemDto);

    List<EPCartItemDto> updateItemCart(String cartId, EPCartItemDto cartItemDto);

    boolean deleteItemCart(String cartId, String itemId);
}