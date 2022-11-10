CREATE TABLE IF NOT EXISTS "users"
(
    id                           integer GENERATED ALWAYS AS IDENTITY,
    name                         VARCHAR(128),
    email                        VARCHAR(128) UNIQUE,
    PRIMARY KEY (id)
);
