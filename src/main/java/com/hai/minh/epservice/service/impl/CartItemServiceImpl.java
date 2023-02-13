package com.hai.minh.epservice.service.impl;

import com.hai.minh.epservice.dtos.carts.customitem.EPCartItemDto;
import com.hai.minh.epservice.repository.ep.EPItemCartRepository;
import com.hai.minh.epservice.service.CartItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private EPItemCartRepository epItemCartRepository;

    @Override
    public List<EPCartItemDto> getItemCart(String cartId) {
        return epItemCartRepository.getCustomItemCart(cartId);
    }

    @Override
    public List<EPCartItemDto> createItemToCart(String cartId, EPCartItemDto cartItemDto) {
        return epItemCartRepository.createCustomItemToCart(cartId, cartItemDto);
    }

    @Override
    public List<EPCartItemDto> updateItemCart(String cartId, EPCartItemDto cartItemDto) {
        return epItemCartRepository.updateCustomItemCart(cartId, cartItemDto);
    }

    @Override
    public boolean deleteItemCart(String cartId, String itemId) {
        return epItemCartRepository.deleteCustomItemCart(cartId, itemId);
    }
}