package com.crossasyst.rpm.mapper;

import com.crossasyst.rpm.entity.PatientObsEntity;
import com.crossasyst.rpm.model.PatientObs;
import com.crossasyst.rpm.response.PatientObsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface PatientObsMapper {


    PatientObsEntity patientObsToPatientObsEntity(PatientObs patientObs);

    @Mapping(source = "obsterm.obstermId", target = "obstermId")
    PatientObsResponse PatientObsEntityToPatientObs(PatientObsEntity patientObsEntity);
}
