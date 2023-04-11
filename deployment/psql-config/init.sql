CREATE SCHEMA IF NOT EXISTS zetro_portfolio;

create sequence zetro_portfolio.hibernate_sequence
    as integer;

create table zetro_portfolio.wiki_nodes
(
    path text not null
        primary key,
    icon text,
    name text,
    type text,
    url  text
);
