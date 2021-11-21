create table j_mark (
    id serial primary key,
    name varchar(2000)
);

create table j_model (
    id serial primary key,
    name varchar(2000),
    mark_id int references j_mark(id)
);