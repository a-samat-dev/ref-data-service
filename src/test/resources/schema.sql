create table if not exists cities
(
    id        integer primary key,
    name_kz   varchar(155) not null,
    name_en   varchar(155) not null,
    name_ru   varchar(155) not null,
    parent_id integer references cities (id)
);

create table if not exists doctor_types
(
    id        integer primary key,
    name_kz   varchar(155) not null,
    name_en   varchar(155) not null,
    name_ru   varchar(155) not null,
    parent_id integer references cities (id)
);

insert into cities (id, name_kz, name_en, name_ru)
values (1, 'Astana', 'Astana', 'Астана');
insert into cities (id, name_kz, name_en, name_ru)
values (2, 'Almaty', 'Almaty', 'Алматы');

insert into doctor_types(id, name_kz, name_en, name_ru)
values (1, 'Педиатр', 'Pediatrist', 'Педиатр');
insert into doctor_types(id, name_kz, name_en, name_ru)
values (2, 'Терапевт', 'Therapist', 'Терапевт');