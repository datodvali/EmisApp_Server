package com.freeuniproject.emisapp.service;

import com.freeuniproject.emisapp.dto.BookDTO;
import com.freeuniproject.emisapp.dto.BookInfoDTO;
import com.freeuniproject.emisapp.dto.BookUploadRequestBodyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;

public interface BookService {

    Page<BookInfoDTO> findBooks(String title, String author, Pageable pageable);

    BookDTO findBook(Long id);

    void addToLibrary(BookUploadRequestBodyDTO book) throws IOException;

}
