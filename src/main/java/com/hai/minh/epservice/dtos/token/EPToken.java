package com.hai.minh.epservice.dtos.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EPToken implements Serializable {

    private static final long serialVersionUID = -7259504786712395231L;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("identifier")
    private String identifier;

    @JsonProperty("expires")
    private Long expiresAt;

    @JsonProperty("expires_in")
    private Long expiresIn;

    @JsonProperty("access_token")
    private String accessToken;
}