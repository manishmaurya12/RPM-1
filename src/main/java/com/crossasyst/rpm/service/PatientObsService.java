package com.crossasyst.rpm.service;

import com.crossasyst.rpm.entity.ObstermEntity;
import com.crossasyst.rpm.entity.ObstypeEntity;
import com.crossasyst.rpm.entity.PatientObsDetailEntity;
import com.crossasyst.rpm.entity.PatientObsEntity;
import com.crossasyst.rpm.mapper.PatientObsMapper;
import com.crossasyst.rpm.repository.ObstermRepository;
import com.crossasyst.rpm.repository.ObstypeRepository;
import com.crossasyst.rpm.repository.PatientObsDetailRepository;
import com.crossasyst.rpm.response.PatientObsResponse;
import com.crossasyst.rpm.model.PatientObs;
import com.crossasyst.rpm.repository.PatientObsRepository;
import com.crossasyst.rpm.utils.CustomExceptionHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Log4j2
@Service
public class PatientObsService {

    private final PatientObsMapper patientObsMapper;
    private final PatientObsRepository patientObsRepository;
    private final PatientObsDetailRepository patientObsDetailRepository;
    private final ObstermRepository obstermRepository;
    private final ObstypeRepository obstypeRepository;

    @Autowired
    public PatientObsService(PatientObsMapper patientObsMapper, PatientObsRepository patientObsRepository, PatientObsDetailRepository patientObsDetailRepository, ObstermRepository obstermRepository, ObstypeRepository obstypeRepository) {
        this.patientObsMapper = patientObsMapper;

        this.patientObsRepository = patientObsRepository;
        this.patientObsDetailRepository = patientObsDetailRepository;

        this.obstermRepository = obstermRepository;
        this.obstypeRepository = obstypeRepository;
    }

    public PatientObsResponse createPatientObs(PatientObs patientObs) {
        log.info("creating patientObs..");
        if (Objects.isNull(patientObs)) {
            throw new IllegalArgumentException("Invalid data");
        }
        PatientObsEntity patientObsEntity = patientObsMapper.patientObsToPatientObsEntity(patientObs);
        patientObsEntity.setObsterm(getObsterm(patientObs.getObstermId()));

        PatientObsEntity patientObsResponse = patientObsRepository.save(patientObsEntity);

        if (Objects.nonNull(patientObs.getPatientObsDetail())) {
            ObstypeEntity obsType = obstypeRepository.findById(patientObs.getPatientObsDetail().getObstypeId()).orElseThrow(() -> new IllegalArgumentException("Not found"));
            PatientObsDetailEntity patientObsDetailEntity = new PatientObsDetailEntity();
            patientObsDetailEntity.setPatientObs(patientObsEntity);
            patientObsDetailEntity.setObsterm(getObsterm(patientObs.getPatientObsDetail().getObstermId()));
            patientObsDetailEntity.setObstype(obsType);

            log.info("patientObsDetailEntity : {}", patientObsDetailEntity.toString());
            PatientObsDetailEntity patientObsResponse1 = patientObsDetailRepository.save(patientObsDetailEntity);
            return new PatientObsResponse(patientObsDetailEntity.getPatientObs().getPatientObsId());
        }
        log.info("patientObsEntity : {}", patientObsEntity.toString());

        return new PatientObsResponse(patientObsResponse.getPatientObsId());
    }

    private ObstermEntity getObsterm(Long obsId) {
        return obstermRepository.findById(obsId).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }


    public List<PatientObsResponse> getPatientObs(Long patientId) {
        List<PatientObsEntity> patientObs = patientObsRepository.findByPatientId(patientId);
        if (patientObs.isEmpty()) {
            return Collections.emptyList();
        }
        return patientObs.stream().map(patientObsMapper::PatientObsEntityToPatientObs).collect(Collectors.toList());
    }
}



