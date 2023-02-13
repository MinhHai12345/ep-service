package com.hai.minh.epservice.service.impl;

import com.hai.minh.epservice.commons.constants.Constants;
import com.hai.minh.epservice.dtos.carts.customitem.EPCartDto;
import com.hai.minh.epservice.repository.ep.EPCartRepository;
import com.hai.minh.epservice.service.EPCartService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EPCartServiceImpl implements EPCartService {

    @Autowired
    private EPCartRepository epCartRepository;

    @Override
    public EPCartDto createCart(EPCartDto request) {
        if(StringUtils.isEmpty(request.getName())){
            request.setName(Constants.NEW_CART);
        }
        return epCartRepository.createCartToEPCart(request);
    }

    @Override
    public EPCartDto getCart(String id) {
        return epCartRepository.getCartFromEPCart(id);
    }

    @Override
    public EPCartDto updateCart(String id, EPCartDto request) {
        return epCartRepository.updateCartToEPCart(id, request);
    }

    @Override
    public boolean deleteCart(String id) {
        return epCartRepository.deleteCartFromEPCart(id);
    }
}