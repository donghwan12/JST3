<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Memo.jsp Page	

</h1>

<form action="${pageContext.request.contextPath}/memo/add" method=post>
	<input name=id><br>
	<input name=text><br>
	<input name=writer><br>
	<input name=regdate><br>
	<button>전송</button>
</form>	
	
<P>  </P>
</body>
</html>
