package com.freeuniproject.emisapp.mapper;

import com.freeuniproject.emisapp.domain.Book;
import com.freeuniproject.emisapp.dto.BookUploadRequestBodyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(componentModel = "spring")
public interface BookUploadRequestMapper {

    @Mapping(source = "content", target = "content", qualifiedByName = "contentMapper")
    Book fromDTO(BookUploadRequestBodyDTO dto);

    @Named("contentMapper")
    default byte[] toByteArray(MultipartFile content) throws IOException {
        return content.getBytes();
    }

}
