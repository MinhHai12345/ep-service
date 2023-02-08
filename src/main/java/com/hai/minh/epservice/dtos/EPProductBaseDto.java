package com.hai.minh.epservice.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EPProductBaseDto implements Serializable {

    private static final long serialVersionUID = -6299182539192187491L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String statusBase;

    @JsonProperty("description")
    private String descriptionBase;

    @JsonProperty("is_deleted")
    private boolean isDeleted;
}