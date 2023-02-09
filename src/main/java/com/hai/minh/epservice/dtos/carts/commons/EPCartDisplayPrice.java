package com.hai.minh.epservice.dtos.carts.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hai.minh.epservice.dtos.common.EPTax;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class EPCartDisplayPrice implements Serializable {
    private static final long serialVersionUID = 6259166311995490043L;

    @JsonProperty("with_tax")
    private EPTax withTax;

    @JsonProperty("without_tax")
    private EPTax withoutTax;

    @JsonProperty("tax")
    private EPTax tax;
}