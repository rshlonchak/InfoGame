CREATE TABLE IF NOT EXISTS "units"
(
    id                           integer GENERATED ALWAYS AS IDENTITY,
    name                         VARCHAR(128),
    description                  VARCHAR(4000),
    image                        VARCHAR(255),
    PRIMARY KEY (id)
    );