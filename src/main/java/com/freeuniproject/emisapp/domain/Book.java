package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;

    @ElementCollection
    @CollectionTable(name = "genres_to_books", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Genre> genres;

    private int publishDate;

}
