create table bodywork(
	id serial primary key,
	name text
);

create table engine(
	id serial primary key,
	name text
);

create table trans(
	id serial primary key,
	name text
);

create table auto(
	id serial primary key,
	name text,
	bod_id int references bodywork(id),
	eng_id int references engine(id),
	trans_id int references trans(id)
);

insert into bodywork(name) values('хэтчбэк');
insert into bodywork(name) values('седан');
insert into bodywork(name) values('лифтбэк');

insert into engine(name) values('2.2');
insert into engine(name) values('3.0');
insert into engine(name) values('1.8');

insert into trans(name) values('Полный привод');
insert into trans(name) values('Передний привод');
insert into trans(name) values('Задний привод');

insert into auto(name, bod_id, eng_id, trans_id) values('Bmw', 1, 2, 1);
insert into auto(name, bod_id, eng_id, trans_id) values('audi', 2, 1, 3);
insert into auto(name, bod_id, eng_id, trans_id) values('honda', 3, 3, 2);


select * from auto a left join bodywork b on a.bod_id = b.id left join engine e on a.eng_id = e.id left join trans t on a.trans_id = t.id;
select * from auto a right join bodywork b on a.bod_id = b.id;
select * from auto a right join engine e on a.eng_id = e.id;
select * from auto a right join trans t on a.trans_id = t.id;
