package com.crossasyst.rpm.entity;

import com.crossasyst.rpm.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient_obs_detail")
public class PatientObsDetailEntity extends BaseEntity {
    @Id
    @SequenceGenerator(name = "seq_patient_obs_detail_id", sequenceName = "seq_patient_obs_detail_id", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_patient_obs_detail_id")
    @Column(name = "patient_obs_detail_id")
    private Long patientObsDetailId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_obs_id")
    private PatientObsEntity patientObs;

    @ManyToOne
    @JoinColumn(name = "obsterm_id")
    private ObstermEntity obsterm;

    @ManyToOne
    @JoinColumn(name = "obstype_id")
    private ObstypeEntity obstype;

}
