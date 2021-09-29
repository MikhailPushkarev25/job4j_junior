create table departments(
	id serial primary key,
	name varchar(255)
);

create table emploers(
	id serial primary key,
	name varchar(255),
	dep_id int references departments(id)
);

insert into departments(name) values('Разработки');
insert into departments(name) values('Маркетинга');
insert into departments(name) values('Продаж');

insert into emploers(name, dep_id) values('Mike', 1);
insert into emploers(name, dep_id) values('Roman', 2);
insert into emploers(name, dep_id) values('Oleg', 3);
insert into emploers(name, dep_id) values('Nikolay', null);
insert into emploers(name, dep_id) values('Elena', null);
insert into emploers(name, dep_id) values('Alexey', 1);

select * from departments d left join emploers e on e.dep_id = d.id;

select * from departments d right join emploers e on e.dep_id = d.id;

select * from departments d full join emploers e on e.dep_id = d.id;

select * from departments d cross join emploers e;

select * from departments d left join emploers e on e.dep_id = d.id where d.id is null;

select * from departments d left join emploers e on e.dep_id = d.id;

select * from emploers e right join departments d on e.dep_id = d.id;

create table teens(
	id serial primary key,
	name text,
	gender text
);

insert into teens(name, gender) values('Mike', 'm');
insert into teens(name, gender) values('Elena', 'g');
insert into teens(name, gender) values('Roman', 'm');
insert into teens(name, gender) values('Ksenia', 'g');
insert into teens(name, gender) values('Oleg', 'm');
insert into teens(name, gender) values('Vika', 'g');

select * from teens t1 cross join teens t2 where t1.gender != t2.gender;