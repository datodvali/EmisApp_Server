package com.freeuniproject.emisapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class BookContent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookcontent_id_sequence_generator")
    @SequenceGenerator(name = "bookcontent_id_sequence_generator", sequenceName = "BOOK_ID_SEQUENCE", allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Lob
    private byte[] content;

}
