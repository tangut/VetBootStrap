create sequence hibernate_sequence start 1 increment 1;
create table diagnose (
id int4 not null,
medicine varchar(2048),
name varchar(255),
simptome varchar(2048),
pet_id int4, primary key (id)
);
create table pet (
id int4 not null,
breed varchar(255),
filename varchar(255),
kind varchar(255),
name varchar(255),
diagnose_id int4,
user_id int8,
primary key (id)
);
create table user_role (
user_id int8 not null,
roles varchar(255)
);
create table usr (
id int8 not null,
active boolean not null,
password varchar(255) not null,
username varchar(255) not null,
primary key (id)
);
alter table if exists diagnose add constraint diagnose_pet_fk foreign key (pet_id) references pet;
alter table if exists pet add constraint pet_diagnose_fk foreign key (diagnose_id) references diagnose;
alter table if exists pet add constraint pet_user_fk foreign key (user_id) references usr;
alter table if exists user_role add constraint role_usr_fk foreign key (user_id) references usr;