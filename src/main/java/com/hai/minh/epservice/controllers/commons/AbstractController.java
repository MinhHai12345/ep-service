package com.hai.minh.epservice.controllers.commons;

import com.hai.minh.epservice.commons.constants.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractController {

    protected ResponseEntity<Map<String, Object>> success(final Object data) {
        return this.success(data, null, null, true);
    }

    protected ResponseEntity<Map<String, Object>> success(final Object data, final String code,
           final String message, final boolean needTranslate) {
        final Map<String, Object> successRes = new LinkedHashMap<>();
        successRes.put(Constants.DATA, data);
        String codeRes = StringUtils.hasText(code) ? code : HttpStatus.OK.name();
        successRes.put(Constants.CODE, codeRes);
        return new ResponseEntity<>(successRes, HttpStatus.OK);
    }
}