CREATE DATABASE quarkus-social
BEGIN;


CREATE TABLE IF NOT EXISTS Users
(
    id bigserial NOT NULL,
    name text NOT NULL,
    age integer NOT NULL,
    PRIMARY KEY (id)
);
END;