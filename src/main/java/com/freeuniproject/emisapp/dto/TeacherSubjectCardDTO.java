package com.freeuniproject.emisapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class TeacherSubjectCardDTO {

    private Long teacherId;

    private List<TeacherSubjectDTO> subjects;

}
