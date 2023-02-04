
/* Drop Tables */

DROP TABLE IF EXISTS staff_role;
DROP TABLE IF EXISTS Department;
DROP TABLE IF EXISTS loan_record;
DROP TABLE IF EXISTS page;
DROP TABLE IF EXISTS Staff;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS users;



/* Create Tables */

CREATE TABLE students
(
	id SERIAL NOT NULL UNIQUE,
	name varchar(50) NOT NULL,
	email varchar(60) NOT NULL,
	password varchar(20) NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE users
(
	user_id SERIAL NOT NULL UNIQUE,
	name varchar(100) NOT NULL,
	phone_no varchar(20) NOT NULL,
	email varchar(30) NOT NULL,
	created_date date NOT NULL,
	PRIMARY KEY (user_id)
) WITHOUT OIDS;





CREATE TABLE Department
(
	dep_id SERIAL NOT NULL UNIQUE,
	dep_name varchar(50) NOT NULL,
	dep_desc varchar(50) NOT NULL,
	PRIMARY KEY (dep_id)
) WITHOUT OIDS;


CREATE TABLE loan_record
(
	loan_id SERIAL NOT NULL UNIQUE,
	loan_type varchar(50) NOT NULL UNIQUE,
	period varchar(60) NOT NULL,
	amount int NOT NULL,
	address varchar(60) NOT NULL,
	apply_date date NOT NULL,
	set_date timestamp NOT NULL,
	staff_id int NOT NULL UNIQUE,
	PRIMARY KEY (loan_id)
) WITHOUT OIDS;


CREATE TABLE page
(
	page_id SERIAL NOT NULL UNIQUE,
	page_name varchar(60) NOT NULL UNIQUE,
	PRIMARY KEY (page_id)
) WITHOUT OIDS;


CREATE TABLE Staff
(
	staff_id SERIAL NOT NULL UNIQUE,
	name varchar(50) NOT NULL,
	email varchar(60) NOT NULL UNIQUE,
	password varchar(60) NOT NULL,
	PRIMARY KEY (staff_id)
) WITHOUT OIDS;


CREATE TABLE staff_role
(
	staff_role_id SERIAL NOT NULL UNIQUE,
	staff_id int NOT NULL,
	dep_id int NOT NULL,
	page_id int NOT NULL,
	PRIMARY KEY (staff_role_id)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE staff_role
	ADD FOREIGN KEY (dep_id)
	REFERENCES Department (dep_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE staff_role
	ADD FOREIGN KEY (page_id)
	REFERENCES page (page_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE loan_record
	ADD FOREIGN KEY (staff_id)
	REFERENCES Staff (staff_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE staff_role
	ADD FOREIGN KEY (staff_id)
	REFERENCES Staff (staff_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



