package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EMIS_USER")
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

    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Student student;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,  orphanRemoval = true)
    private Teacher teacher;
    
}
