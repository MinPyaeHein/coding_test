
/* Drop Tables */

DROP TABLE IF EXISTS sale;
DROP TABLE IF EXISTS Students;
DROP TABLE IF EXISTS users;




/* Create Tables */

CREATE TABLE sale
(
	product_name varchar(50) NOT NULL,
	price int NOT NULL,
	user_id bigint NOT NULL UNIQUE,
	id int NOT NULL UNIQUE
) WITHOUT OIDS;


CREATE TABLE Students
(
	id int NOT NULL UNIQUE,
	name varchar(50) NOT NULL,
	email varchar(60) NOT NULL,
	mail_status boolean NOT NULL,
	password varchar(20) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE users
(
	user_id bigint NOT NULL UNIQUE,
	name varchar(100) NOT NULL,
	phone_no varchar(20) NOT NULL,
	email varchar(30) NOT NULL,
	mail_status boolean NOT NULL,
	created_date date NOT NULL,
	PRIMARY KEY (user_id)
);


/* Create Foreign Keys */

ALTER TABLE sale
	ADD FOREIGN KEY (id)
	REFERENCES Students (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sale
	ADD FOREIGN KEY (user_id)
	REFERENCES users (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



