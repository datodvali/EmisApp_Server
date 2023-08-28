package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.dto.BookDTO;
import com.freeuniproject.emisapp.dto.BookInfoDTO;
import com.freeuniproject.emisapp.dto.BookUploadRequestBodyDTO;
import com.freeuniproject.emisapp.mapper.BookInfoMapper;
import com.freeuniproject.emisapp.mapper.BookMapper;
import com.freeuniproject.emisapp.mapper.BookUploadRequestMapper;
import com.freeuniproject.emisapp.repository.BookRepository;
import com.freeuniproject.emisapp.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    private final BookInfoMapper bookInfoMapper;

    private final BookUploadRequestMapper bookUploadRequestMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper, BookInfoMapper bookInfoMapper, BookUploadRequestMapper bookUploadRequestMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.bookInfoMapper = bookInfoMapper;
        this.bookUploadRequestMapper = bookUploadRequestMapper;
    }

    @Override
    public List<BookInfoDTO> findBooks(String title, String author) {
//        return bookRepository.findBooksByTitleContainingAndAuthorContaining(title, author)
//                .stream().map(bookMapper::toDTO).collect(Collectors.toList());
        return List.of(new BookInfoDTO(1L, "author", "http://someurl.com", Collections.emptyList()));
    }

    @Override
    public BookDTO findBook(Long id) {
        return bookRepository.findById(id).map(bookMapper::toDTO).orElse(null);
    }

    @Override
    public void addToLibrary(BookUploadRequestBodyDTO book) {
        bookRepository.save(bookUploadRequestMapper.fromDTO(book));
    }

}
