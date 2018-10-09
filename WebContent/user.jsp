<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UserController" method="post" name="formAddUser">
		User ID: <input type="text" name="id" value="<c:out value="${ user.id }" />" /> <br/>
		Name: <input type="text" name="name" value="<c:out value="${ user.name }" />" /> <br/>
		Description: <input type="text" name="description" value="<c:out value="${ user.description }" />" /> <br/>
		<input type="submit" value="submit"/>
	</form>
</body>
</html>