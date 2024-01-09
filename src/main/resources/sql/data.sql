IF OBJECT_ID ('score') IS  NULL
CREATE TABLE dbo.score
	(
	id          INT IDENTITY NOT NULL,
	stuNo  VARCHAR (255),
	name   VARCHAR (255),
	score     VARCHAR (255),
	classes VARCHAR (255),
	tpye  VARCHAR (255)
	CONSTRAINT pk_score_tab PRIMARY KEY (id)
	);