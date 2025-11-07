package ru.tikhonovaf.hibernaten1.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.tikhonovaf.hibernaten1.dto.AuthorFullDto;
import ru.tikhonovaf.hibernaten1.dto.BookShortDto;
import ru.tikhonovaf.hibernaten1.entity.AuthorAgg;
import ru.tikhonovaf.hibernaten1.repo.AuthorAggRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class AuthorAggService {

    private final AuthorAggRepository repo;
    private final ObjectMapper mapper;

    public AuthorAggService(AuthorAggRepository repo, ObjectMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<AuthorFullDto> getAuthors() {
        return repo.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    private AuthorFullDto toDto(AuthorAgg agg) {
        return new AuthorFullDto(
                agg.getId(),
                agg.getName(),
                agg.getGenres() != null ? Arrays.asList(agg.getGenres()) : List.of(),
                parseBooks(agg.getBooksJson())
        );
    }

    private List<BookShortDto> parseBooks(String json) {
        if (json == null)
            return List.of();

        try {
            return mapper.readValue(
                    json,
                    new TypeReference<List<BookShortDto>>() {}
            );
        } catch (Exception e) {
            throw new RuntimeException("Cannot parse books JSON", e);
        }
    }
}
