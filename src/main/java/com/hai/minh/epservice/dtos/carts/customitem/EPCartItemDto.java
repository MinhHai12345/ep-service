package com.hai.minh.epservice.dtos.carts.customitem;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hai.minh.epservice.dtos.carts.commons.EPTaxDetailDTO;
import com.hai.minh.epservice.dtos.common.EPPrice;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EPCartItemDto implements Serializable {
    private static final long serialVersionUID = -2343329452608183626L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("type")
    private String type;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("code")
    private String code;

    @JsonProperty("tax")
    private List<EPTaxDetailDTO> tax;

    @JsonProperty("price")
    private EPPrice price;
}