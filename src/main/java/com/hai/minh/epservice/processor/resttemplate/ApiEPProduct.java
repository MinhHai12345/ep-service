package com.hai.minh.epservice.processor.resttemplate;

import com.hai.minh.epservice.commons.constants.EPConstants;
import com.hai.minh.epservice.config.props.EPConfigProperties;
import com.hai.minh.epservice.dtos.EPProductDto;
import com.hai.minh.epservice.dtos.common.EPData;
import com.hai.minh.epservice.dtos.common.EPListData;
import com.hai.minh.epservice.utils.EPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Component
public class ApiEPProduct {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EPUtils epUtils;

    @Autowired
    private EPConfigProperties configProperties;

    public ResponseEntity<EPData<EPProductDto>> createEPProduct(EPData<EPProductDto> request) {
        try {
            if (request != null) {
                final HttpHeaders headers = epUtils.buildHeaders();
                final HttpEntity<EPData<EPProductDto>> entity = new HttpEntity<>(request, headers);

                final String url = configProperties.getEpPathV2() + EPConstants.PRODUCT_URL;

                return restTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<EPData<EPProductDto>>() {
                });
            }
        } catch (Exception e) {
            log.error("ERROR CREATE PRODUCT : {}", e.getMessage());
        }
        return null;
    }

    public boolean checkSKUProduct(String sku) {
        try {
            final HttpHeaders headers = epUtils.buildHeaders();
            final HttpEntity<Void> entity = new HttpEntity<>(headers);

            final String skuValue = "eq(sku," + sku + ")";
            String url = configProperties.getEpPathV2() +
                    EPConstants.PRODUCT_FILTER + skuValue;

            final ResponseEntity<EPListData<EPProductDto>> response = restTemplate
                    .exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<EPListData<EPProductDto>>() {
                    });
            if (CollectionUtils.isEmpty(response.getBody().getData())) {
                return true;
            }
        } catch (Exception e) {
            log.error("ERROR CHECK SKU: {}", e.getMessage());
        }
        return false;
    }
}