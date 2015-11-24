
CREATE TABLE  Employee (
  `EmpNo` integer(10),
  `EmpName` varchar(45) NOT NULL,
  `EmpEmail` varchar(30) NOT NULL,
  PRIMARY KEY (`EmpNo`)
) ;
--------------------------------------------------------------------------------------------------------------------------------------------------
 SET SERVEROUTPUT ON;
 DECLARE
   EMP_INSERT_MSG VARCHAR(50);
   EMP_INSERT_COUNT NUMBER(10) DEFAULT 0;
 BEGIN
   INSERT INTO EMPLOYEE(EMPNO,EMPNAME,EMPEMAIL)VALUES(&EMPNO,'&EMPNAME','&EMPEMAIL');
   EMP_INSERT_COUNT := SQL%ROWCOUNT;
    IF EMP_INSERT_COUNT >0 THEN
	     EMP_INSERT_MSG:='EMPLOYEE INSERT SUCCESSFUL '||EMP_INSERT_COUNT;
	   ELSE
	     EMP_INSERT_MSG:='EMPLOYEE NOT INSERT '||EMP_INSERT_COUNT;
	  END IF;
	COMMIT;
	DBMS_OUTPUT.PUT_LINE(EMP_INSERT_MSG);
 END;
 /
--------------------------------------------------------------------------------------------------------------------------------------------------
 SET SERVEROUTPUT ON;
 DECLARE
   V_EMP_DATA_CURSOR SYS_REFCURSOR;
   V_EMPNO EMPLOYEE.EMPNO%TYPE;
   V_EMPNAME EMPLOYEE.EMPNAME%TYPE;
   V_EMPEMAIL EMPLOYEE.EMPEMAIL%TYPE;
   V_SELECT_ERROR_MSG VARCHAR(50);
 BEGIN
     V_EMP_DATA_CURSOR :=getEmpFunction(&EMPNO,V_SELECT_ERROR_MSG);
          IF V_SELECT_ERROR_MSG IS NULL THEN
                   LOOP
                       FETCH V_EMP_DATA_CURSOR INTO V_EMPNO,V_EMPNAME,V_EMPEMAIL;
                       EXIT WHEN V_EMP_DATA_CURSOR%NOTFOUND;
                       DBMS_OUTPUT.PUT_LINE('EMPLOYEE DATA '||V_EMPNO||','||V_EMPNAME||','||V_EMPEMAIL);
                   END LOOP;
               CLOSE V_EMP_DATA_CURSOR;
	       ELSE
           DBMS_OUTPUT.PUT_LINE(V_SELECT_ERROR_MSG);
      END IF;
 END;
 /
 --------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION getEmpFunction(V_EMP_NO IN EMPLOYEE.EMPNO%TYPE ,V_SELECT_ERROR_MSG OUT VARCHAR) RETURN SYS_REFCURSOR
IS
   V_EMP_DATA_CURSOR SYS_REFCURSOR;
  BEGIN
	OPEN V_EMP_DATA_CURSOR
		FOR SELECT EMP.EMPNO,EMP.EMPNAME,EMP.EMPEMAIL FROM EMPLOYEE EMP WHERE EMP.EMPNO = V_EMP_NO; 	   	
        RETURN(V_EMP_DATA_CURSOR);
    CLOSE V_EMP_DATA_CURSOR;
  EXCEPTION
        WHEN NO_DATA_FOUND THEN
          BEGIN
            V_SELECT_ERROR_MSG :='NO EMPLOYEE FOUND';
          END;
        WHEN TOO_MANY_ROWS THEN
          BEGIN
            RAISE_APPLICATION_ERROR(-20612,'MORE THEN ONE EMPLOYEE FOUND FOR EMPNO '||V_EMP_NO);
          END;
        WHEN OTHERS THEN
		    RAISE_APPLICATION_ERROR(-20001, V_EMP_NO || ':$:' || SQLERRM, TRUE) ;	
END getEmpFunction;
/
*****************************************************************************************
DROP FUNCTION getEmpFunction;

