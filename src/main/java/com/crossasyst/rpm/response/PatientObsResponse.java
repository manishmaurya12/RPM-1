package com.crossasyst.rpm.response;


import com.crossasyst.rpm.model.PatientObs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientObsResponse extends PatientObs {
    private Long patientObsId;
}
