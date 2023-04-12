package com.crossasyst.rpm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "obscategory")
public class ObsCategoryEntity {
    @Id
    @SequenceGenerator(name = "obcategory_sequence_id", sequenceName = "obcategory_sequence_id", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "obcategory_sequence_id")
    @Column(name = "obscategory_id")
    private Long obsCategoryId;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "code")
    private String code;

}
