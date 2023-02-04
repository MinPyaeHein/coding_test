
/* Drop Tables */

DROP TABLE IF EXISTS loan_record;
DROP TABLE IF EXISTS Staff;
DROP TABLE IF EXISTS Department;
DROP TABLE IF EXISTS page;




/* Create Tables */

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
	account_status varchar(50),
	page_id int NOT NULL UNIQUE,
	dep_id int NOT NULL UNIQUE,
	PRIMARY KEY (staff_id)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE Staff
	ADD FOREIGN KEY (dep_id)
	REFERENCES Department (dep_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Staff
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



