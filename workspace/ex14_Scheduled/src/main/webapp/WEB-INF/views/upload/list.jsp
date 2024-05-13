<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
</head>
<body>

	<h1>File LIST</h1>
	<!-- contrloor에서  root라는이름으로 설정한 modeld의 내용을 끄집어온다 -->
	BASE DIR:${root}<br>
	<hr>
	
	<!-- SUB DIR -->
	<!-- 반복문으로 꺼내온다  -->
	<c:forEach var="subdir" items="${root.listFiles()}">
		SUB DIR:${subdir.getPath()}
		<hr>
		<c:forEach var="file" items="${subdir.listFiles()}">
			<a class="item" href="javascript:void(0)" data-file="${file.getPath()}">
				${file}
			</a><br>
		</c:forEach>
		<hr>
	</c:forEach>
	
	
	
	<script type="text/javascript">
	
		const projectPath="${pageContext.request.contextPath}";
		const itemEls =document.querySelectorAll(".item");
		itemEls.forEach(item=>{
			
			item.addEventListener('click',function(){
				console.log("ClCKED...",item);
				const filepath=item.getAttribute('data-file')
				console.log(filepath);
				
				//다운파일을 눌렀을때 /download 페이지로 넘어간다.
				location.href=projectPath+"/download?filepath="+encodeURIComponent(filepath);
			})
		})
	</script>
	
</body>
</html>