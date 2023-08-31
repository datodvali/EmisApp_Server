package com.freeuniproject.emisapp.repository;

import com.freeuniproject.emisapp.domain.Book;
import com.freeuniproject.emisapp.domain.BookInfoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b.id as id,b.title as title,b.author as author,b.genres as genres FROM Book b WHERE b.title LIKE %:title% AND b.author LIKE %:author%")
    Page<BookInfoProjection> findBooksByTitleAndAuthor(@Param("title") String title, @Param("author") String author, Pageable pageable);

    public List<Book> findBooksByTitleContaining(String title);

    public List<Book> findBooksByAuthorContaining(String author);


}
