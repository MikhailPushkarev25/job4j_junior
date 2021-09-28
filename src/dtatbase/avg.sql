create table students(
	id serial primary key,
	name text
);

create table subjects(
	id serial primary key,
	name text
);

create table students_subjects(
	id serial primary key,
	mark float,
	std_id int references students(id),
	sbj_id int references subjects(id)
);

insert into students(name) values('Михаил'), ('Олег'), ('Роман');

insert into subjects(name) values('математика'), ('экономика'), ('Русский язык');

insert into students_subjects(std_id, sbj_id, mark) values(1, 1, 5), (1, 2, 5), (1, 3, 4);
insert into students_subjects(std_id, sbj_id, mark) values(2, 1, 4), (2, 2, 5), (2, 3, 3);
insert into students_subjects(std_id, sbj_id, mark) values(3, 1, 3), (3, 2, 3), (3, 3, 4);

select s.name, avg(ss.mark) from students_subjects as ss join subjects as s on ss.sbj_id = s.id
group by s.name;

select s.name, avg(ss.mark) from students_subjects as ss join students as s on ss.std_id = s.id
group by s.name;

select s.name, avg(ss.mark) from students_subjects as ss join subjects as s on ss.sbj_id = s.id
group by s.name
having avg(ss.mark) > 4.2;