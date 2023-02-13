package com.hai.minh.epservice.dtos.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EPImage implements Serializable {
    private static final long serialVersionUID = 8372430254335423733L;

    @JsonProperty("mime_type")
    private String mimeType;

    @JsonProperty("file_name")
    private String fileName;

    @JsonProperty("href")
    private String href;
}