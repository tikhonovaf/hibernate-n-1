CREATE TABLE IF NOT EXISTS genre (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS author (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS book (
                      id SERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      publisher VARCHAR(255),
                      year INT,
                      author_id INT REFERENCES author(id)
);

CREATE TABLE IF NOT EXISTS author_genre (
                              author_id INT REFERENCES author(id),
                              genre_id INT REFERENCES genre(id),
                              PRIMARY KEY (author_id, genre_id)
);
