package com.freeuniproject.emisapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@Setter
@Getter
public class SubjectCardDTO {

    private long studentId;

    private List<List<StudentSubjectDTO>> subjectsBySemester;

}
