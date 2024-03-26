create table admins
(
    id       serial
        constraint admins_pk
            primary key,
    login    text,
    password text,
    username text
);

alter table admins
    owner to root;

insert into admins(login, password, username) values ('Pavlo', 'Barabah', 'Павло Барабах');
insert into admins(login, password, username) values ('Serhiy', 'Kmyta', 'Сергій Кмита');