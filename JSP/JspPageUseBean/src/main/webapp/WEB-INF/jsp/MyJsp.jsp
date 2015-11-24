<%--
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
--%>
<%@ page import="com.adarsh.bean.Employee"
         language="java"
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         session="true" %>

<jsp:useBean id="object" type="com.adarsh.bean.Person"
             class="com.adarsh.bean.Employee" scope="application">
    <jsp:setProperty name="object" property="personName" param="personName"/>
    <jsp:setProperty name="object" property="empNumber" param="empNumber"/>
    <%= ((Employee) object).getEmpNumber() + " " + object.getPersonName() %>
</jsp:useBean>


 