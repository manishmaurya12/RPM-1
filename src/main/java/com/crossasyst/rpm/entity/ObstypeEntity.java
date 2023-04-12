package com.crossasyst.rpm.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "obstype")

public class ObstypeEntity {
    @Id
    @SequenceGenerator(name = "obstype_sequence_id", sequenceName = "obstype_sequence_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "obstype_sequence_id")
    @Column(name = "obstype_id")
    private Long obstypeId;

    @Column(name = "display_name")
    private String displayName;


}
