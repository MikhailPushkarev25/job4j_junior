create table passport(
	id serial primary key,
	seria int,
	number int
);

create table people(
	id serial primary key,
	name varchar(255),
	passport_id int references passport(id) unique
);

insert into passport(seria, number) values(1111, 3084);

insert into passport(seria, number) values(12345, 9379375);
insert into passport(seria, number) values(1324, 23525);

insert into people(name, passport_id) values('Ivan', 1);
insert into people(name, passport_id) values('Roman', 2);
insert into people(name, passport_id) values('Mikhail', 3);

insert into people(name) values('Vasy');
insert into people(name) values('Oleg');

select * from people inner join passport p on people.passport_id = p.id;
select * from people join passport p on people.passport_id = p.id;