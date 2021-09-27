create table fauna(
	id serial primary key,
	name text,
	avg_age int,
	discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values('tiger', 2500, '22.01.1996');
insert into fauna(name, avg_age, discovery_date) values('zebra', 5000, '01.01.1905');
insert into fauna(name, avg_age, discovery_date) values('puma', 10000, '05.08.1987');
insert into fauna(name, avg_age, discovery_date) values('fox', 3900, '30.03.1903');
insert into fauna(name, avg_age, discovery_date) values('dog', 2000, '28.05.1800');
insert into fauna(name, avg_age, discovery_date) values('cat', 15000, '07.09.1920');
insert into fauna(name, avg_age, discovery_date) values('fish', 15000, '31.12.1900');

select * from fauna where name like 'f%';
select * from fauna where avg_age >= 2500 and avg_age <= 10000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '07.09.1920';