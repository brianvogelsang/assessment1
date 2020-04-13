--tier2--
--problem 1--
select * from APP_USER where role_id = 3 order by role_id asc;

--problem 2--
insert into APP_USER (username, password, first_name, last_name, role_id) values ('brianvogelsang', 12345678, 'Brian', 'Vogelsang', 4); 

--problem 3--
select * from APP_USER full join STUDY_SET on (APP_USER.user_id = STUDY_SET.study_set_id);
------------------------
--tier 3--
CREATE USER brian WITH password 'password';
create database brian_db;
grant all privileges on database brian_db to brian;
--tables--
create table user_role(
role_id serial primary key,
name text unique not null
);
create table app_user (
user_id serial primary key,
username text unique not null,
password text not null,
first_name text not null,
last_name text not null,
role_id int references user_role(role_id)
);
create table category (
category_id serial primary key,
name text unique not null
);
create table flashcard(
flashcard_id serial primary key,
question text unique not null,
answer text not null,
category_id int references category (category_id)
);
create table study_set (
study_set_id serial primary key,
name text unique not null,
owner_id int references app_user (user_id)
);
create table study_set_card (
study_set_id int not null references study_set (study_set_id),
flashcard_id int not null references flashcard (flashcard_id)
);

select * from user_role;
select * from app_user;
select * from category;
select * from flashcard;
select * from study_set;
select * from study_set_card;


