CREATE TABLE lead
(
 leadid INT NOT NULL,
 firstname varchar(100) NOT NULL ,
 middlename varchar(100) NOT NULL ,
 lastname varchar(100) NOT NULL ,
 mobilenumber bigint NOT NULL,
 gender varchar(6) NOT NULL ,
 dob varchar(10) NOT NULL,
 email  varchar(100) DEFAULT NULL,
 PRIMARY KEY (leadid)
);