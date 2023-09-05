package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE %LOWER(:title)% AND LOWER(b.author) LIKE %LOWER(:author)%")
    Page<Book> findBooksByTitleAndAuthor(@Param("title") String title, @Param("author") String author, Pageable pageable);

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title% AND b.author LIKE %:author%")
    List<Book> findBooksByTitleAndAuthorList(@Param("title") String title, @Param("author") String author);

    public List<Book> findBooksByTitleContaining(String title);

    public List<Book> findBooksByAuthorContaining(String author);


}
