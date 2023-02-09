package com.hai.minh.epservice.dtos.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hai.minh.epservice.dtos.common.EPTax;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EPProductDisplayPrice implements Serializable {

    private static final long serialVersionUID = 8837052422476732630L;

    @JsonProperty("with_tax")
    private EPTax withTax;

    @JsonProperty("without_tax")
    private EPTax withoutTax;
}