package com.hai.minh.epservice.processor.resttemplate.impl;

import com.hai.minh.epservice.commons.constants.EPConstants;
import com.hai.minh.epservice.commons.constants.URLConstants;
import com.hai.minh.epservice.config.props.EPConfigProperties;
import com.hai.minh.epservice.dtos.carts.customitem.EPCartDto;
import com.hai.minh.epservice.dtos.common.EPData;
import com.hai.minh.epservice.processor.resttemplate.ApiEPCart;
import com.hai.minh.epservice.utils.EPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ApiEPCartImpl implements ApiEPCart {

    @Autowired
    private EPUtils epUtils;

    @Autowired
    private EPConfigProperties epConfigProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public EPCartDto getCartFromEPCart(String id) {
        try {
            final HttpHeaders headers = epUtils.buildHeaders();
            HttpEntity<?> entity = new HttpEntity<>(headers);
            String url = epConfigProperties.getEpPathV2() + URLConstants.EP_CART_URL
                    + EPConstants.SLASH_SYMBOL + id;

            ResponseEntity<EPData<EPCartDto>> response = restTemplate
                    .exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<EPData<EPCartDto>>() {
                    });

            boolean isSuccess = HttpStatus.OK.equals(response.getStatusCode());
            if (isSuccess && ObjectUtils.isNotEmpty(response.getBody().getData())) {
                return response.getBody().getData();
            }
        } catch (Exception e) {
            log.error("error create cart to ep -- {}", e.getMessage());
        }
        return null;
    }

    @Override
    public EPCartDto createCartToEPCart(EPCartDto request) {
        try {
            final HttpHeaders headers = epUtils.buildHeaders();
            HttpEntity<EPData<EPCartDto>> entity = new HttpEntity<>(new EPData<>(request), headers);
            String url = epConfigProperties.getEpPathV2() + URLConstants.EP_CART_URL;

            ResponseEntity<EPData<EPCartDto>> response = restTemplate
                    .exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<EPData<EPCartDto>>() {
                    });

            boolean isSuccess = HttpStatus.CREATED.equals(response.getStatusCode());
            if (isSuccess && ObjectUtils.isNotEmpty(response.getBody().getData())) {
                return response.getBody().getData();
            }
        } catch (Exception e) {
            log.error("error create cart to ep -- {}", e.getMessage());
        }
        return null;
    }

    @Override
    public EPCartDto updateCartToEPCart(String id, EPCartDto request) {
        try {
            final HttpHeaders headers = epUtils.buildHeaders();
            HttpEntity<EPData<EPCartDto>> entity = new HttpEntity<>(new EPData<>(request), headers);
            String url = epConfigProperties.getEpPathV2() + URLConstants.EP_CART_URL
                    + EPConstants.SLASH_SYMBOL + id;

            ResponseEntity<EPData<EPCartDto>> response = restTemplate
                    .exchange(url, HttpMethod.PUT, entity, new ParameterizedTypeReference<EPData<EPCartDto>>() {
                    });

            boolean isSuccess = HttpStatus.OK.equals(response.getStatusCode());
            if (isSuccess && ObjectUtils.isNotEmpty(response.getBody().getData())) {
                return response.getBody().getData();
            }
        } catch (Exception e) {
            log.error("error create cart to ep -- {}", e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteCartFromEPCart(String id) {
        try {
            final HttpHeaders headers = epUtils.buildHeaders();
            HttpEntity<?> entity = new HttpEntity<>(headers);
            String url = epConfigProperties.getEpPathV2() + URLConstants.EP_CART_URL
                    + EPConstants.SLASH_SYMBOL + id;

            ResponseEntity<?> response = restTemplate
                    .exchange(url, HttpMethod.DELETE, entity, new ParameterizedTypeReference<String>() {
                    });

            boolean isSuccess = HttpStatus.NO_CONTENT.equals(response.getStatusCode());
            if (isSuccess) {
                return true;
            }
        } catch (Exception e) {
            log.error("error create cart to ep -- {}", e.getMessage());
        }
        return false;
    }
}