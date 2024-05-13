<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>MEMO</title>
	
	
	
</head>
<body class="m-2 p-2">
	
	<h1>Login PAge</h1>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<input name="username"><br>
		<input name="password"><br>
		<button>로그인</button>
		
		<!--CSRF TOKEN전달  -->
	<%-- <input type="hidden" name="_csrf" values="${_csrf.token }"/> --%>
	</form>
	
</body>
</html>