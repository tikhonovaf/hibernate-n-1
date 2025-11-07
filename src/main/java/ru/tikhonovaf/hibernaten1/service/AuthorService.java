package ru.tikhonovaf.hibernaten1.service;


import lombok.RequiredArgsConstructor;
import ru.tikhonovaf.hibernaten1.dto.*;
import ru.tikhonovaf.hibernaten1.entity.Author;
import ru.tikhonovaf.hibernaten1.entity.AuthorAgg;
import ru.tikhonovaf.hibernaten1.repo.AuthorAggRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.tikhonovaf.hibernaten1.repo.AuthorAggRepositoryNative;

import java.util.*;

@Service
public class AuthorService {

    private final AuthorAggRepositoryNative repo;
//    private final ObjectMapper mapper ;

    public AuthorService(AuthorAggRepositoryNative repo) {
        this.repo = repo;
    }

    public List<AuthorDto> getAuthors() {
//        List<Author> authors = repo.fetchAuthorsFull();

//        em.clear();
        List<Author> authors =  repo.fetchAuthorsFull();

        return new ArrayList<>();
//        return repo.fetchAuthorsFull().stream()
//                .map(row -> {
//                    Long id = ((Number) row[0]).longValue();
//                    String name = (String) row[1];
//                    String[] genres = (String[]) row[2];
//                    String booksJson = row[3].toString();
//
//                    List<BookDto> books;
//                    try {
//                        books = mapper.readValue(
//                                booksJson,
//                                new TypeReference<List<BookDto>>() {}
//                        );
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//
//                    return new AuthorDto(
//                            id,
//                            name,
//                            Arrays.asList(genres),
//                            books
//                    );
//                })
//                .toList();
//    }
    }
}
