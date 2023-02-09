package com.hai.minh.epservice.dtos.carts.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EPCartMetaDto implements Serializable {
    private static final long serialVersionUID = 9143814490656770650L;

    @JsonProperty("timestamps")
    private EPCartTimeStampDto timeStamp;

    @JsonProperty("meta")
    private EPCartMetaDto meta;
}