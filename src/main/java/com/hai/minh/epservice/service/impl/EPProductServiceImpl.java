package com.hai.minh.epservice.service.impl;

import com.hai.minh.epservice.dtos.EPProductDto;
import com.hai.minh.epservice.dtos.common.EPData;
import com.hai.minh.epservice.helpler.JsonHelper;
import com.hai.minh.epservice.processor.resttemplate.ApiEPProduct;
import com.hai.minh.epservice.service.EPProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@Service
public class EPProductServiceImpl implements EPProductService {

    @Autowired
    private JsonHelper jsonHelper;

    @Autowired
    private ApiEPProduct apiEPProduct;

    @Override
    public boolean processorCreateProductToEP(String message) {
        log.info("START PROCESS CREATE PRODUCT TO EP");
        try {
            EPProductDto epProductDto = jsonHelper.readValue(message, EPProductDto.class);
            if (epProductDto != null) {
                EPData<EPProductDto> request = new EPData<>();
                request.setData(epProductDto);
                List<EPProductDto> epProductDtoList = apiEPProduct.findSKUProduct(request.getData().getSku());
                if (CollectionUtils.isEmpty(epProductDtoList)) {
                    apiEPProduct.createEPProduct(request);
                } else {
                    apiEPProduct.updateEPProduct(epProductDtoList.get(0).getId(), request);
                }
                return true;
            }
            log.info("END PROCESS CREATE PRODUCT TO EP");
        } catch (Exception e) {
            log.error("MESSAGE ERROR: {}", e.getMessage());
        }
        return false;
    }
}