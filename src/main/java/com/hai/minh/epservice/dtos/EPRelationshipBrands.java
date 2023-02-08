package com.hai.minh.epservice.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hai.minh.epservice.dtos.common.DataCommon;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EPRelationshipBrands implements Serializable {

    private static final long serialVersionUID = 8703694799645713194L;

    @JsonProperty("data")
    private List<DataCommon> dataBrands;
}