package com.example.webflux_templates.service;

import com.example.webflux_templates.models.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface Service {

    Mono<List<Book>> getAllBooks();
}
