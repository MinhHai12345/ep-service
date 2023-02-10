package com.hai.minh.epservice.dtos.carts.customitem;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hai.minh.epservice.dtos.carts.commons.EPCartLinksDto;
import com.hai.minh.epservice.dtos.common.EPMeta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EPCartDto implements Serializable {

    private static final long serialVersionUID = -1896719192571698600L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    @NotNull(message = "Name is required")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("links")
    private EPCartLinksDto links;

    @JsonProperty("meta")
    private EPMeta meta;
}