
CREATE TABLE users(
id int Auto_increment primary key,
name varchar (255) not null,
login varchar(255) not null,
password varchar(255) not null,
email    varchar(255) null,
status     varchar(20) null
);

CREATE table dishes (
   id    int  Auto_increment primary key,
   name  varchar (50) not null,
   price int  not null

);

CREATE TABLE menu  (
dishId int not null
);

CREATE table orders (
	id     int(36)Auto_increment primary key not null,
	userId int(50)
);

INSERT INTO dishes(name, price)
Values ('borsch', 20),
	   ('fish', 30),
	   ('salad', 15),
	   ('pizza', 100),
	   ('sushi', 90),
	   ('salo', 25),
	   ('vodka', 150),
	   ('vine', 160),
	   ('bread', 5),
       ('hamburger', 50);

INSERT INTO menu (dishId)
Values (1),
	   (2),
	   (3),
	   (4),
	   (5),
   	   (6),
	   (7),
	   (8),
	   (9),
	   (10);

CREATE table users_bank_balance (
	userId    int(36) not null primary key,
	money int
);

INSERT INTO users_bank_balance(userId, money)
Values (1, 2000),
	   (2, 300),
	   (3, 1500),
	    (4, 5500),
		 (5, 700),
		  (6, 800),
		   (9, 30000),
		    (8, 38700);

INSERT INTO users (name,login,password,email,status) Values ('Andrew','admin','1111','admin@imail','Admin');
