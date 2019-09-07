package com.example.webflux_templates;

import com.example.webflux_templates.models.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

    @Value("${apiRootPath}")
    private String rootApi;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void allBooks() {
        EntityExchangeResult<List> result = webTestClient
                .get().uri(rootApi + "/books")
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .returnResult();

        List<Book> books = result.getResponseBody();

        assertNotNull(books);
        assertTrue(books.size() > 0);
    }

    @Test
    public void bookStatistic() {
        EntityExchangeResult<Map> result = webTestClient
                .get().uri(rootApi + "/books/1/statistic")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Map.class)
                .returnResult();

        Map<String, Object> map = result.getResponseBody();

        assertNotNull(map);
        assertNotNull(map.get("downloads"));
        assertNotNull(map.get("views"));
    }
}
