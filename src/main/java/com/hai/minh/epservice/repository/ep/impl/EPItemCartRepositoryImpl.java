package com.hai.minh.epservice.repository.ep.impl;

import com.hai.minh.epservice.commons.constants.EPConstants;
import com.hai.minh.epservice.commons.constants.URLConstants;
import com.hai.minh.epservice.config.props.EPConfigProperties;
import com.hai.minh.epservice.dtos.carts.customitem.EPCartItemDto;
import com.hai.minh.epservice.dtos.common.EPData;
import com.hai.minh.epservice.repository.ep.EPItemCartRepository;
import com.hai.minh.epservice.utils.EPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class EPItemCartRepositoryImpl implements EPItemCartRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EPUtils epUtils;

    @Autowired
    private EPConfigProperties epConfigProperties;

    @Override
    public List<EPCartItemDto> getCustomItemCart(String cartId) {
        try {
            HttpHeaders headers = epUtils.buildHeaders();
            HttpEntity<Void> entity = new HttpEntity<>(headers);
            String url = epConfigProperties.getEpPathV2() + URLConstants.EP_CART_URL
                    + EPConstants.SLASH_SYMBOL + cartId + URLConstants.URL_ITEMS;

            EPData<List<EPCartItemDto>> response = restTemplate
                    .exchange(url, HttpMethod.GET, entity,
                            new ParameterizedTypeReference<EPData<List<EPCartItemDto>>>() {
                            })
                    .getBody();
            if (response != null && CollectionUtils.isNotEmpty(response.getData())) {
                log.info("Get custom item cart success with id {}", response.getData());
                return response.getData();
            }
        } catch (Exception e) {
            log.error("failed to get cart item -- {}", e.getMessage());
        }
        return null;
    }

    @Override
    public List<EPCartItemDto> createCustomItemToCart(String cartId, EPCartItemDto cartItemDto) {
        try {
            HttpHeaders headers = epUtils.buildHeaders();
            HttpEntity<EPData<EPCartItemDto>> entity = new HttpEntity<>(new EPData<>(cartItemDto), headers);
            String url = epConfigProperties.getEpPathV2() + URLConstants.EP_CART_URL
                    + EPConstants.SLASH_SYMBOL + cartId + URLConstants.URL_ITEMS;

            EPData<List<EPCartItemDto>> response = restTemplate
                    .exchange(url, HttpMethod.POST, entity,
                            new ParameterizedTypeReference<EPData<List<EPCartItemDto>>>() {
                            })
                    .getBody();
            if (response != null && CollectionUtils.isNotEmpty(response.getData())) {
                log.info("Create custom item cart success with id {}", response.getData());
                return response.getData();
            }
        } catch (Exception e) {
            log.error("failed to create custom item to cart -- {}", e.getMessage());
        }
        return null;
    }

    @Override
    public List<EPCartItemDto> updateCustomItemCart(String cartId, EPCartItemDto cartItemDto) {
        try {
            HttpHeaders headers = epUtils.buildHeaders();
            HttpEntity<EPData<EPCartItemDto>> entity = new HttpEntity<>(new EPData<>(cartItemDto), headers);
            String url = epConfigProperties.getEpPathV2() + URLConstants.EP_CART_URL
                    + EPConstants.SLASH_SYMBOL + cartId
                    + URLConstants.URL_ITEMS + EPConstants.SLASH_SYMBOL + cartItemDto.getId();

            EPData<List<EPCartItemDto>> response = restTemplate
                    .exchange(url, HttpMethod.PUT, entity,
                            new ParameterizedTypeReference<EPData<List<EPCartItemDto>>>() {
                            })
                    .getBody();
            if (response != null && CollectionUtils.isNotEmpty(response.getData())) {
                log.info("Update custom item cart success with id {}", response.getData());
                return response.getData();
            }
        } catch (Exception e) {
            log.error("failed to update cart item -- {}", e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteCustomItemCart(String cartId, String itemId) {
        try {
            HttpHeaders headers = epUtils.buildHeaders();
            HttpEntity<Void> entity = new HttpEntity<>(headers);
            String url = epConfigProperties.getEpPathV2() + URLConstants.EP_CART_URL
                    + EPConstants.SLASH_SYMBOL + cartId
                    + URLConstants.URL_ITEMS + EPConstants.SLASH_SYMBOL + itemId;

            ResponseEntity<?> response = restTemplate
                    .exchange(url, HttpMethod.DELETE, entity,
                            new ParameterizedTypeReference<String>() {
                            });
            boolean isSuccessful = HttpStatus.OK.equals(response.getStatusCode());
            if (isSuccessful) {
                log.info("Delete custom item cart success with cart id {} and item id {}", cartId, itemId);
                return true;
            }
        } catch (Exception e) {
            log.error("failed to delete cart item -- {}", e.getMessage());
        }
        return false;
    }
}