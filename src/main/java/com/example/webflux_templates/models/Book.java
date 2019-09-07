package com.example.webflux_templates.models;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long id;
    private String name;
    private BigDecimal price;
}
