-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into livro (id, nome, ibsn, autor, editora, idioma, id_categoria) values(nextval('hibernate_sequence'), 'Manual', '123456', 'Joãozinho', 'Editora Books', 'PT-BR', 1);
insert into livro (id, nome, ibsn, autor, editora, idioma, id_categoria) values(nextval('hibernate_sequence'), 'Bíblia', '987654321', 'Lucas', 'Editora Books', 'PT-BR', 2);

insert into categoria (id, nome) values(nextval('hibernate_sequence'), 'Romance');
insert into categoria (id, nome) values(nextval('hibernate_sequence'), 'Terror');
insert into categoria (id, nome) values(nextval('hibernate_sequence'), 'Ficção científica');
insert into categoria (id, nome) values(nextval('hibernate_sequence'), 'Policial');