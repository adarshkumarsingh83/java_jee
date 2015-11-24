
DROP DATABASE IF EXISTS 'JDBC';
CREATE DATABASE 'JDBC';

DROP TABLE IF EXISTS `JDBC`.`employee`;
CREATE TABLE  `JDBC`.`employee` (
  `EmpNo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EmpName` varchar(45) NOT NULL,
  `EmpEmail` varchar(30) NOT NULL,
  PRIMARY KEY (`EmpNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--------------------------------------------------------------------------------------------------------------------------------------------------
CALL getEmployee(1);
--------------------------------------------------------------------------------------------------------------------------------------------------
DELIMITER $$
DROP PROCEDURE IF EXISTS getEmployee$$
CREATE PROCEDURE getEmployee(IN EMP_NO INT(10))
BEGIN
   SELECT EMPNO,EMPNAME,EMPEMAIL FROM EMPLOYEE WHERE EMPNO = EMP_NO;
END $$
DELIMITER ;
--------------------------------------------------------------------------------------------------------------------------------------------------
CALL getAllEmployee();
--------------------------------------------------------------------------------------------------------------------------------------------------
DELIMITER $$
DROP PROCEDURE IF EXISTS getAllEmployee$$
CREATE PROCEDURE getAllEmployee()
BEGIN
   SELECT EMPNO,EMPNAME,EMPEMAIL FROM EMPLOYEE ;
END $$
DELIMITER ;
--------------------------------------------------------------------------------------------------------------------------------------------------
CALL insertEmployee(5,'MONU','monu@singh.com');
--------------------------------------------------------------------------------------------------------------------------------------------------
DELIMITER $$
DROP PROCEDURE IF EXISTS insertEmployee$$
CREATE PROCEDURE insertEmployee(IN EMP_NO INT(10),IN EMP_NAME VARCHAR(45),IN EMP_EMAIL VARCHAR(30))
LANGUAGE SQL
READS SQL DATA
DETERMINISTIC
BEGIN

   DECLARE RESULT_INSERT VARCHAR(100) DEFAULT NULL;
   INSERT INTO EMPLOYEE(EMPNO,EMPNAME,EMPEMAIL)VALUES(EMP_NO,EMP_NAME,EMP_EMAIL);

   IF (SELECT ROW_COUNT()) != 0 THEN
    SET RESULT_INSERT= (CONCAT('NEW RECORD CREATED SUCCESSFULLY ',(SELECT ROW_COUNT())));
   ELSE
    SET RESULT_INSERT= (CONCAT('NEW RECORD NOT CREATED SUCCESSFULLY ',(SELECT ROW_COUNT())));
   END IF;

   SELECT CONCAT(RESULT_INSERT,' ');

END $$
DELIMITER ;
--------------------------------------------------------------------------------------------------------------------------------------------------
CALL updateEmployee(8,'monu singh','monu@singh');
--------------------------------------------------------------------------------------------------------------------------------------------------
DELIMITER $$
DROP PROCEDURE IF EXISTS updateEmployee$$
CREATE PROCEDURE updateEmployee(IN EMP_NO INT(10),IN EMP_NAME VARCHAR(45),IN EMP_EMAIL VARCHAR(30))
LANGUAGE SQL
READS SQL DATA
DETERMINISTIC
BEGIN

    DECLARE RESULT_UPDATE VARCHAR(100) DEFAULT NULL;
    UPDATE EMPLOYEE SET EMPNAME=EMP_NAME, EMPEMAIL=EMP_EMAIL WHERE EMPNO=EMP_NO;

    IF (SELECT ROW_COUNT()) != 0 THEN
     SET RESULT_UPDATE= (CONCAT('RECORD UPDATED SUCCESSFULLY ',(SELECT ROW_COUNT())));
    ELSE
     SET RESULT_UPDATE= (CONCAT('RECORD NOT UPDATED SUCCESSFULLY ',(SELECT ROW_COUNT())));
    END IF;

    SELECT CONCAT(RESULT_UPDATE,' ');
END $$
DELIMITER ;
--------------------------------------------------------------------------------------------------------------------------------------------------
CALL deleteEmployee(8);
--------------------------------------------------------------------------------------------------------------------------------------------------
DELIMITER $$
DROP PROCEDURE IF EXISTS deleteEmployee$$
CREATE PROCEDURE deleteEmployee(IN EMP_NO INT(10))
LANGUAGE SQL
READS SQL DATA
DETERMINISTIC
BEGIN

   DECLARE RESULT_DELETE VARCHAR(100) DEFAULT NULL;
   DELETE FROM EMPLOYEE WHERE EMPNO = EMP_NO;

   IF (SELECT ROW_COUNT()) != 0 THEN
    SET RESULT_DELETE= (CONCAT('RECORD DELETED SUCCESSFULLY ',(SELECT ROW_COUNT())));
   ELSE
    SET RESULT_DELETE= (CONCAT('RECORD NOT DELETED SUCCESSFULLY ',(SELECT ROW_COUNT())));
   END IF;

   SELECT CONCAT(RESULT_DELETE,' ');

END $$
DELIMITER ;
--------------------------------------------------------------------------------------------------------------------------------------------------
