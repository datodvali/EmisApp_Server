package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Book;
import com.freeuniproject.emisapp.domain.BookInfoProjection;
import com.freeuniproject.emisapp.dto.BookInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookInfoMapper {

    BookInfoDTO toDTO(Book book);

}
