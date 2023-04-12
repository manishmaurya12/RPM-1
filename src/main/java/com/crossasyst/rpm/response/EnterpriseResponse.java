package com.crossasyst.rpm.response;


import com.crossasyst.rpm.model.Enterprise;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class EnterpriseResponse extends Enterprise {
    private Long enterpriseId;
}
