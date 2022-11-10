CREATE TABLE IF NOT EXISTS "games"
(
    id                           integer GENERATED ALWAYS AS IDENTITY,
    name                         VARCHAR(128) UNIQUE,
    description                  VARCHAR(2048),
    PRIMARY KEY (id)
);