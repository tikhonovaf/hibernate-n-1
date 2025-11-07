package ru.tikhonovaf.hibernaten1.controller;

import ru.tikhonovaf.hibernaten1.dto.AuthorDto;
import ru.tikhonovaf.hibernaten1.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<AuthorDto> getAll() {
        return service.getAuthors();
    }
}
