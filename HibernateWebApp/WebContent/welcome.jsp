<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<%@ include file="header.html" %>
	
<c:set var="uname" value="${param.username }" scope="session"></c:set>	
<c:url var="productUrlEnc" value="product.jsp"></c:url>

	<p>Dear ${param.username } Welcome to online shopping of Zensar</p>
	<p>Your Session time out period is ${pageContext.session.maxInactiveInterval } seconds</p>
	<p>To view and purchase products <a href="${ productUrlEnc}">click here</a>  </p>
		
	
	<%@ include file="footer.html" %>    <%-- static inclusion --%>
</body>
</html>