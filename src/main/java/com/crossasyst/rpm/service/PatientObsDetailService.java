package com.crossasyst.rpm.service;

import com.crossasyst.rpm.entity.PatientObsDetailEntity;
import com.crossasyst.rpm.entity.PatientObsEntity;
import com.crossasyst.rpm.mapper.PatientObsDetailMapper;
import com.crossasyst.rpm.model.PatientObsDetail;
import com.crossasyst.rpm.repository.PatientObsDetailRepository;
import com.crossasyst.rpm.repository.PatientObsRepository;
import com.crossasyst.rpm.response.PatientObsDetailResponse;
import com.crossasyst.rpm.response.PatientObsResponse;
import com.crossasyst.rpm.utils.CustomExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientObsDetailService {

    @Autowired
    private final PatientObsDetailMapper patientObsDetailMapper;
    @Autowired
    private final PatientObsDetailRepository patientObsDetailRepository;
    @Autowired
    private final PatientObsRepository patientObsRepository;

    public PatientObsDetailService(PatientObsDetailMapper patientObsDetailMapper, PatientObsDetailRepository patientObsDetailRepository, PatientObsRepository patientObsRepository) {
        this.patientObsDetailMapper = patientObsDetailMapper;
        this.patientObsDetailRepository = patientObsDetailRepository;
        this.patientObsRepository = patientObsRepository;
    }


//    public List<PatientObsDetailResponse> getPatientObsDetail(Long patientObsId) {
//        Optional<List<PatientObsDetailEntity>> patientObsDetailEntity = patientObsDetailRepository.findByPatientObsId(patientObsId);
//        return patientObsDetailMapper.PatientObsDetailEntityToPatientObsDetailResponse(patientObsDetailEntity.get());
//
//    }
}
