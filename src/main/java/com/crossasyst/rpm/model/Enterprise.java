package com.crossasyst.rpm.model;

import com.crossasyst.rpm.model.base.Base;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Data
@Validated
public class Enterprise {
    @Size(max = 100, message = "EnterpriseService name maximum 100 character")
    private String name;

}

