<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	test/JOIN Page
</h1>
	
<form action="${pageContext.request.contextPath}/test/join" method=post>
	<input name="name"><br>
	<input name="age"><br>
	<input name="addr"><br>
	<button>JOIN</button>
</form>
	
<P>  </P>
</body>
</html>
