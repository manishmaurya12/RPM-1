package com.crossasyst.rpm.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "obsterm")
public class ObstermEntity {
    @Id
    @SequenceGenerator(name = "obsterm_sequence_id", sequenceName = "obsterm_sequence_id", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "obsterm_sequence_id")
    @Column(name = "obsterm_id")
    private Long obstermId;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "obscategory_id")
    private ObsCategoryEntity obscategory;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "obstype_id")
    private ObstypeEntity obstype;


}
