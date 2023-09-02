package com.freeuniproject.emisapp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SyllabusDTO {

    private Long id;

    private Long courseId;

    private String courseName;

    private byte[] content;

}
