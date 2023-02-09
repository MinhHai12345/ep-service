package com.hai.minh.epservice.controllers;

import com.hai.minh.epservice.commons.constants.URLConstants;
import com.hai.minh.epservice.controllers.commons.AbstractController;
import com.hai.minh.epservice.dtos.carts.EPCartDto;
import com.hai.minh.epservice.service.EPCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CartController extends AbstractController {

    @Autowired
    private EPCartService epCartService;

    @GetMapping(value = URLConstants.URL_CART + "/getCart/{id}")
    public ResponseEntity<Map<String, Object>> addCart(@NotNull(message = "id not null") @PathVariable("id") String id) {
        return success(epCartService.getCart(id));
    }

    @PostMapping(value = URLConstants.URL_CART + "/addCart")
    public ResponseEntity<Map<String, Object>> addCart(@Valid @RequestBody EPCartDto request) {
        return success(epCartService.createCart(request));
    }

    @PutMapping(value = URLConstants.URL_CART + "/updateCart/{id}")
    public ResponseEntity<Map<String, Object>> updateCart(@NotNull(message = "id not null") @PathVariable("id") String id,
                                                          @RequestBody EPCartDto epCartDto) {
        return success(epCartService.updateCart(id, epCartDto));
    }

    @DeleteMapping(value = URLConstants.URL_CART + "/deleteCart/{id}")
    public ResponseEntity<Map<String, Object>> deleteCart(@NotNull(message = "id not null") @PathVariable("id") String id) {
        return success(epCartService.deleteCart(id));
    }
}