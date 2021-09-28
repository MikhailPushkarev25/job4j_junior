create table devices(
	id serial primary key,
	name varchar(255),
	price float
);

create table people(
	id serial primary key,
	name text
);

create table devices_people(
	id serial primary key,
	devices_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values('компьтер', 35000), ('телефон', 50000), ('мышка', 2000), ('клавиатура', 10000);

insert into people(name) values('Михаил'), ('Роман'), ('Александр');

insert into devices_people(devices_id, people_id) values(1, 1);
insert into devices_people(devices_id, people_id) values(1, 2);
insert into devices_people(devices_id, people_id) values(1, 3);
insert into devices_people(devices_id, people_id) values(1, 4);

insert into devices_people(devices_id, people_id) values(2, 1);
insert into devices_people(devices_id, people_id) values(2, 2);
insert into devices_people(devices_id, people_id) values(2, 3);
insert into devices_people(devices_id, people_id) values(2, 4);

insert into devices_people(devices_id, people_id) values(3, 1);
insert into devices_people(devices_id, people_id) values(3, 2);
insert into devices_people(devices_id, people_id) values(3, 3);
insert into devices_people(devices_id, people_id) values(3, 4);

insert into devices_people(devices_id, people_id) values(4, 1);
insert into devices_people(devices_id, people_id) values(4, 2);
insert into devices_people(devices_id, people_id) values(4, 3);
insert into devices_people(devices_id, people_id) values(4, 4);

select avg(price) from devices;

select p.name, avg(d.price) from devices_people as dp join devices as d
on dp.devices_id = d.id join people as p on dp.people_id = d.id
group by p.name;

select p.name, avg(d.price) from devices_people as dp join devices as d
on dp.devices_id = d.id join people as p on dp.people_id = d.id
group by p.name
having avg(d.price) > 5000;
