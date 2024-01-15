IF OBJECT_ID ('scores') IS NULL
CREATE TABLE dbo.score(
id INT IDENTITY NOT NULL,
subject VARCHAR (10),
score INT,
tpye VARCHAR (10),
stuNo VARCHAR（20),
create_by VARCHAR (50),
update_by VARCHAR (50),
create_time DATETIME,
update_time DATETIME
CONSTRAINT pk_score_tab PRIMARY KEY (id)
)


IF OBJECT_ID ('student') IS NULL
CREATE TABLE dbo.score(
id INT IDENTITY NOT NULL,
stuNo VARCHAR (20),
name VARCHAR(50),
classes VARCHAR (10),
dob VARCHAR (26),
phone_number VARCHAR（20),
create_by VARCHAR (50),
update_by VARCHAR (50),
create_time DATETIME,
update_time DATETIME,
CONSTRAINT pk_student_tab PRIMARY KEY (id)
)