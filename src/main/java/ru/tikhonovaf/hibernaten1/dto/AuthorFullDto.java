package ru.tikhonovaf.hibernaten1.dto;

import java.util.List;

public record AuthorFullDto(
        Long id,
        String name,
        List<String> genres,
        List<BookShortDto> books
) {}
