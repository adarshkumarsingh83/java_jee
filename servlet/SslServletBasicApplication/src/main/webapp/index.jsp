<%--
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<form name="loginForm" action="loginServlet.do" method="post">
    <table>
        <tr>
            <td>Enter the User Name :</td>
            <td><input type="text" name="userName"/></td>
        </tr>

        <tr>
            <td>Enter the User Pwd :</td>
            <td><input type="password" name="userPwd"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="login"></td>
        </tr>
    </table>
</form>
</body>
</html>