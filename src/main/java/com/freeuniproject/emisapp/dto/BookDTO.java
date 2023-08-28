package com.freeuniproject.emisapp.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BookDTO extends BookInfoDTO {

    private byte[] content;

}
