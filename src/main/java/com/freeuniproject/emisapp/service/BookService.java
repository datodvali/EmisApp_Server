package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> findBooks(String title, String author);

}
