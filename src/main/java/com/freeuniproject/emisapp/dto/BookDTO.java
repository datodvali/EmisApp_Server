package com.freeuniproject.emisapp.dto;

import com.freeuniproject.emisapp.domain.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookDTO {

    private String title;

    private String author;

    private String url;

    private List<Genre> genres;

}
