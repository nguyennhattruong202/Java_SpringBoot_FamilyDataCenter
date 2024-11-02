drop database if exists `fdcdb`;
create schema `fdcdb` default character set utf8mb4 collate utf8mb4_unicode_ci;
drop table if exists `fdcdb`.`wp_table1`;
create table `fdcdb`.`wp_table1`(
`id` int auto_increment,
`fullname` varchar(200) not null,
`date_of_birth` date null default null,
`created_date` datetime null default null,
`updated_date` datetime null default null,
primary key(`id`)
)
engine = InnoDB
default character set = utf8mb4
collate = utf8mb4_unicode_ci;

drop table if exists `fdcdb`.`user`;
create table `fdcdb`.`user`(
`user_id` int auto_increment,
`fullname` varchar(200) not null,
`gender` varchar(10) not null,
`date_of_birth` date null default null,
`phone` varchar(20) not null,
`email` varchar(200) null default null,
`id_number` varchar(20) null default null,
`address` varchar(200) null default null,
`updated_date` datetime not null,
`created_date` datetime not null,
`note` text null default null,
primary key(`user_id`)
)
engine = InnoDB
default character set = utf8mb4
collate = utf8mb4_unicode_ci;

alter table `fdcdb`.`user` rename to `fdcdb`.`patient`;
alter table `fdcdb`.`patient` change column `user_id` `patient_id` int not null auto_increment;

drop table if exists `fdcdb`.`hospital`;
create table `fdcdb`.`hospital`(
`hospital_id` int auto_increment,
`name` varchar(200) not null,
`address` varchar(200) not null,
`phone` varchar(20) null default null,
`email` varchar(200) null default null,
`url` varchar(200) null default null,
primary key(`hospital_id`)
)
engine = InnoDB
default character set = utf8mb4
collate = utf8mb4_unicode_ci;

drop table if exists `fdcdb`.`health_profile`;
create table `fdcdb`.`health_profile`(
`health_profile_id` int auto_increment,
`code` varchar(200) null default null,
`type` varchar(200) null default null,
`health_insurance_id` varchar(200) null default null,
`note` text null default null,
`patient_id` int not null,
`hospital_id` int not null, 
primary key(`health_profile_id`),
constraint `conn1` foreign key(`patient_id`) references `fdcdb`.`patient`(`patient_id`) on delete restrict on update restrict,
constraint `conn2` foreign key(`hospital_id`) references `fdcdb`.`hospital`(`hospital_id`) on delete restrict on update restrict
)
engine = InnoDB
default character set = utf8mb4
collate = utf8mb4_unicode_ci;

drop table `fdcdb`.`health_profile`;
drop table `fdcdb`.`hospital`;
drop table `fdcdb`.`wp_table1`;

drop table if exists `fdcdb`.`user`;
create table `fdcdb`.`user`(
`user_id` bigint auto_increment,
`fullname` varchar(200) not null,
`gender` varchar(10) not null,
`date_of_birth` date not null,
`phone` varchar(20) unique not null,
`email` varchar(200) null default null,
`id` varchar(20) null default null,
`address` varchar(200) null default null,
`password` varchar(100) not null,
`role` varchar(10) not null,
`created_date` datetime not null,
`updated_date` datetime not null,
`note` tinytext null default null,
primary key(`user_id`)
)
engine = InnoDB
default character set = utf8mb4
collate = utf8mb4_unicode_ci;

drop table if exists `fdcdb`.`user_demo`;
create table `fdcdb`.`user_demo`(
`id` varchar(100),
`fullname` varchar(200) not null,
`date_of_birth` date not null,
`email` varchar(200) not null,
`password` varchar(100) not null,
`role` varchar(10) not null,
primary key(`id`)
)
engine = InnoDB
default character set = utf8mb4
collate = utf8mb4_unicode_ci;