create table people(
	id serial primary key,
	name text,
	age int
);

create table product(
	id serial primary key,
	name text,
	people_id int references people(id)
);

insert into people(name, age) values('Mikhail', 25);
insert into people(name, age) values('Roman', 30);
insert into people(name, age) values('Vasy', 18);
insert into people(name, age) values('Oleg', 40);

insert into product(name, people_id) values('apple', 1);
insert into product(name, people_id) values('milk', 2);
insert into product(name, people_id) values('chize', 3);
insert into product(name, people_id) values('coca-cola', 4);

select p.name, p.age, prod.name from people as p join product as prod on p.id = prod.people_id;
select p.name, p.age, prod.name from people as p join product as prod on p.id = prod.people_id where p.name like '%m%';
select p.name, p.age, prod.name from people as p join product as prod on p.id = prod.people_id and prod.people_id > 2;
