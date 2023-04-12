package com.crossasyst.rpm.response;

import com.crossasyst.rpm.model.PatientObsDetail;
import lombok.Data;

@Data
public class PatientObsDetailResponse extends PatientObsDetail {
    private Long patientObsDetailId;
}
