dROP TABLE OFICINES;
DROP TABLE EMPLEATS;
CREATE TABLE oficines (
oficina INTEGER PRIMARY KEY,
ciutat TEXT,
superficie 	INTEGER,
vendes DOUBLE
);
CREATE TABLE empleats (
numemp INTEGER PRIMARY KEy,
nom TEXT,
edat INTEGER,
oficina INTEGER FOREIGN KEY REFERENCES oficines(oficina),
ocupacio TEXT,
CONTRACTE TEXT  
);

INSERT INTO OFICINES VALUES(1,'Elda',700,5000.00);
INSERT INTO OFICINES VALUES(2,'Petrer',600,3000.00);
INSERT INTO OFICINES VALUES(3,'Sax',400,2000.00);
INSERT INTO OFICINES VALUES(4,'Monovar',300,1000.00);

INSERT INTO EMPLEATS VALUES(1,'Paco',60,1,'Developer','2000-01-12');
INSERT INTO EMPLEATS VALUES(2,'Roberto',58,2,'Supervisor','2012-04-18');
INSERT INTO EMPLEATS VALUES(3,'Andres',28,3,'Mantenimiento','2022-07-22');
INSERT INTO EMPLEATS VALUES(4,'Maria',38,4,'Consultor','2020-01-14');

