package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.dto.BookDTO;
import com.freeuniproject.emisapp.dto.BookInfoDTO;
import com.freeuniproject.emisapp.dto.BookUploadRequestBodyDTO;
import com.freeuniproject.emisapp.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/emis/api/library")
public class LibraryController {

    private final BookService bookService;

    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/find")
    public Page<BookInfoDTO> findBooks(@RequestParam String title, @RequestParam String author,
                                       @RequestParam Integer page, @RequestParam Integer size) {
        return bookService.findBooks(title, author, PageRequest.of(page, size));
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadBook(@ModelAttribute BookUploadRequestBodyDTO book) throws IOException {
        bookService.addToLibrary(book);
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadBook(@RequestParam Long id) {
        BookDTO book = bookService.findBook(id);
        if (book != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", book.getTitle());
            headers.setContentType(MediaType.APPLICATION_PDF);
            return new ResponseEntity<>(book.getContent(), headers, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
