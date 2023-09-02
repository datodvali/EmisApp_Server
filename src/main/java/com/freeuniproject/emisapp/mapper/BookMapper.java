package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Book;
import com.freeuniproject.emisapp.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "content.content", target = "content")
    BookDTO toDTO(Book book);

}
