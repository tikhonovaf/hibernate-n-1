package ru.tikhonovaf.hibernaten1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tikhonovaf.hibernaten1.dto.AuthorFullDto;
import ru.tikhonovaf.hibernaten1.service.AuthorAggService;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorAggController {

    private final AuthorAggService service;

    public AuthorAggController(AuthorAggService service) {
        this.service = service;
    }

    @GetMapping
    public List<AuthorFullDto> getAuthors() {
        return service.getAuthors();
    }
}
