package com.hai.minh.epservice.dtos.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hai.minh.epservice.dtos.common.TimeStamps;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EPProductMeta implements Serializable {

    private static final long serialVersionUID = 2051376807606459980L;

    @JsonProperty("timestamps")
    private TimeStamps timeStamps;

    @JsonProperty("display_price")
    private EPProductDisplayPrice displayPrice;

    @JsonProperty("stock")
    private EPStock stock;
}