package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class StudentFinances {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_finances_id_sequence_generator")
    @SequenceGenerator(name = "student_finances_id_sequence_generator", sequenceName = "STUDENT_FINANCES_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private double tuitionFee;

    private double tuitionFeePaid;

    private double scholarship;

}
