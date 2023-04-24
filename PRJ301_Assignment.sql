USE [master]
GO

IF EXISTS (SELECT * FROM sys.databases WHERE name = 'PRJ301_Assignment')
	DROP DATABASE PRJ301_Assignment
GO

CREATE DATABASE PRJ301_Assignment
GO

use PRJ301_Assignment
GO
Create Table Student (id varchar(8),[name] varchar(30), dob Date, gender bit, email varchar(30), [password] varchar(30), PRIMARY KEY (id))
GO
Create Table SubjectsStatus (id varchar(8),[MAE101] varchar(30),[PRF192] varchar(30),[MAD101] varchar(30),[PRO192] varchar(30),[JPD113] varchar(30),[LAB211] varchar(30),[MAS291] varchar(30),[JPD123] varchar(30),[PRJ301] varchar(30),[JPD316] varchar(30),[PRM392] varchar(30), PRIMARY KEY (id), FOREIGN KEY (id) REFERENCES Student(id))
GO
Create Table Class (id varchar(10),[subject] varchar(10), PRIMARY KEY (id))
GO
Create Table Class_Student (class_id varchar(10),student_id varchar(8), PRIMARY KEY (class_id,student_id), FOREIGN KEY (class_id) REFERENCES Class(id), FOREIGN KEY (student_id) REFERENCES Student(id))
GO
Create Table [Admin] (id int,[name] varchar(30), dob Date, gender bit, email varchar(30), [password] varchar(30), PRIMARY KEY (id))
GO
INSERT INTO Student (id,[name],dob,gender,email,[password]) VALUES ('HE160619','Tran Duc Thang','2002-11-5', 1, 'thangtdhe160619@fpt.edu.vn', 'abc123')
INSERT INTO Student (id,[name],dob,gender,email,[password]) VALUES ('HE140465','Nguyen Duc Duy','2000-1-1', 1, 'duyndhe140465@fpt.edu.vn', 'abc123')
INSERT INTO Student (id,[name],dob,gender,email,[password]) VALUES ('HE141048','Le Duy Tu','2000-2-2', 1, 'tuldhe141048@fpt.edu.vn', 'abc123')
INSERT INTO Student (id,[name],dob,gender,email,[password]) VALUES ('HE141363','Nguyen Dang Kien','2000-3-3', 1, 'kienndhe141363@fpt.edu.vn', 'abc123')
INSERT INTO Student (id,[name],dob,gender,email,[password]) VALUES ('HE150537','Nguyen Dang Quang','2001-4-4', 1, 'quangndhe150537@fpt.edu.vn', 'abc123')
INSERT INTO Student (id,[name],dob,gender,email,[password]) VALUES ('HE150977','Vu Viet Chuc','2001-5-5', 1, 'chucvvhe150977@fpt.edu.vn', 'abc123')
INSERT INTO Student (id,[name],dob,gender,email,[password]) VALUES ('HE151356','Nguyen Huy Tung','2001-6-6', 1, 'tungnhhe151356@fpt.edu.vn', 'abc123')
INSERT INTO Student (id,[name],dob,gender,email,[password]) VALUES ('HE153201','Dinh Ngoc Manh','2001-7-7', 1, 'manhdnhe153201@fpt.edu.vn', 'abc123')
INSERT INTO Student (id,[name],dob,gender,email,[password]) VALUES ('HE153650','Le Anh Luong','2001-8-8', 1, 'luonglahe153650@fpt.edu.vn', 'abc123')
INSERT INTO Student (id,[name],dob,gender,email,[password]) VALUES ('HE176697','Nguyen Thi Cam Tu','2003-9-9', 0, 'tuntche176697@fpt.edu.vn', 'abc123')

INSERT INTO SubjectsStatus (id,MAE101,PRF192,MAD101,PRO192,JPD113,LAB211,MAS291,JPD123,PRJ301,JPD316,PRM392) VALUES('HE160619','passed','passed','passed','passed','passed','passed','passed','passed','not passed','not yet','not yet')
INSERT INTO SubjectsStatus (id,MAE101,PRF192,MAD101,PRO192,JPD113,LAB211,MAS291,JPD123,PRJ301,JPD316,PRM392) VALUES('HE140465','passed','passed','passed','passed','passed','not passed','passed','passed','not passed','not yet','not yet')
INSERT INTO SubjectsStatus (id,MAE101,PRF192,MAD101,PRO192,JPD113,LAB211,MAS291,JPD123,PRJ301,JPD316,PRM392) VALUES('HE141048','passed','passed','passed','passed','passed','passed','not passed','passed','not passed','not yet','not yet')
INSERT INTO SubjectsStatus (id,MAE101,PRF192,MAD101,PRO192,JPD113,LAB211,MAS291,JPD123,PRJ301,JPD316,PRM392) VALUES('HE141363','passed','passed','passed','passed','passed','passed','passed','not passed','not passed','not yet','not yet')
INSERT INTO SubjectsStatus (id,MAE101,PRF192,MAD101,PRO192,JPD113,LAB211,MAS291,JPD123,PRJ301,JPD316,PRM392) VALUES('HE150537','passed','passed','passed','passed','passed','passed','passed','passed','not passed','not yet','not yet')
INSERT INTO SubjectsStatus (id,MAE101,PRF192,MAD101,PRO192,JPD113,LAB211,MAS291,JPD123,PRJ301,JPD316,PRM392) VALUES('HE151356','passed','passed','not passed','passed','passed','passed','passed','passed','not passed','not yet','not yet')
INSERT INTO SubjectsStatus (id,MAE101,PRF192,MAD101,PRO192,JPD113,LAB211,MAS291,JPD123,PRJ301,JPD316,PRM392) VALUES('HE153201','passed','passed','passed','not passed','not passed','passed','passed','passed','not passed','not yet','not yet')
INSERT INTO SubjectsStatus (id,MAE101,PRF192,MAD101,PRO192,JPD113,LAB211,MAS291,JPD123,PRJ301,JPD316,PRM392) VALUES('HE153650','passed','passed','passed','passed','passed','passed','not passed','passed','not passed','not yet','not yet')
INSERT INTO SubjectsStatus (id,MAE101,PRF192,MAD101,PRO192,JPD113,LAB211,MAS291,JPD123,PRJ301,JPD316,PRM392) VALUES('HE176697','passed','not passed','passed','passed','passed','passed','passed','passed','not passed','not yet','not yet')
INSERT INTO SubjectsStatus (id,MAE101,PRF192,MAD101,PRO192,JPD113,LAB211,MAS291,JPD123,PRJ301,JPD316,PRM392) VALUES('HE150977','passed','passed','passed','passed','passed','passed','not passed','passed','not passed','not yet','not yet')

INSERT INTO Class(id,[subject]) VALUES('PRJ301_01','PRJ301')

INSERT INTO Class_Student(class_id,student_id) VALUES('PRJ301_01','HE140465')
INSERT INTO Class_Student(class_id,student_id) VALUES('PRJ301_01','HE176697')
INSERT INTO Class_Student(class_id,student_id) VALUES('PRJ301_01','HE153650')
INSERT INTO Class_Student(class_id,student_id) VALUES('PRJ301_01','HE141048')
INSERT INTO Class_Student(class_id,student_id) VALUES('PRJ301_01','HE150977')

INSERT INTO Admin (id,[name],dob,gender,email,[password]) VALUES (1,'Tran Duc Thang','2002-11-5', 1, 'thangtdhe160619@fpt.edu.vn', 'administrator96')
GO
select * from subjectsstatus
GO
