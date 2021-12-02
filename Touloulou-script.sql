create database company;
use company;
create table employee (
	id int(11) not null auto_increment,
	lastname varchar(70) not null, 
    firstname varchar(70) not null,
    email varchar(128) not null,
	age int(3) not null, 
    jobTitle varchar(128) not null, 
    phoneNumber varchar(20) not null, 
    address varchar(255) not null, 
    primary key (id),
    unique key id_unique(id)
) engine=InnoDB

    