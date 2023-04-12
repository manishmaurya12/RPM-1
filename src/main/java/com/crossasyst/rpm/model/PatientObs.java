package com.crossasyst.rpm.model;

import com.crossasyst.rpm.model.base.Base;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class PatientObs {

    @NotNull
    private Long patientId;

    @NotNull
    private Long obstermId;

    @NotNull
    private Double value;

    @NotBlank
    private String uomCode;

    @NotNull
    private LocalDateTime effectiveDateTime;

    private PatientObsDetail patientObsDetail;
}
