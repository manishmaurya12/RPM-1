package com.crossasyst.rpm.service;

import com.crossasyst.rpm.entity.ObstermEntity;
import com.crossasyst.rpm.utils.CustomExceptionHandler;
import com.crossasyst.rpm.mapper.ObstermMapper;
import com.crossasyst.rpm.model.Obsterm;
import com.crossasyst.rpm.repository.ObstermRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class ObstermService {
    @Autowired
    private final ObstermMapper obstermMapper;
    private final ObstermRepository obstermRepository;


    public ObstermService(ObstermMapper obstermMapper, ObstermRepository obstermRepository) {
        this.obstermMapper = obstermMapper;

        this.obstermRepository = obstermRepository;
    }


    public List<Obsterm> getAllObsterm() {
        List<ObstermEntity> obstermEntities = obstermRepository.findAll();
        return obstermMapper.entityToModel(obstermEntities);
    }

    public Obsterm getObsterm(Long obstermId) {
        log.info("fetching obsterm..");
        Optional<ObstermEntity> obstermEntity = Optional.ofNullable(obstermRepository.findById(obstermId).orElseThrow(CustomExceptionHandler::new));
        Obsterm obsterm = new Obsterm();
        if (obstermEntity.isPresent()) {
            log.info("obstermId is present..");
            obsterm = obstermMapper.entityToModel(obstermEntity.get());
        }
        return obsterm;
    }
}
