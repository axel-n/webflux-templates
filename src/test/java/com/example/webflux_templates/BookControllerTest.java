package com.example.webflux_templates;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void allBooks() {
        webTestClient
                .get().uri("/books")
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class);
    }
}
