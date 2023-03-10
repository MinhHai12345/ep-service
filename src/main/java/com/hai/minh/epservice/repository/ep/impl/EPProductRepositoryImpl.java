package com.hai.minh.epservice.repository.ep.impl;

import com.hai.minh.epservice.commons.constants.EPConstants;
import com.hai.minh.epservice.commons.constants.URLConstants;
import com.hai.minh.epservice.config.props.EPConfigProperties;
import com.hai.minh.epservice.dtos.common.EPData;
import com.hai.minh.epservice.dtos.products.EPProductDto;
import com.hai.minh.epservice.repository.ep.EPProductRepository;
import com.hai.minh.epservice.utils.EPUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;


@Slf4j
@Component
public class EPProductRepositoryImpl implements EPProductRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EPUtils epUtils;

    @Autowired
    private EPConfigProperties configProperties;

    @Override
    public EPProductDto createEPProduct(EPData<EPProductDto> request) {
        try {
            if (request != null) {
                HttpHeaders headers = epUtils.buildHeaders();
                HttpEntity<EPData<EPProductDto>> entity = new HttpEntity<>(request, headers);
                String url = configProperties.getEpPathV2() + URLConstants.EP_PRODUCT_URL;

                EPData<EPProductDto> response = restTemplate
                        .exchange(url, HttpMethod.POST, entity,
                                new ParameterizedTypeReference<EPData<EPProductDto>>() {
                                })
                        .getBody();
                if (response != null && response.getData() != null) {
                    return response.getData();
                }
            }
        } catch (Exception e) {
            log.error("error create ep product -- {}", e.getMessage());
        }
        return null;
    }

    @Override
    public EPProductDto updateEPProduct(String id, EPData<EPProductDto> request) {
        try {
            log.info("start update ep product with id {}", id);
            request.getData().setId(id);
            HttpHeaders headers = epUtils.buildHeaders();
            HttpEntity<EPData<EPProductDto>> entity = new HttpEntity<>(request, headers);

            String url = configProperties.getEpPathV2() + URLConstants.EP_PRODUCT_URL
                    + EPConstants.SLASH_SYMBOL + id;
            EPData<EPProductDto> response = restTemplate
                    .exchange(url, HttpMethod.PUT, entity,
                            new ParameterizedTypeReference<EPData<EPProductDto>>() {
                            })
                    .getBody();
            if (response != null && response.getData() != null) {
                return response.getData();
            }
        } catch (Exception e) {
            log.error("error update ep product -- {}", e.getMessage());
        }
        return null;
    }

    @Override
    public List<EPProductDto> filterEPProduct(String params) {
        try {
            HttpHeaders headers = epUtils.buildHeaders();
            HttpEntity<Void> entity = new HttpEntity<>(headers);

            String url = configProperties.getEpPathV2() +
                    URLConstants.EP_PRODUCT_FILTER + params;
            log.info("URL {}", url);
            ResponseEntity<EPData<List<EPProductDto>>> response = restTemplate
                    .exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<EPData<List<EPProductDto>>>() {
                    });
            boolean isSuccess = HttpStatus.OK.equals(response.getStatusCode());
            if (isSuccess && !CollectionUtils.isEmpty(response.getBody().getData())) {
                return response.getBody().getData();
            }
        } catch (Exception e) {
            log.error("error find sku -- {}", e.getMessage());
        }
        return Collections.emptyList();
    }
}