CREATE TABLE IF NOT EXISTS "categories"
(
    id                           integer GENERATED ALWAYS AS IDENTITY,
    name                         VARCHAR(128),
    description                  VARCHAR(2048),
    image                        VARCHAR(255),
    PRIMARY KEY (id)
    );