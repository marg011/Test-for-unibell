-- liquibase formatted sql
-- changeset margo:1

CREATE TABLE client_entity
(
  id int8 generated by default as identity,
  name varchar(70) NOT NULL,
  primary key (id)
);

CREATE TABLE contact_entity
(
  id int8 generated by default as identity,
  client_id int8 NOT NULL,
  contact_type varchar(5) NOT NULL,
  contact_value varchar(50) NOT NULL,
  primary key (id)
);

alter table contact_entity add constraint fk_contact_to_client FOREIGN KEY (client_id) references client_entity;