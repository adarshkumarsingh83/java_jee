<%--
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page !!!</title>
</head>
<body>
<br/><br/><br/><br/>
<br/><br/><br/><br/>


<a href="<c:url value='admin/adminHome.do'/>">ADMIN HOME PAGE</a> <br/>
<a href="<c:url value='user/userHome.do'/>">USER HOME PAGE </a> <br/>
<a href="<c:url value='common/visitor.do'/>">DEFAULT PAGE </a>
<br/><br/>
</body>
</html>
