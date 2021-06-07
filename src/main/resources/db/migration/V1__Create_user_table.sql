-- Id, название книги, короткое описание, год выпуска
CREATE TABLE public.book
(
    id    serial,
    title character varying(155) NOT NULL,
    about character varying(255) NOT NULL,
    year  integer                NOT NULL,
    PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    );

insert into public.book (title, about, year)
values ('book 1', 'nice book', 1937);
insert into public.book (title, about, year)
values ('book 2', 'good book', 1917);
insert into public.book (title, about, year)
values ('book 3', 'rice book', 1927);
insert into public.book (title, about, year)
values ('book 4', 'not bad book', 1947);
