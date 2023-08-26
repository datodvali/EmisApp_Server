package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SYSTEM_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_sequence_generator")
    @SequenceGenerator(name = "user_id_sequence_generator", sequenceName = "USER_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String email;

    private String address;

    private String phoneNumber;

    @OneToOne(mappedBy = "user", optional = true)
    private Student student;

    @OneToOne(mappedBy = "user", optional = true)
    private Teacher teacher;

}
