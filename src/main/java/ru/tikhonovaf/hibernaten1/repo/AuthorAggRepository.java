package ru.tikhonovaf.hibernaten1.repo;

import ru.tikhonovaf.hibernaten1.entity.AuthorAgg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorAggRepository extends JpaRepository<AuthorAgg, Long> {
}
