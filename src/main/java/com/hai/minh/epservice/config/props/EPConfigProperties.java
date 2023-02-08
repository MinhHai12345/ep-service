package com.hai.minh.epservice.config.props;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Data
@Component
public class EPConfigProperties {

    @Value("${app.elasticPath.url}")
    private String epPath;

    @Value("${app.elasticPath.urlV2}")
    private String epPathV2;

    @Value("${app.elasticPath.clientID}")
    private String clientId;

    @Value("${app.elasticPath.clientSecret}")
    private String clientSecret;

    @Value("${app.elasticPath.storeID}")
    private String storeId;

    @Value("${app.elasticPath.grand-type}")
    private String grantType;

    private HttpHeaders headers;

    private Long expireAt;
}