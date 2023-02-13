package com.hai.minh.epservice.repository.ep;

import com.hai.minh.epservice.dtos.carts.customitem.EPCartItemDto;

import java.util.List;

public interface EPItemCartRepository {

    List<EPCartItemDto> getCustomItemCart(String cartId);

    List<EPCartItemDto> createCustomItemToCart(String cartId, EPCartItemDto cartItemDto);

    List<EPCartItemDto> updateCustomItemCart(String cartId, EPCartItemDto cartItemDto);

    boolean deleteCustomItemCart(String cartId, String itemId);
}
