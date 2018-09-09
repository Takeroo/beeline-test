create table if not exists beeline.users
(
	user_id serial not null
		constraint user_user_id_pk
			primary key,
	username varchar(50) not null unique,
	password varchar(50) not null,
	fullname varchar(100) not null,
	phone_number varchar(20),
	is_admin boolean not null default false
);

create table if not exists beeline.company
(
	company_id serial not null
		constraint company_company_id_pk
			primary key,
	name varchar(255) not null,
	website varchar(100)
);

create table if not exists beeline.trade_point
(
	point_id serial not null
		constraint trade_point_point_id_pk
			primary key,
	name varchar(255) not null,
	company_id integer not null
	  constraint trade_point_company_company_id_fk
    references company,
	phone_number varchar(20),
	address varchar(255),
	latitude numeric(12,8),
	longitude numeric(12,8),
	user_id integer not null
	  constraint trade_point_user_user_id_fk
    references users
);
