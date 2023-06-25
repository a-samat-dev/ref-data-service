create table if not exists family_connections
(
    id        integer primary key,
    name_kz   varchar(155) not null,
    name_en   varchar(155) not null,
    name_ru   varchar(155) not null,
    parent_id integer references family_connections (id)
);

insert into family_connections (id, name_kz, name_en, name_ru)
values (1, 'Аке', 'Father', 'Отец');
insert into family_connections (id, name_kz, name_en, name_ru)
values (2, 'Ана', 'Mother', 'Мать');