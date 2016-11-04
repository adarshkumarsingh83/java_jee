
DROP DATABASE IF EXISTS `JDBC`;
CREATE DATABASE `JDBC`;

DROP TABLE IF EXISTS `JDBC`.`employee`;
CREATE TABLE  `JDBC`.`employee` (
  `EmpNo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EmpName` varchar(45) NOT NULL,
  `EmpEmail` varchar(30) NOT NULL,
  PRIMARY KEY (`EmpNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


SELECT * FROM JDBC.EMPLOYEE;

SELECT * FROM JDBC.EMPLOYEE WHERE EMPNO = 1;

DELETE FROM JDBC.EMPLOYEE WHERE EMPNO=2;

INSERT INTO JDBC.EMPLOYEE(EMPNO,EMPNAME,EMPEMAIL) VALUES(1,'ADARSH KUMAR','adarsh@kumar.com');
INSERT INTO JDBC.EMPLOYEE(EMPNO,EMPNAME,EMPEMAIL) VALUES(2,'AMIT KUMAR','amit@kumar.com');

UPDATE JDBC.EMPLOYEE SET EMPNAME='AMIT KUMAR SINGH' ,EMPEMAIL='amit@kumar.singh' WHERE EMPNO=2;