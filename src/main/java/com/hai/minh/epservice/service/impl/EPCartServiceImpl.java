package com.hai.minh.epservice.service.impl;

import com.hai.minh.epservice.commons.constants.Constants;
import com.hai.minh.epservice.dtos.carts.EPCartDto;
import com.hai.minh.epservice.processor.resttemplate.ApiEPCart;
import com.hai.minh.epservice.service.EPCartService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EPCartServiceImpl implements EPCartService {

    @Autowired
    private ApiEPCart apiEPCart;

    @Override
    public EPCartDto createCart(EPCartDto request) {
        if(StringUtils.isEmpty(request.getName())){
            request.setName(Constants.NEW_CART);
        }
        return apiEPCart.createCartToEPCart(request);
    }

    @Override
    public EPCartDto getCart(String id) {
        return apiEPCart.getCartFromEPCart(id);
    }

    @Override
    public EPCartDto updateCart(String id, EPCartDto request) {
        return apiEPCart.updateCartToEPCart(id, request);
    }

    @Override
    public boolean deleteCart(String id) {
        return apiEPCart.deleteCartFromEPCart(id);
    }
}