CREATE OR REPLACE FUNCTION getEmpFunction(V_EMP_NO IN EMPLOYEE.EMPNO%TYPE ,V_SELECT_ERROR_MSG OUT VARCHAR) RETURN SYS_REFCURSOR
IS
   V_COUNT  NUMBER;
   V_EMP_DATA_CURSOR SYS_REFCURSOR;
  BEGIN

    SELECT COUNT(*) INTO V_COUNT FROM EMPLOYEE WHERE EMPNO = V_EMP_NO;

    IF V_COUNT != 0 THEN
			OPEN V_EMP_DATA_CURSOR
			FOR SELECT EMP.EMPNO,EMP.EMPNAME,EMP.EMPEMAIL FROM EMPLOYEE EMP WHERE EMP.EMPNO = V_EMP_NO;
	ELSE
			  V_SELECT_ERROR_MSG :='NO EMPLOYEE FOUND FOR EMPNO '||V_EMP_NO;
    END IF;

    RETURN(V_EMP_DATA_CURSOR);

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
			BEGIN
			 V_SELECT_ERROR_MSG:='NO EMPLOYEE FOUND';
            END;
        WHEN TOO_MANY_ROWS THEN
          BEGIN
            RAISE_APPLICATION_ERROR(-20612,'MORE THEN ONE EMPLOYEE FOUND FOR EMPNO '||V_EMP_NO);
          END;
        WHEN OTHERS THEN
		   RAISE_APPLICATION_ERROR(-20001, V_EMP_NO || ':$:' || SQLERRM, TRUE) ;
END getEmpFunction;
--------------------------------------------------------------------------------------------------------------------------------------------------
 SET SERVEROUTPUT ON;
 DECLARE
   V_EMP_ALL_DATA_CURSOR SYS_REFCURSOR;
   V_EMPNO EMPLOYEE.EMPNO%TYPE;
   V_EMPNAME EMPLOYEE.EMPNAME%TYPE;
   V_EMPEMAIL EMPLOYEE.EMPEMAIL%TYPE;
   V_SELECT_ERROR_MSG VARCHAR(50);
 BEGIN
     V_EMP_ALL_DATA_CURSOR :=getAllEmpFunction(V_SELECT_ERROR_MSG);
     IF V_SELECT_ERROR_MSG IS NULL THEN
         LOOP
             FETCH V_EMP_ALL_DATA_CURSOR INTO V_EMPNO,V_EMPNAME,V_EMPEMAIL;
             EXIT WHEN V_EMP_ALL_DATA_CURSOR%NOTFOUND;
             DBMS_OUTPUT.PUT_LINE('EMPLOYEE DATA '||V_EMPNO||','||V_EMPNAME||','||V_EMPEMAIL);
         END LOOP;
         CLOSE V_EMP_ALL_DATA_CURSOR;
      ELSE
           DBMS_OUTPUT.PUT_LINE(V_SELECT_ERROR_MSG);
      END IF;
 END;
 /
--------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION getAllEmpFunction(V_SELECT_ERROR_MSG OUT VARCHAR) RETURN SYS_REFCURSOR
IS
   V_COUNT  NUMBER;
   V_EMP_ALL_DATA_CURSOR SYS_REFCURSOR;
BEGIN
       SELECT COUNT(*) INTO V_COUNT FROM EMPLOYEE ;
		   IF V_COUNT != 0 THEN
				OPEN V_EMP_ALL_DATA_CURSOR
					FOR SELECT EMP.EMPNO,EMP.EMPNAME,EMP.EMPEMAIL FROM EMPLOYEE EMP;
		   ELSE
					V_SELECT_ERROR_MSG :='NO EMPLOYEE FOUND';
		   END IF;

       RETURN(V_EMP_ALL_DATA_CURSOR);
    CLOSE V_EMP_ALL_DATA_CURSOR;
    EXCEPTION
			  WHEN NO_DATA_FOUND THEN
				  BEGIN
					V_SELECT_ERROR_MSG :='NO EMPLOYEE FOUND';
				  END;
			  WHEN OTHERS THEN
				  RAISE_APPLICATION_ERROR (-20001, 'EXCEPTION GENERATED :$:' || SQLERRM, TRUE) ;
END getAllEmpFunction;
/
--------------------------------------------------------------------------------------------------------------------------------------------------
SET SERVEROUTPUT ON;
DECLARE
   DATA VARCHAR(50) ;
BEGIN
DATA :=insertEmpFunction(&EMPNO,'&EMPNAME','&EMPEMAIL');
DBMS_OUTPUT.PUT_LINE(DATA);
END;
/
--------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION insertEmpFunction(
  V_EMPNO IN EMPLOYEE.EMPNO%TYPE
 ,V_EMPNAME IN EMPLOYEE.EMPNAME%TYPE
 ,V_EMPEMAIL IN EMPLOYEE.EMPEMAIL%TYPE)RETURN VARCHAR
IS
  V_EMP_INSERT_MSG VARCHAR(50);
  V_EMP_INSERT_COUNT NUMBER(10) DEFAULT 0;
