<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script type="text/javascript">
        function verifyEmpty() {
            var userName = document.getElementById("userName").value.trim();
            var userPwd = document.getElementById("userPwd").value.trim();
            if (userName == '' || userName.length == 0) {
                document.getElementById("userName").focus();
                document.getElementById("error").innerHTML = "EMPTY USER NAME";
                return false;
            } else if (userPwd == '' || userPwd.length == 0) {
                document.getElementById("userPwd").focus();
                document.getElementById("error").innerHTML = "EMPTY USER PWD";
                return false;
            } else {
                return true;
            }
        }
    </script>

    <style type="text/css">

        #loginField {
            width: 350px;
            margin: 50px auto;
        }

        #login input[type=text], #login input[type=password] {
            width: 191px;
        }

        #login input[type=button] {
            height: 27px;
            width: 194px;
            margin: 2px 0;
        }

        #loginError p {
            background: #f00;
            margin: 3px;
            color: #fff;
            padding: 5px;
        }
    </style>
</head>
<body>
<br/>
<br/>
<br/>
<br/>
<br/>

<form action="home.do" method="post" onSubmit="return verifyEmpty();">
    <div id="loginError">
        <c:if test="${not empty error}">
            <fieldset style="margin:5px 5px 5px 5px;  width: 320px; ">
                <div id="error" style="background-color: rgba(247, 16, 16, 0.777344);">
                    <legend><strong style="color:black;">Error Window</strong></legend>
                    <c:out value="${error}"/>
                </div>
            </fieldset>
        </c:if>
    </div>
    <div id="loginField">
        <fieldset style="margin:5px 5px 5px 5px;  width: 320px;  background-color:rgba(220, 218, 245, 0.41);">
            <legend><strong style="color:black;">Login Window</strong></legend>
            <table>
                <tr>
                    <td>User Name</td>
                    <td> &nbsp;</td>
                    <td><input type="text" id="userName" name="userName"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td> &nbsp;</td>
                    <td><input type="password" id="userPwd" name="userPwd"/></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" name="commit" value="Log In"/></td>
                </tr>
            </table>
        </fieldset>
    </div>
</form>
</div>
</body>
</html>