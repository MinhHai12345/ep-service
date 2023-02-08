package com.hai.minh.epservice.dtos.common;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class EPListData<T> implements Serializable {
    private static final long serialVersionUID = 3508009624809276570L;

    @JsonProperty("data")
    private List<T> data;

    @JsonProperty("links")
    private Links links;

    @JsonProperty("meta")
    private Meta meta;
}