BEGIN
     IF V_EMPNO IS NOT  NULL THEN

	     INSERT INTO EMPLOYEE (EMPNO,EMPNAME,EMPEMAIL)
	     VALUES(V_EMPNO,NVL(V_EMPNAME,'NOT AVAILABLE'),NVL(V_EMPEMAIL,'NOT AVAILABLE'));
	             V_EMP_INSERT_COUNT := SQL%ROWCOUNT;
	             IF V_EMP_INSERT_COUNT >0 THEN
	                 V_EMP_INSERT_MSG:='EMPLOYEE INSERT SUCCESSFUL '||V_EMP_INSERT_COUNT;
	             ELSE
	                 V_EMP_INSERT_MSG:='EMPLOYEE NOT INSERT '||V_EMP_INSERT_COUNT;
	             END IF;
	             COMMIT;
	 ELSE
	      V_EMP_INSERT_MSG:='IMPROPER ARGUMENTS SUPPLIED TO FUNCTION';
	 END IF;
     RETURN (V_EMP_INSERT_MSG);
     EXCEPTION
        WHEN OTHERS THEN RAISE_APPLICATION_ERROR (-20001, V_EMPNO ||':$:'||V_EMPNAME||':$:'||V_EMPEMAIL|| ':$:' ||SQLERRM, TRUE) ;
END insertEmpFunction;
/
--------------------------------------------------------------------------------------------------------------------------------------------------
SET SERVEROUTPUT ON;
DECLARE
   DATA VARCHAR(50) ;
BEGIN
DATA :=updateEmpFunction(&EMPNO,'&EMPNAME','&EMPEMAIL');
DBMS_OUTPUT.PUT_LINE(DATA);
END;
/
--------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION updateEmpFunction(
  V_EMPNO IN EMPLOYEE.EMPNO%TYPE
 ,V_EMPNAME IN EMPLOYEE.EMPNAME%TYPE
 ,V_EMPEMAIL IN EMPLOYEE.EMPEMAIL%TYPE)RETURN VARCHAR
IS
    V_EMP__UPDATE_MSG VARCHAR(50);
    V_EMP_UPDATE_COUNT NUMBER(10) DEFAULT 0;
BEGIN
      IF V_EMPNO IS NOT NULL THEN
	      UPDATE EMPLOYEE SET EMPNAME=V_EMPNAME, EMPEMAIL=V_EMPEMAIL WHERE EMPNO=NVL(V_EMPNO,0);
	            V_EMP_UPDATE_COUNT := SQL%ROWCOUNT;
	            IF V_EMP_UPDATE_COUNT >0 THEN
	               V_EMP__UPDATE_MSG:='EMPLOYEE UPDATED SUCCESSFUL '||V_EMP_UPDATE_COUNT;
	            ELSE
	               V_EMP__UPDATE_MSG:='EMPLOYEE NOT UPDATED '||V_EMP_UPDATE_COUNT;
	            END IF;
	            COMMIT;
	  ELSE
	      V_EMP__UPDATE_MSG:='IMPROPER ARGUMENTS SUPPLIED TO FUNCTION';
	  END IF;
	RETURN (V_EMP__UPDATE_MSG);
	EXCEPTION 
	      WHEN OTHERS THEN RAISE_APPLICATION_ERROR (-20001, V_EMPNO    || ':$:' || SQLERRM, TRUE);
COMMIT;
END updateEmpFunction;
/
--------------------------------------------------------------------------------------------------------------------------------------------------
SET SERVEROUTPUT ON;
DECLARE
   DATA VARCHAR(50) ;
BEGIN
DATA := deleteEmpFunction(&EMPNO);
DBMS_OUTPUT.PUT_LINE(DATA);
END;
/
--------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION deleteEmpFunction(V_EMP_NO IN EMPLOYEE.EMPNO%TYPE)RETURN VARCHAR
   IS
   V_EMP_DEL_MSG VARCHAR(50);
   V_EMP_DEL_COUNT NUMBER(10) DEFAULT 0;
   BEGIN    
      IF V_EMP_NO IS NOT NULL THEN

          DELETE FROM EMPLOYEE WHERE EMPNO = NVL(V_EMP_NO,0);
	          V_EMP_DEL_COUNT := SQL%ROWCOUNT;

	          IF V_EMP_DEL_COUNT >0 THEN
	             V_EMP_DEL_MSG:='EMPLOYEE DELETED SUCCESSFUL '||V_EMP_DEL_COUNT;
	          ELSE
	             V_EMP_DEL_MSG:='EMPLOYEE NOT DELETED '||V_EMP_DEL_COUNT;
	          END IF;
	          COMMIT;
	  ELSE
	      V_EMP_DEL_MSG:='IMPROPER ARGUMENTS SUPPLIED TO FUNCTION';
	  END IF;
	  RETURN (V_EMP_DEL_MSG);
   EXCEPTION
           WHEN OTHERS THEN RAISE_APPLICATION_ERROR(-20001, V_EMP_NO || ':$:' || SQLERRM, TRUE);
 END deleteEmpFunction;
/
--------------------------------------------------------------------------------------------------------------------------------------------------
