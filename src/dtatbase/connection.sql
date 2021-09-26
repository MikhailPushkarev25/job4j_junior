create table cook(
	id serial primary key,
	name varchar(255)
);

create table dish(
	id serial primary key,
	name varchar(255),
	cook_id int references cook(id)
);


create table auto(
	id serial primary key,
	name varchar(255)
);

create table number_auth(
	id serial primary key,
	num int,
	auto_id references int auto(id) unique
);


create table park(
	id serial primary key,
	name varchar(255)
);

create table people(
	id serial primary key,
	name varchar(255)
);

create table park_people(
	id serial primary key,
	park_id int references park(id),
	people_id int references people(id)
);