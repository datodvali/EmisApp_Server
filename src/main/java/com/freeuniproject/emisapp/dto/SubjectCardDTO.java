package com.freeuniproject.emisapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubjectCardDTO {

    private long studentId;

    private List<List<StudentSubjectDTO>> subjectsBySemester;

}
