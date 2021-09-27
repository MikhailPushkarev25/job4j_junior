create table people(
	id serial primary key,
	name text
);

create table auto(
	id serial primary key,
	name text,
	mark text,
	people_id int references people(id)
);

insert into people(name) values('Mikhail');
insert into people(name) values('Roman');
insert into people(name) values('Vasy');

insert into auto(name, mark, people_id) values('Audi', 'rx7', 1);
insert into auto(name, mark, people_id) values('BMW', 'X5', 2);
insert into auto(name, mark, people_id) values('Honda', 'civic', 3);


select pp.name, a.name, a.mark from people as pp join auto as a on a.people_id = pp.id;
select pp.name, a.name, a.mark from people as pp join auto as a on a.name = pp.name;
select pp.name, a.name, a.mark from people as pp join auto as a on a.name != pp.name;
