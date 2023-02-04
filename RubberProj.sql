SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS daily_record;
DROP TABLE IF EXISTS manager;
DROP TABLE IF EXISTS bus_owner;
DROP TABLE IF EXISTS Owner;
DROP TABLE IF EXISTS bank_info;
DROP TABLE IF EXISTS Business_Info;
DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS division;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS password;
DROP TABLE IF EXISTS personal_info;
DROP TABLE IF EXISTS salary_rate;




/* Create Tables */

CREATE TABLE bank_info
(
	b_info_id int NOT NULL AUTO_INCREMENT,
	bank_name varchar(60) NOT NULL,
	bank_account varchar(70) NOT NULL,
	PRIMARY KEY (b_info_id),
	UNIQUE (b_info_id)
);


CREATE TABLE Business_Info
(
	company_id int NOT NULL AUTO_INCREMENT,
	name varchar(60) NOT NULL,
	address varchar(70) NOT NULL,
	total_acres int NOT NULL,
	phone int,
	email varchar(70) NOT NULL,
	PRIMARY KEY (company_id),
	UNIQUE (company_id)
);


CREATE TABLE bus_owner
(
	owner_id int NOT NULL,
	company_id int NOT NULL,
	PRIMARY KEY (owner_id, company_id),
	UNIQUE (owner_id),
	UNIQUE (company_id)
);


CREATE TABLE daily_record
(
	record_id int NOT NULL AUTO_INCREMENT,
	task double NOT NULL,
	miss varchar(50) NOT NULL,
	actual double NOT NULL,
	gl double NOT NULL,
	drc double NOT NULL,
	scrap double NOT NULL,
	cup_lump int NOT NULL,
	cr_date date NOT NULL,
	division_id int NOT NULL,
	emp_id int NOT NULL,
	manager_id int NOT NULL,
	PRIMARY KEY (record_id),
	UNIQUE (record_id),
	UNIQUE (division_id),
	UNIQUE (emp_id),
	UNIQUE (manager_id)
);


CREATE TABLE division
(
	division_id int NOT NULL AUTO_INCREMENT,
	num_of_tree int NOT NULL,
	acres int NOT NULL,
	PRIMARY KEY (division_id),
	UNIQUE (division_id)
);


CREATE TABLE employee
(
	emp_id int NOT NULL AUTO_INCREMENT,
	family_count int NOT NULL,
	info_id int NOT NULL,
	PRIMARY KEY (emp_id),
	UNIQUE (emp_id),
	UNIQUE (info_id)
);


CREATE TABLE manager
(
	manager_id int NOT NULL AUTO_INCREMENT,
	email varchar(50) NOT NULL,
	info_id int NOT NULL,
	b_info_id int NOT NULL,
	PRIMARY KEY (manager_id),
	UNIQUE (manager_id),
	UNIQUE (info_id),
	UNIQUE (b_info_id)
);


CREATE TABLE Owner
(
	owner_id int NOT NULL AUTO_INCREMENT,
	email varchar(70) NOT NULL,
	info_id int NOT NULL,
	b_info_id int NOT NULL,
	PRIMARY KEY (owner_id),
	UNIQUE (owner_id),
	UNIQUE (info_id),
	UNIQUE (b_info_id)
);


CREATE TABLE password
(
	password varchar(30) NOT NULL,
	user_id varchar(60) NOT NULL
);


CREATE TABLE personal_info
(
	info_id int NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	phone varchar(30) NOT NULL,
	nrc varchar(60) NOT NULL,
	address varchar(100) NOT NULL,
	about varchar(200),
	gender enum('Male','Female') NOT NULL,
	MaritalStates enum('SINGLE','MARRIED') NOT NULL,
	status enum('Active','Activate','Block','Off') NOT NULL,
	start_date date NOT NULL,
	end_date date,
	PRIMARY KEY (info_id),
	UNIQUE (info_id)
);


CREATE TABLE salary_rate
(
	per_tree double,
	per_liter double,
	per_day double,
	start_date date,
	end_date date
);


CREATE TABLE schedule
(
	schedule_id int NOT NULL AUTO_INCREMENT,
	day enum('MON','TUE','WED','THU','FRI','SUN'),
	start_date date NOT NULL,
	end_date date,
	division_id int NOT NULL,
	emp_id int NOT NULL,
	PRIMARY KEY (schedule_id),
	UNIQUE (schedule_id),
	UNIQUE (division_id),
	UNIQUE (emp_id)
);



/* Create Foreign Keys */

ALTER TABLE manager
	ADD FOREIGN KEY (b_info_id)
	REFERENCES bank_info (b_info_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Owner
	ADD FOREIGN KEY (b_info_id)
	REFERENCES bank_info (b_info_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE bus_owner
	ADD FOREIGN KEY (company_id)
	REFERENCES Business_Info (company_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE daily_record
	ADD FOREIGN KEY (division_id)
	REFERENCES division (division_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE schedule
	ADD FOREIGN KEY (division_id)
	REFERENCES division (division_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE daily_record
	ADD FOREIGN KEY (emp_id)
	REFERENCES employee (emp_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE schedule
	ADD FOREIGN KEY (emp_id)
	REFERENCES employee (emp_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE daily_record
	ADD FOREIGN KEY (manager_id)
	REFERENCES manager (manager_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE bus_owner
	ADD FOREIGN KEY (owner_id)
	REFERENCES Owner (owner_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE employee
	ADD FOREIGN KEY (info_id)
	REFERENCES personal_info (info_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE manager
	ADD FOREIGN KEY (info_id)
	REFERENCES personal_info (info_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Owner
	ADD FOREIGN KEY (info_id)
	REFERENCES personal_info (info_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



