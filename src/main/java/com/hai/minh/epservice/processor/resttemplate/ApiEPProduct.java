package com.hai.minh.epservice.processor.resttemplate;

import com.hai.minh.epservice.dtos.products.EPProductDto;
import com.hai.minh.epservice.dtos.common.EPData;

import java.util.List;

public interface ApiEPProduct {
    EPProductDto createEPProduct(EPData<EPProductDto> request);

    EPProductDto updateEPProduct(String id, EPData<EPProductDto> request);

    List<EPProductDto> findSKUProduct(String sku);
}