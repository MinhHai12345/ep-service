package com.hai.minh.epservice.controllers.api;

import com.hai.minh.epservice.commons.constants.URLConstants;
import com.hai.minh.epservice.dtos.customer.EPCustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(URLConstants.SUBDIRECTORY_API)
public class CustomerController {

    @PostMapping(value = URLConstants.URL_CUSTOMER + "/create")
    private ResponseEntity<Map<String, Object>> createCustomer(@RequestBody EPCustomerDto epCustomerDto){
        return null;
    }
}