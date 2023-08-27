package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.dto.BookDTO;
import com.freeuniproject.emisapp.mapper.BookMapper;
import com.freeuniproject.emisapp.repository.BookRepository;
import com.freeuniproject.emisapp.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDTO> findBooks(String title, String author) {
//        return bookRepository.findBooksByTitleContainingAndAuthorContaining(title, author)
//                .stream().map(bookMapper::toDTO).collect(Collectors.toList());
        return List.of(new BookDTO("book", "author", "http://someurl.com", Collections.emptyList()));
    }

}
