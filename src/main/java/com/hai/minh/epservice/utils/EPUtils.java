package com.hai.minh.epservice.utils;


import com.hai.minh.epservice.config.props.EPConfigProperties;
import com.hai.minh.epservice.service.EPAccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;

@Component
public class EPUtils {

    @Autowired
    private EPConfigProperties epConfigProperties;

    @Autowired
    private EPAccessTokenService accessTokenService;

    public HttpHeaders buildHeaders() {
        if (epConfigProperties.getExpireAt() == null
                || Instant.now().getEpochSecond() > epConfigProperties.getExpireAt()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessTokenService.fetchToken());
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            epConfigProperties.setHeaders(headers);
            return headers;
        }
        return epConfigProperties.getHeaders();
    }
}