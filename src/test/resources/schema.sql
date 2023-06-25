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

create table if not exists family_connections
(
    id        integer primary key,
    name_kz   varchar(155) not null,
    name_en   varchar(155) not null,
    name_ru   varchar(155) not null,
    parent_id integer references family_connections (id)
);