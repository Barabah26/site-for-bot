create table admins
(
    id       serial
        constraint admins_pk
            primary key,
    login    text,
    password text
);

alter table admins
    owner to root;

insert into admins(login, password) values ('Pavlo', 'Barabah');
insert into admins(login, password) values ('Serhiy', 'Kmyta');
