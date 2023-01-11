CREATE TABLE IF NOT EXISTS "user"
(
    id      NUMERIC PRIMARY KEY,
    nif     VARCHAR(50)  NOT NULL,
    name    VARCHAR(50)  NOT NULL,
    surname VARCHAR(50)  NOT NULL,
    email   VARCHAR(100) NOT NULL
);

CREATE SEQUENCE user_seq START 1 INCREMENT 1;

CREATE TABLE IF NOT EXISTS address
(
    id          NUMERIC     NOT NULL PRIMARY KEY,
    address     VARCHAR(50) NOT NULL,
    city        VARCHAR(50) NOT NULL,
    region      VARCHAR(50) NOT NULL,
    postal_code VARCHAR(10) NOT NULL,
    user_id     BIGINT      NOT NULL,
    CONSTRAINT USER_ID_FK FOREIGN KEY (user_id) REFERENCES "user" (id)
);

CREATE SEQUENCE address_seq START 1 INCREMENT 1;