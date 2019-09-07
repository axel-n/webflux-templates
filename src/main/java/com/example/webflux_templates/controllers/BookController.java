package com.example.webflux_templates.controllers;

import com.example.webflux_templates.models.Book;
import com.example.webflux_templates.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController extends BaseRestController {

    private final Service service;

    public BookController(Service service) {
        this.service = service;
    }

    /**
     * simple load data with mono
     */
    @GetMapping(value = "/books")
    public Mono<List<Book>> getAllBooks() {
        return service.getAllBooks();
    }

    /**
     * collect data from several resources
     */
    @GetMapping(value = "/books/{bookId}/statistic")
    public Mono<Map<String, Object>> getBookStatisticById(@PathVariable Long bookId) {

        Mono<Long> downloads = service.getTotalDownloads(bookId);
        Mono<Long> views = service.getTotalNumberOfViews(bookId);

        return Mono.zip(downloads, views)
                .map(tuple2 -> {

                    Map<String, Object> response = new HashMap<>();
                    response.put("downloads", tuple2.getT1());
                    response.put("views", tuple2.getT2());
                    return response;
                });
    }
}
