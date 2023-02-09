package com.hai.minh.epservice.dtos.carts.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EPCartTimeStampDto implements Serializable {
    private static final long serialVersionUID = -7884685273124218999L;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("expires_at")
    private String expiresAt;
}