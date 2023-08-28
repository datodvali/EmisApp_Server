package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.BookDTO;
import com.freeuniproject.emisapp.dto.BookInfoDTO;
import com.freeuniproject.emisapp.dto.BookUploadRequestBodyDTO;

import java.util.List;

public interface BookService {

    List<BookInfoDTO> findBooks(String title, String author);

    BookDTO findBook(Long id);

    void addToLibrary(BookUploadRequestBodyDTO book);

}
