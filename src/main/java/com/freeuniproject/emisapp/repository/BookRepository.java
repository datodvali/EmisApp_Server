package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findBooksByTitleContainingAndAuthorContaining(String title, String author);

    public List<Book> findBooksByTitleContaining(String title);

    public List<Book> findBooksByAuthorContaining(String author);


}
