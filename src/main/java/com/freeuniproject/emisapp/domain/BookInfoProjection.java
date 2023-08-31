package com.freeuniproject.emisapp.domain;

import java.util.List;


public interface BookInfoProjection {

    Long getId();

    String getTitle();

    String getAuthor();

    List<Genre> getGenres();

}
