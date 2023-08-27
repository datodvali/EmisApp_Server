package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class SystemVariable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "systemvariable_id_sequence_generator")
    @SequenceGenerator(name = "systemvariable_id_sequence_generator", sequenceName = "SYSTEMVARIABLE_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    private String code;

    private String value;

    private String description;

}
