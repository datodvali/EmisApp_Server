package com.freeuniproject.emisapp.domain;

import com.freeuniproject.emisapp.dto.BookUploadRequestBodyDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_sequence_generator")
    @SequenceGenerator(name = "book_id_sequence_generator", sequenceName = "BOOK_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    private String title;

    private String author;

    private String description;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "book", cascade = {CascadeType.ALL})
    private BookContent content;

    @ElementCollection
    @CollectionTable(name = "genres_to_books", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Genre> genres;

    private int publishDate;

    public Book(BookUploadRequestBodyDTO uploadRequest) {
        this.title = uploadRequest.getTitle();
        this.author = uploadRequest.getAuthor();
        this.description = uploadRequest.getDescription();
        this.publishDate = uploadRequest.getPublicationYear();
        this.genres = uploadRequest.getGenres();
    }

}
