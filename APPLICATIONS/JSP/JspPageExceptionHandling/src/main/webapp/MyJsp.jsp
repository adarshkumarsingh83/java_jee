<%@ page import="java.lang.Integer" language="java" contentType="text/html; charset=ISO-8859-1"
   errorPage="/error.jsp"    pageEncoding="ISO-8859-1"%>

	<%!
		private int number1;
	    private int number2;
	%>
   <%
     number1=Integer.parseInt(request.getParameter("number1"));
     number2=Integer.parseInt(request.getParameter("number2"));
   %> 
    <%=number1/number2%>
    
    <jsp:forward page="/myServlet"/>