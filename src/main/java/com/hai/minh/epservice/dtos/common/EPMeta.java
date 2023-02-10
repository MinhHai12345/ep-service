package com.hai.minh.epservice.dtos.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hai.minh.epservice.dtos.products.EPStock;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EPMeta implements Serializable {

    private static final long serialVersionUID = 2051376807606459980L;

    @JsonProperty("timestamps")
    private EPTimeStamp timeStamps;

    @JsonProperty("display_price")
    private EPDisplayPrice displayPrice;

    @JsonProperty("stock")
    private EPStock stock;
}