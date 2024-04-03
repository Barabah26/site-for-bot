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

INSERT INTO public.students (id, pip, group_name, year_entry, phone_number, statement, status) VALUES (13, 'Сало Олена Богданівна', 'КН33с', '2021', '38096435433', 'Довідка з місця навчання', false);
INSERT INTO public.students (id, pip, group_name, year_entry, phone_number, statement, status) VALUES (8, 'Козак Максим Ростиславович', 'КН33с', '2021', '38096435433', 'Довідка з місця навчання', false);
INSERT INTO public.students (id, pip, group_name, year_entry, phone_number, statement, status) VALUES (10, 'Бурдяк Владислав Володимиривоч ', 'КБ31', '2021', '38096435433', 'Довідка з місця навчання', false);
INSERT INTO public.students (id, pip, group_name, year_entry, phone_number, statement, status) VALUES (5, 'Кмита Сергій Володимирович', 'КН33с', '2021', '38096435433', 'Довідка у військкомат', false);
INSERT INTO public.students (id, pip, group_name, year_entry, phone_number, statement, status) VALUES (6, 'Гірковий Роман Андрійович', 'КН33с', '2021', '38096435433', 'Довідка з місця навчання', false);
INSERT INTO public.students (id, pip, group_name, year_entry, phone_number, statement, status) VALUES (4, 'Барабах Павло Романович', 'КН33с', '2021', '38096435433', 'Довідка у військкомат', false);
INSERT INTO public.students (id, pip, group_name, year_entry, phone_number, statement, status) VALUES (11, 'Дячок Уляна Іванівна', 'КН33с', '2021', '38096435433', 'Довідка з місця навчання', false);
INSERT INTO public.students (id, pip, group_name, year_entry, phone_number, statement, status) VALUES (12, 'Савич Анастісія Ігорівна', 'КН33с', '2021', '38096435433', 'Довідка з місця навчання', false);
INSERT INTO public.students (id, pip, group_name, year_entry, phone_number, statement, status) VALUES (9, 'Козак Максим Андрійович', 'КН33с', '2021', '38096435433', 'Довідка у військкомат', false);
INSERT INTO public.students (id, pip, group_name, year_entry, phone_number, statement, status) VALUES (7, 'Супик Іван Васильович', 'КН33с', '2021', '38096435433', 'Довідка з місця навчання', false);
