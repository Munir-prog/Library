//MYSQL
CREATE TABLE users
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE roles
(
    id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
) ENGINE = InnoDB;


CREATE TABLE user_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),
    UNIQUE (user_id, role_id)
) ENGINE = InnoDB;

INSERT INTO users
VALUES (1, 'munir', '$2a$12$NoiGTyQBrBSEIFIyTV6VGeTRyqYt.4Z/aK.3xjAlY9toHUtrkWHuC');
INSERT INTO roles
VALUES (1, 'ROLE_USER');
INSERT INTO roles
VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles
VALUES (1, 2);


CREATE TABLE genre
(
    id         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    genre_name VARCHAR(15) NOT NULL
);

CREATE TABLE author
(
    id      INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(30) NOT NULL,
    surname VARCHAR(30) NOT NULL,
    age     INT         NOT NULL,
    image   TEXT        NOT NUll,
    user_id INT REFERENCES users (id)
);

CREATE TABLE book
(
    id              INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tittle          VARCHAR(30) NOT NULL,
    publishing_name VARCHAR(30) NOT NULL,
    page            INT         NOT NULL,
    image           TEXT        NOT NULL,
    quantity        INT,
    genre_id        INT REFERENCES genre (id),
    user_id         INT REFERENCES users (id)
);

CREATE TABLE book_author
(
    book_id   INT REFERENCES book (id),
    author_id INT REFERENCES author (id)
);
