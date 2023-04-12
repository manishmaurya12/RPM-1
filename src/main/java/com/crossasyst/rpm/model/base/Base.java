package com.crossasyst.rpm.model.base;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDateTime;

@Data
public class Base {
    private LocalDateTime createdTs;

    @CreatedBy
    private Long createdBy;

    private LocalDateTime updatedTs;


    private Long updatedBy;
}
