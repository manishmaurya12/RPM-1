package com.crossasyst.rpm.entity;

import com.crossasyst.rpm.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient_obs")
public class PatientObsEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "seq_patient_obs_id", sequenceName = "seq_patient_obs_id", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_patient_obs_id")
    @Column(name = "patient_obs_id")
    private Long patientObsId;
    @Column(name = "patient_id")
    private Long patientId;
    private Integer value;
    @Column(name = "uom_code")
    private String uomCode;
    @Column(name = "effective_datetime")
    private LocalDateTime effectiveDateTime;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "obsterm_id")
    private ObstermEntity obsterm;

//    @OneToMany(mappedBy = "patientObs", cascade = CascadeType.ALL)
//    private List<PatientObsDetailEntity> patientObsDetailEntities;

//    @OneToMany(mappedBy = "patientObs", cascade = CascadeType.ALL)
//    private List<PatientObsDetailEntity> patientObsDetail;
}

