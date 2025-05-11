--liquibase formatted sql
--changeset name:1_create_user_and_article_table.sql
CREATE TABLE users (
  ID INTEGER not null,
  USERNAME varchar(100) not null,
  ROLE varchar(250) NOT NULL,
  primary key ( ID )

);

CREATE TABLE articles(
  ID INTEGER not null,
  NAME varchar(100) not null,
  primary key ( ID )

)