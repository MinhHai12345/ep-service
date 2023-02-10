package com.hai.minh.epservice.dtos.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EPData<T> implements Serializable {

    private static final long serialVersionUID = -6444319184862460309L;

    @JsonProperty("data")
    private T data;

    @JsonProperty("meta")
    private PageMeta pageMeta;


    public EPData(T data) {
        this.data = data;
    }
}