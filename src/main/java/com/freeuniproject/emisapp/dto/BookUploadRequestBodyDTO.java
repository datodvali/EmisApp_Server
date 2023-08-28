package com.freeuniproject.emisapp.dto;

import com.freeuniproject.emisapp.domain.Genre;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Setter
@Getter
public class BookUploadRequestBodyDTO {

    private String title;

    private String author;

    private String description;

    private int publicationYear;

    private List<Genre> genres;

    private MultipartFile content;

}