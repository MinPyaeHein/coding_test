
/* Drop Tables */
DROP TABLE IF EXISTS staff_page;
DROP TABLE IF EXISTS staff_department;
DROP TABLE IF EXISTS loan_record;
DROP TABLE IF EXISTS Staff;
DROP TABLE IF EXISTS staff_group;
DROP TABLE IF EXISTS Department;
DROP TABLE IF EXISTS page;

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
insert into department (dep_id,dep_name,dep_desc,dep_code) values(1,'Dept1','dep1','111');
insert into department (dep_id,dep_name,dep_desc,dep_code) values(2,'Dept2','dep2','111');
insert into department (dep_id,dep_name,dep_desc,dep_code) values(3,'Dept3','dep3','112');
insert into Page (page_id,page_name,page_code,page_desc) values(1,'Staff Management','staff_manage','desc');
insert into Page (page_id,page_name,page_code,page_desc) values(2,'Department Management','dept_manage','desc');
insert into Page (page_id,page_name,page_code,page_desc) values(3,'Loan Management','loan_manage','desc');
insert into Page (page_id,page_name,page_code,page_desc) values(4,'Page Management','page_manage','desc');
insert into Page (page_id,page_name,page_code,page_desc) values(5,'Group Management','group_manage','desc');
insert into staff_group (group_id,group_name,group_code) values(1,'Super_Admin','111');
insert into staff_group (group_id,group_name,group_code) values(2,'Sub_Admin','112');
insert into staff_group (group_id,group_name,group_code) values(3,'mini_Admin','113');
INSERT INTO staff (staff_id, name, email,password,account_status,created_at,updated_at,group_id)
VALUES (100,'bluecore1','devt@bluecore.com.mm','$2a$10$M3Lencp9jXBc7T217w5sG.zxi/GYAkQbvLFBn2TLfmBk5Nwc3CsdC','Active',null,null,1);
insert into staff_page(staff_id,page_id) values(100,1);
insert into staff_page(staff_id,page_id) values(100,2);
insert into staff_page(staff_id,page_id) values(100,3);
insert into staff_page(staff_id,page_id) values(100,4);
insert into staff_page(staff_id,page_id) values(100,5);

insert into staff_department(staff_id,dep_id) values(100,1);
insert into staff_department(staff_id,dep_id) values(100,2);
