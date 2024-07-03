CREATE DATABASE quarkus-social
BEGIN;


CREATE TABLE IF NOT EXISTS Users
(
    id bigserial NOT NULL,
    name text NOT NULL,
    age integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Posts
(
    id bigserial NOT NULL,
    post_text text NOT NULL,
    dateTime timestamp NOT NULL,
    user_id bigint NOT NULL REFERENCES Users(id)
    PRIMARY KEY (id)
);
END;