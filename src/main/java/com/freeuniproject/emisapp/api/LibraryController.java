package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.dto.BookDTO;
import com.freeuniproject.emisapp.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("emis/api/library/")
public class LibraryController {

    private final BookService bookService;

    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/find/")
    public List<BookDTO> findBooks(@RequestParam String title, @RequestParam String author) {
        return bookService.findBooks(title, author);
    }

}
