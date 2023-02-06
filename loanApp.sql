
/* Drop Tables */

DROP TABLE IF EXISTS staff_department;
DROP TABLE IF EXISTS Department;
DROP TABLE IF EXISTS loan_record;
DROP TABLE IF EXISTS staff_page;
DROP TABLE IF EXISTS page;
DROP TABLE IF EXISTS Staff;
DROP TABLE IF EXISTS staff_group;

CREATE TABLE Department
(
	dep_id SERIAL NOT NULL UNIQUE,
	dep_name varchar(50) NOT NULL,
	dep_desc varchar(50) NOT NULL,
	dep_code varchar(40) NOT NULL,
	PRIMARY KEY (dep_id)
) WITHOUT OIDS;


CREATE TABLE loan_record
(
	loan_id SERIAL NOT NULL UNIQUE,
	loan_type varchar(50) NOT NULL,
	period varchar(60) NOT NULL,
	amount int NOT NULL,
	address varchar(60) NOT NULL,
	apply_date date NOT NULL,
	create_at date,
	update_at date,
	staff_id int NOT NULL,
	dep_id int NOT NULL,
	PRIMARY KEY (loan_id)
) WITHOUT OIDS;


CREATE TABLE page
(
	page_id SERIAL NOT NULL UNIQUE,
	page_name varchar(60) NOT NULL,
	page_code varchar(40),
	page_desc varchar(40),
	PRIMARY KEY (page_id)
) WITHOUT OIDS;


CREATE TABLE Staff
(
	staff_id SERIAL NOT NULL UNIQUE,
	name varchar(50) NOT NULL,
	email varchar(60) NOT NULL,
	password varchar(60) NOT NULL,
	account_status varchar(50),
	created_at date,
	updated_at date,
	group_id int NOT NULL,
	PRIMARY KEY (staff_id)
) WITHOUT OIDS;


CREATE TABLE staff_department
(
	staff_id int NOT NULL,
	dep_id int NOT NULL
) WITHOUT OIDS;


CREATE TABLE staff_group
(
	group_id SERIAL NOT NULL UNIQUE,
	group_name varchar(50) NOT NULL,
	group_code varchar(40) NOT NULL,
	PRIMARY KEY (group_id)
) WITHOUT OIDS;


CREATE TABLE staff_page
(
	staff_id int NOT NULL,
	page_id int NOT NULL
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE staff_department
	ADD FOREIGN KEY (dep_id)
	REFERENCES Department (dep_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE staff_page
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

ALTER TABLE loan_record
	ADD FOREIGN KEY (dep_id)
	REFERENCES Department (dep_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE staff_department
	ADD FOREIGN KEY (staff_id)
	REFERENCES Staff (staff_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE staff_page
	ADD FOREIGN KEY (staff_id)
	REFERENCES Staff (staff_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Staff
	ADD FOREIGN KEY (group_id)
	REFERENCES staff_group (group_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



