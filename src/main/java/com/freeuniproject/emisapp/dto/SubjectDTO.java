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
public class SubjectDTO {

    private Long id;

    private String name;

    private String code;

    private String description;

    private List<String> teachers;

}
