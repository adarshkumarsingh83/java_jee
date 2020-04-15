<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         isELIgnored="false" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<br/>Context Scope ${applicationScope.data }
<br/>Session Scope ${sessionScope.Session }
<br/>Request Scope ${requestScope.userName }
<br/>Context init Scope ${initParam.ServletContext }

<br/>Param ${param.userName}
<br/>Header :-
<c:forEach var="item" items="${header}">
    <br/>${item.key} -->  ${item.value} </br>
</c:forEach>

<br/>Cookies :-
<c:forEach var="item" items="${cookie}">
    <br/>${item.key} -->  ${item.value} </br>
</c:forEach>

</body>
</html>