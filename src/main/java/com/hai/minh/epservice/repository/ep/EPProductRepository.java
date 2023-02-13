package com.hai.minh.epservice.repository.ep;

import com.hai.minh.epservice.dtos.products.EPProductDto;
import com.hai.minh.epservice.dtos.common.EPData;

import java.util.List;

public interface EPProductRepository {
    EPProductDto createEPProduct(EPData<EPProductDto> request);

    EPProductDto updateEPProduct(String id, EPData<EPProductDto> request);

    List<EPProductDto> filterEPProduct(String sku);
}