CREATE TABLE customer
(
    ID BIGSERIAL NOT NULL PRIMARY KEY,
    name       varchar(255)   not null,
    email      varchar(255)   not null unique,
    cpf        varchar(11)    not null unique,
    rg         varchar(9)     not null unique,
    income     numeric(16,2) not null,
    password   varchar(255)   not null,
    zip        varchar(255)   not null,
    address    varchar(255) not null,
    country    varchar(255) not null
);
