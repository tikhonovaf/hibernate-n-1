//package ru.tikhonovaf.hibernaten1;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//import ru.tikhonovaf.hibernaten1.entity.Author;
//import ru.tikhonovaf.hibernaten1.repo.AuthorAggRepositoryNative;
//import ru.tikhonovaf.hibernaten1.repo.AuthorRepository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@SpringBootTest
//@Transactional
//public class AuthorNativeQueryTest {
//
//    @Autowired
//    private AuthorRepository authorRepository;
//
//    @Autowired
//    private AuthorAggRepositoryNative authorAggRepository;
//
//    @PersistenceContext
//    private EntityManager em;
//
//    private Long authorId;
//
//    @BeforeEach
//    void setup() {
//        // Создаём тестового автора
//        Author a = new Author();
//        a.setId(300L);
//        a.setName("Pushkin");
//        authorRepository.save(a);
//
//        authorId = a.getId();
//        em.flush();
//        em.clear(); // гарантируем пустой persistence context
//    }
//
//    @Test
//    void testAuthorLoadedNormally() {
//        // Загрузка обычным способом
//        Author a = authorRepository.findById(authorId).orElseThrow();
//
//        assertThat(a.getName()).isEqualTo("Pushkin");
//        assertThat(a.getBooks()).isEmpty();
//    }
//
//    @Test
//    void testNativeQueryDoesNotPopulateAuthorFields() {
//        // 1) Убедимся, что контекст полностью чистый
//        em.clear();
//
//        // 2) Вызываем native query, который возвращает List<Author>
//        var authors = authorAggRepository.fetchAuthorsFull();
//        Author a = authors.get(0);
//
//        // 3) Проверяем, что Hibernate НЕ заполнил поля из JSON/ARRAY
//        assertThat(a.getName()).isEqualTo("Pushkin");
//
//        // ❗ А вот тут Hibernate ничего НЕ знает о книгах или жанрах
//        assertThat(a.getBooks()).isEmpty();
//        assertThat(a.getGenres()).isEmpty();
//    }
//
//    @Test
//    void testLazyInitializationAfterClear() {
//        // 1. Загрузили автора
//        Author a = authorRepository.findById(101L).orElseThrow();
//
//        // 2. Очистили persistence context
//        em.clear();
//
//        // 3. Теперь коллекции — ленивые, и объект отсоединён
//        assertThrows(org.hibernate.LazyInitializationException.class, () -> {
//            a.getBooks().size();
//        });
//    }
//}
