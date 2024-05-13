<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
	<title>MEMO</title>
	
</head>
<body class="m-2 p-2">
		
		<h1>ADMIN PAGE</h1>
		
		PRINCIPAL :<sec:authentication property="principal"/> <hr>
		USERDTO:<sec:authentication property="principal.userDto"/><hr>
		USERNAME:<sec:authentication property="principal.userDto.username"/><hr>
		ROLE:<sec:authentication property="principal.userDto.role"/>
		
</body>
</html>