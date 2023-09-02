package com.freeuniproject.emisapp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentGradeDTO {

    private Long id;

    private String gradeComponentName;

    private double totalPoints;

    private double currentPoints;

}
