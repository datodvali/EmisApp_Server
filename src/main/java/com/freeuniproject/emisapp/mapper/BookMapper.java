package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Book;
import com.freeuniproject.emisapp.dto.BookDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO toDTO(Book book);

    Book fromDTO(BookDTO dto);

}
