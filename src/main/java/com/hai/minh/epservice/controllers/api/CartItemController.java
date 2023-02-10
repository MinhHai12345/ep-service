package com.hai.minh.epservice.controllers.api;

import com.hai.minh.epservice.commons.constants.URLConstants;
import com.hai.minh.epservice.controllers.commons.AbstractController;
import com.hai.minh.epservice.dtos.carts.customitem.EPCartItemDto;
import com.hai.minh.epservice.service.CartItemService;
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

import javax.validation.constraints.NotNull;
import java.util.Map;

@RestController
@RequestMapping(URLConstants.SUBDIRECTORY_API)
public class CartItemController extends AbstractController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping(URLConstants.URL_CART_ITEM + "/get-cart-item/{id}")
    private ResponseEntity<Map<String, Object>> getCartItem(@NotNull(message = "Id is required")
                                                            @PathVariable("id") String cartId) {
        return success(cartItemService.getItemCart(cartId));
    }

    @PostMapping(URLConstants.URL_CART_ITEM + "/add-cart-item/{id}")
    private ResponseEntity<Map<String, Object>> createCartItem(@NotNull(message = "Id is required") @PathVariable("id") String cartId,
                                                               @RequestBody EPCartItemDto cartItem) {
        return success(cartItemService.createItemToCart(cartId, cartItem));
    }

    @PutMapping(URLConstants.URL_CART_ITEM + "/update-cart-item/{id}")
    private ResponseEntity<Map<String, Object>> updateCartItem(@NotNull(message = "Id is required") @PathVariable("id") String cartId,
                                                               @RequestBody EPCartItemDto cartItem) {
        return success(cartItemService.updateItemCart(cartId, cartItem));
    }

    @DeleteMapping(URLConstants.URL_CART_ITEM + "/delete-cart-item/{Cid}/{Iid}")
    private ResponseEntity<Map<String, Object>> deleteCartItem(@NotNull(message = "CartID Not Null") @PathVariable("Cid") String cartId,
                                                               @NotNull(message = "ItemID Not Null") @PathVariable("Iid") String itemId) {
        return success(cartItemService.deleteItemCart(cartId, itemId));
    }
}