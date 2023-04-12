package com.crossasyst.rpm.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Obsterm {
    private String name;
    private String code;
    private Long obscategoryId;
    private Long obstypeId;
}
