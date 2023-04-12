package com.crossasyst.rpm.mapper;

import com.crossasyst.rpm.entity.PatientObsDetailEntity;
import com.crossasyst.rpm.response.PatientObsDetailResponse;
import com.crossasyst.rpm.response.PatientObsResponse;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;


@Mapper(componentModel = "spring")
public interface PatientObsDetailMapper {
//
    // @Mapping(source = "patientObsDetail.obstermId", target = "obsterm.obstermId")
    //  @Mapping(source = "patientObsDetail.obstypeId", target = "obstype.obstypeId")
    //PatientObsDetailEntity patientObsDetailToPatientObsDetailEntity(PatientObs patientObs);


    List<PatientObsDetailResponse> PatientObsDetailEntityToPatientObsDetailResponse(List<PatientObsDetailEntity> patientObsDetailEntity);

}
