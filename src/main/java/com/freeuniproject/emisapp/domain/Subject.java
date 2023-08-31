package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_id_sequence_generator")
    @SequenceGenerator(name = "subject_id_sequence_generator", sequenceName = "SUBJECT_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    private String name;

    private String code;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "prerequisite",
            joinColumns = {@JoinColumn(name = "subjectId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "prerequisiteId", referencedColumnName = "id")}
    )
    private List<Subject> prerequisites;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Subject s)) {
            return false;
        }
        return this.id.equals(s.id);
    }

}
