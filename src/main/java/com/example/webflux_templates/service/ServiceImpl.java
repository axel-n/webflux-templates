package com.example.webflux_templates.service;

import com.example.webflux_templates.models.Book;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceImpl implements Service {

    private List<Book> books;

    public ServiceImpl() {
        books = new ArrayList<>();
        books.add(new Book(1L, "Book1", new BigDecimal("10.1")));
        books.add(new Book(2L, "Book2", new BigDecimal("11.1")));
        books.add(new Book(3L, "Book3", new BigDecimal("12.1")));
    }

    public Mono<List<Book>> getAllBooks() {
        return Mono.just(books);
    }
}
