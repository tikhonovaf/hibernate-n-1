package ru.tikhonovaf.hibernaten1.dto;

import java.util.List;

public record AuthorDto(
        Long id,
        String name,
        List<String> genres,
        List<BookDto> books
) { }
