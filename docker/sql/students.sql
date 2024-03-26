create table if not exists public.students
(
    id           serial
    constraint students_pk
    primary key,
    pip          text,
    group_name   text,
    year_entry   text,
    phone_number text,
    statement    text,
    status       boolean
);

alter table public.students
    owner to root;