<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" language="javascript" src="script/validation.js" >
</script>
</head>
<body>
      <form name="myForm" action="myServlet" onsubmit="return validate(this)">      
         <h3> Enter the Message :->   &nbsp;<input type="text" name="userName"/> </h3>
         <input type="submit" value="send" />
      </form>
</body>
</html>