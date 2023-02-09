package com.hai.minh.epservice.service.impl;


import com.hai.minh.epservice.commons.constants.EPConstants;
import com.hai.minh.epservice.config.props.EPConfigProperties;
import com.hai.minh.epservice.dtos.token.EPToken;
import com.hai.minh.epservice.service.EPAccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Slf4j
@Service
public class EPAccessTokenServiceImpl implements EPAccessTokenService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EPConfigProperties configProperties;

    @Override
    public String fetchToken() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add(EPConstants.STORE_ID, configProperties.getStoreId());

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add(EPConstants.CLIENT_ID_HEADER, configProperties.getClientId());
        body.add(EPConstants.CLIENT_SECRET, configProperties.getClientSecret());
        body.add(EPConstants.GRANT_TYPE, configProperties.getGrantType());

        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body, headers);
        String url = configProperties.getEpPath() + EPConstants.OAUTH + EPConstants.ACCESS_TOKEN;
        try {
            EPToken token = restTemplate.exchange(url, HttpMethod.POST, entity,
                    new ParameterizedTypeReference<EPToken>() {
                    }).getBody();
            if (token != null && StringUtils.isNotEmpty(token.getAccessToken())) {
                log.info("Access Token : {}", token.getAccessToken());
                configProperties.setExpireAt(token.getExpiresAt());
                return token.getAccessToken();
            }
        } catch (Exception e) {
            log.error(this.getClass().toString().concat("Request access token {} ".concat(e.getMessage())));
        }
        return StringUtils.EMPTY;
    }
}