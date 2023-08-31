package com.freeuniproject.emisapp.impl;

import com.freeuniproject.emisapp.domain.Book;
import com.freeuniproject.emisapp.domain.BookInfoProjection;
import com.freeuniproject.emisapp.dto.BookDTO;
import com.freeuniproject.emisapp.dto.BookInfoDTO;
import com.freeuniproject.emisapp.dto.BookUploadRequestBodyDTO;
import com.freeuniproject.emisapp.mapper.BookInfoMapper;
import com.freeuniproject.emisapp.mapper.BookMapper;
import com.freeuniproject.emisapp.mapper.BookUploadRequestMapper;
import com.freeuniproject.emisapp.repository.BookRepository;
import com.freeuniproject.emisapp.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    @Override
    public Page<BookInfoDTO> findBooks(String title, String author, Pageable pageable) {
        Page<BookInfoProjection> resultPage = bookRepository.findBooksByTitleAndAuthor(title, author, pageable);
        List<BookInfoDTO> result = resultPage
                .stream().map(this::fromProjectionToDTO).collect(Collectors.toList());
        return new PageImpl<>(result, PageRequest.of(pageable.getPageNumber(), result.size()), resultPage.getTotalElements());
    }

    @Override
    public BookDTO findBook(Long id) {
        return bookRepository.findById(id).map(bookMapper::toDTO).orElse(null);
    }

    @Override
    public void addToLibrary(BookUploadRequestBodyDTO book) {
        bookRepository.save(bookUploadRequestMapper.fromDTO(book));
    }

    private BookInfoDTO fromProjectionToDTO(BookInfoProjection projection) {
        BookInfoDTO dto = new BookInfoDTO();
        dto.setId(projection.getId());
        dto.setTitle(projection.getTitle());
        dto.setAuthor(projection.getAuthor());
        dto.setGenres(projection.getGenres());
        return dto;
    }


}
