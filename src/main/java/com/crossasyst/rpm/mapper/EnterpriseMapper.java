package com.crossasyst.rpm.mapper;

import com.crossasyst.rpm.entity.EnterpriseEntity;
import com.crossasyst.rpm.model.Enterprise;
import com.crossasyst.rpm.response.EnterpriseResponse;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface EnterpriseMapper {
    EnterpriseEntity enterpriseToEnterpriseEntity(Enterprise enterprise);

    List<EnterpriseResponse> EnterpriseEntityToEntity(List<EnterpriseEntity> enterpriseEntities);


    Enterprise EnterpriseEntityToEntity(EnterpriseEntity enterpriseEntity);

}
