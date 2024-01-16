IF OBJECT_ID ('dbo.scores') IS NULL
CREATE TABLE dbo.scores
	(
	id          INT IDENTITY NOT NULL,
	subject VARCHAR (10),
	score     INT,
	type  VARCHAR (10),
	stuNo  VARCHAR (20),
	create_by  VARCHAR (50),
	update_by  VARCHAR (50),
	create_time  DATETIME,
	update_time  DATETIME,
	CONSTRAINT pk_score_tab PRIMARY KEY (id)
	);

IF OBJECT_ID ('students') IS  NULL
CREATE TABLE dbo.students
	(
	id          INT IDENTITY NOT NULL,
	stuNo  VARCHAR (20),
	name   VARCHAR (50),
	classes     VARCHAR (10),
	dob VARCHAR (20),
	phone_number  VARCHAR (20),
	create_by  VARCHAR (50),
    update_by  VARCHAR (50),
    create_time  DATETIME,
    update_time  DATETIME,
	CONSTRAINT pk_students_tab PRIMARY KEY (id)
	);
