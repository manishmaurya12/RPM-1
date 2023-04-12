package com.crossasyst.rpm.mapper;

import com.crossasyst.rpm.entity.ObstermEntity;
import com.crossasyst.rpm.model.Obsterm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
public interface ObstermMapper {

    List<Obsterm> entityToModel(List<ObstermEntity> obstermEntity);

    @Mapping(target = "obscategoryId", source = "obstermEntity.obscategory.obsCategoryId")
    @Mapping(target = "obstypeId", source = "obstermEntity.obstype.obstypeId")
    Obsterm entityToModel(ObstermEntity obstermEntity);


}