create table use(
	id serial primary key,
	name varchar(255),
	surname text,
	age int
);
insert into use(name, surname, age) values('Mike', 'Pushkarev', 25);
update use set surname = 'Kozlov';
delete from use;
select * from use;