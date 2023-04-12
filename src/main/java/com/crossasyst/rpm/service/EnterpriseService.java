package com.crossasyst.rpm.service;

import com.crossasyst.rpm.entity.EnterpriseEntity;
import com.crossasyst.rpm.utils.CustomExceptionHandler;
import com.crossasyst.rpm.mapper.EnterpriseMapper;
import com.crossasyst.rpm.model.Enterprise;
import com.crossasyst.rpm.repository.EnterpriseRepository;
import com.crossasyst.rpm.response.EnterpriseResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EnterpriseService {

    private final EnterpriseMapper enterpriseMapper;

    private final EnterpriseRepository enterpriseRepository;

    @Autowired
    public EnterpriseService(EnterpriseMapper enterpriseMapper, EnterpriseRepository enterpriseRepository) {
        this.enterpriseMapper = enterpriseMapper;
        this.enterpriseRepository = enterpriseRepository;
    }

    public EnterpriseResponse createEnterprise(Enterprise enterprise) {
        EnterpriseEntity enterpriseEntity = enterpriseMapper.enterpriseToEnterpriseEntity(enterprise);
        enterpriseRepository.save(enterpriseEntity);
        log.info("enterprise details saved successfully on db..");
        return new EnterpriseResponse(enterpriseEntity.getEnterpriseId());
    }

    public List<EnterpriseResponse> getAllEnterprise() {
        List<EnterpriseEntity> enterpriseEntities = enterpriseRepository.findByActiveTrue();
        return enterpriseMapper.EnterpriseEntityToEntity(enterpriseEntities);
    }

    public Enterprise getEnterprise(Long enterpriseId) {
        Optional<EnterpriseEntity> enterpriseEntity = Optional.ofNullable(enterpriseRepository.findByIdAndActiveTrue(enterpriseId).orElseThrow(CustomExceptionHandler::new));
        return enterpriseMapper.EnterpriseEntityToEntity(enterpriseEntity.get());
    }

    public void updateEnterprise(Long enterpriseId, Enterprise enterprise) {
        Optional<EnterpriseEntity> enterpriseEntity = Optional.ofNullable(enterpriseRepository.findByIdAndActiveTrue(enterpriseId).orElseThrow(CustomExceptionHandler::new));
        EnterpriseEntity enterpriseEntity1 = enterpriseMapper.enterpriseToEnterpriseEntity(enterprise);
        enterpriseEntity1.setEnterpriseId(enterpriseEntity.get().getEnterpriseId());
        enterpriseRepository.save(enterpriseEntity1);
        log.info("enterprise updated successfully..");
    }


    public void removeEnterprise(Long enterpriseId) {
        Optional<EnterpriseEntity> enterpriseEntity = Optional.ofNullable(enterpriseRepository.findByIdAndActiveTrue(enterpriseId).orElseThrow(CustomExceptionHandler::new));
        enterpriseRepository.deleteById(enterpriseId);
        log.info("enterprise deleted successfully..");

    }
}


