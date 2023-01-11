drop table if exists ref_data;
create table if not exists ref_data
(
    id        int primary key,
    name_kz   varchar(155) not null,
    name_en   varchar(155) not null,
    name_ru   varchar(155) not null,
    data_type varchar(155) not null
);