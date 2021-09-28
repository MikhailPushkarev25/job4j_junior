create table type(
	id serial primary key,
	name text
);

create table product(
	id serial primary key,
	name text,
	expired_date date,
	price int,
	type_id int references type(id)
);

insert into type(name) values('Молоко'), ('Сыр'), ('Мороженое');

insert into product(name, expired_date, price, type_id) values('Молоко домик в деревне', '28.09.2020', 200, 1);
insert into product(name, expired_date, price, type_id) values('Молоко Молочник', '01.10.2020', 180, 1);
insert into product(name, expired_date, price, type_id) values('Молоко Простоквашино', '18.02.2020', 250, 1);

insert into product(name, expired_date, price, type_id) values('Сыр Ламберт', '08.01.2020', 300, 2);
insert into product(name, expired_date, price, type_id) values('Сыр Российский', '25.12.2020', 120, 2);
insert into product(name, expired_date, price, type_id) values('Сыр Моцарелла', '30.07.2020', 500, 2);

insert into product(name, expired_date, price, type_id) values('Мороженое Эскимо', '15.02.2020', 50, 3);
insert into product(name, expired_date, price, type_id) values('Мороженое Чистая линия', '10.11.2020', 120, 3);
insert into product(name, expired_date, price, type_id) values('Мороженое Пломбир', '01.07.2020', 30, 3);


select * from product as p join type as t on t.id = p.type_id where t.name = 'Сыр';
select * from product where name like 'Мороженое%';
select * from product where date_part('month', expired_date) = date_part('month', current_date + interval '1 month');
select * from product where price = (select max(price) from product);
select t.name, count(p.id) from type as t join product as p on t.id = p.type_id group by t.name;
select * from product as p join type as t on t.id = p.type_id where t.name in('Сыр', 'Молоко');
select t.name, count(p.id) from type as t join product as p on t.id = p.type_id group by t.name having count(t.id) > 10;
select from type;