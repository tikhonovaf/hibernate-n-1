TRUNCATE TABLE author_genre;
TRUNCATE TABLE book;
DELETE FROM genre;
DELETE FROM  author;


INSERT INTO genre (id, name) VALUES
                                 (1, 'Боевики'),
                                 (2, 'Фэнтези'),
                                 (3, 'Детективы'),
                                 (4, 'Мелодрамы');

INSERT INTO author (id, name) VALUES
                                  (101, 'Джон Смит'),
                                  (102, 'Анна Ли');

INSERT INTO author_genre (author_id, genre_id) VALUES
                                                   (101, 1),
                                                   (102, 3),
                                                   (101, 2),
                                                   (102, 4);

INSERT INTO book (title, publisher, year, author_id) VALUES
                                                         ('Охота на тени', 'Penguin', 2022, 101),
                                                         ('Последний след', 'O''Reilly', 2023, 102),
                                                         ('Магический рассвет', 'HarperCollins', 2021, 101),
                                                         ('Сердце дракона', 'AST', 2020, 102);
