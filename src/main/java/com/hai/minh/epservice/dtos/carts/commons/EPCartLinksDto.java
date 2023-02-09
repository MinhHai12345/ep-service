package com.hai.minh.epservice.dtos.carts.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EPCartLinksDto implements Serializable {
    private static final long serialVersionUID = -86231553234288581L;

    @JsonProperty("self")
    private String self;
}