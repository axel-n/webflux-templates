package com.example.webflux_templates.controllers;

import com.example.webflux_templates.models.Book;
import com.example.webflux_templates.service.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class BookController extends BaseRestController {

    private final Service service;

    public BookController(Service service) {
        this.service = service;
    }

    @GetMapping(value = "/books")
    public Mono<List<Book>> greeting(@RequestHeader HttpHeaders headers) {
        return service.getAllBooks();
    }
}
