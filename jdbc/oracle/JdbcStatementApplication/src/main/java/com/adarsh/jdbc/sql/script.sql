

CREATE TABLE  "EMPLOYEE"
   (	"EMPNO" NUMBER(3,0) NOT NULL ENABLE,
    	"EMPNAME" VARCHAR2(100),
	    "EMPEMAIL" VARCHAR2(100),
	    CONSTRAINT "EMPLOYEE_PK" PRIMARY KEY ("EMPNO") ENABLE
   );


INSERT INTO EMPLOYEE(EMPNO,EMPNAME,EMPEMAIL) VALUES(1,'ADARSH KUMAR','adarsh@kumar.com');
INSERT INTO EMPLOYEE(EMPNO,EMPNAME,EMPEMAIL) VALUES(2,'RADHA SINGH','radha@singh.com');
INSERT INTO EMPLOYEE(EMPNO,EMPNAME,EMPEMAIL) VALUES(3,'AMIT KUMAR','amit@kumar.com');



SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE WHERE EMPNO = 1;

/* DELETE FROM EMPLOYEE WHERE EMPNO=2; */



UPDATE EMPLOYEE SET EMPNAME='AMIT KUMAR SINGH' ,EMPEMAIL='amit@kumar.singh' WHERE EMPNO=2;