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
	<table border=1>
		<thead>
			<tr>
				<th>User Id</th>
				<th>Name</th>
				<th>Description</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${user}" var="user">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.description}" /></td>
					<td><a href="UserController?action=edit&id=<c:out value="${user.id}"/>">Update</a></td>
                    <td><a href="UserController?action=delete&id=<c:out value="${user.id}"/>">Delete</a></td>
                
				</tr>
				</c:forEach>
		</tbody>
	</table>
	<p><a href="UserController?action=insert">Add User</a></p>
	
</body>
</html>