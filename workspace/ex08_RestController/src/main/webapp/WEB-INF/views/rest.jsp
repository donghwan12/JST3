<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
	<style>
	.wrapper{
		display:flex;
		justify-content : left;
	}
	.wrapper>div{
			width : 200px; height : 500px;
			border : 1px solid;
			margin : 15px;
			text-align:center;
			
			overflow : auto;
	}
	.wrapper>div.result{
		width : 300px;
	}
	.wrapper>div>h1{
		border : 1px solid;
		margin-bottom : 15px;
	}
	.wrapper>div>div{
		border : 1px solid;
		margin : 5px;
		padding : 0px;
		opacity:.8;
	}
	.wrapper>div>div:hover{
		background-color:lightgray;
		opacity:1;
	}
	input {
		width : 55px;
	}
	</style>
</head>
<body>
<h1>REST TEST PAGE</h1>

	<div class="wrapper">
		
		<!--  -->
		<div class="xhr-block">
			<h1>XHR</h1>
						<div class="get">
				<h6>[ADD]동기 GET 요청</h6>
				<form method="get" action="${pageContext.request.contextPath}/add_get">
					<input name="id"  placeholder="id" />
					<input name="text" placeholder="text"  />
					<button>전송</button>  
				</form>
			</div>			
			<div class="get">
				<h6>[ADD]비동기 GET 요청</h6>
				<form name="xhrAsyncGetForm" method="" action="" onsubmit="return false">
					<input name="id"  placeholder="id" />
					<input name="text" placeholder="text"  />
					<button class="xhrAsyncGetBtn">전송</button>  
				</form>
			</div>
			<div class="post">
				<h6>[ADD]비동기 POST 요청</h6>
				<form name="xhrAsyncPostForm" method="" action="" onsubmit="return false">
					<input name="id"  placeholder="id" />
					<input name="text" placeholder="text"  />
					<button class="xhrAsyncPostBtn">전송</button>  
				</form>
			</div>
			<div class="put">
				<h6>[UPDATE]비동기 PUT 요청</h6>
				<form name="xhrAsyncPutForm" method="" action="" onsubmit="return false">
					<input name="id"  placeholder="id" />
					<input name="text" placeholder="text"  />
					<button class="xhrAsyncPutBtn">전송</button>  
				</form>
			</div>	
			<div class="petch">
				<h6>[UPDATE]비동기 PETCH 요청</h6>
				<form method="" action="" onsubmit="return false">
					<input name="id"  placeholder="id" />
					<input name="text" placeholder="text"  />
					<button>전송</button>  
				</form>
			</div>				
			<div class="delete">
				<h6>[DELETE]비동기 DELETE 요청</h6>
				<form name="xhrAsyncDeleteForm"  method="" action="" onsubmit="return false">
					<input name="id"  placeholder="id" />
					<input name="text" placeholder="text"  />
					<button class="xhrAsyncDeleteBtn">전송</button>  
				</form>
			</div>
			
		</div>
		
		<!--  -->
		<div class="ajax-block">
			<h1>AJAX</h1>
			<div></div>
		</div>
		
		<!--  -->
		<div class="fetch-block">
			<h1>FETCH</h1>
			<div></div>
		</div>
		
		
		<!--  -->
		<div class="axios-block">
			<h1>AXIOS</h1>
			<div class="get">
				<h6>[ADD]동기 GET 요청</h6>
				<form method="get" action="${pageContext.request.contextPath}/add_get">
					<input name="id"  placeholder="id" />
					<input name="text" placeholder="text"  />
					<button>전송</button>  
				</form>
			</div>
						
			<div class="get">
				<h6>[ADD]비동기 GET 요청</h6>
				<form name="axiosAsyncGetForm" onsubmit="return false">
					<input name="id"  placeholder="id" />
					<input name="text" placeholder="text"  />
					<button class="axiosAsyncGetBtn">전송</button>  
				</form>
			</div>
			<div class="post">
				<h6>[ADD]비동기 POST 요청</h6>
				<form name="axiosAsyncPostForm" method="" action="" onsubmit="return false">
					<input name="id"  placeholder="id" />
					<input name="text" placeholder="text"  />
					<button class="axiosAsyncPostBtn">전송</button>  
				</form>
			</div>
			<div class="put">
				<h6>[UPDATE]비동기 PUT 요청</h6>
				<form name="axiosAsyncPutForm" method="" action="" onsubmit="return false">
					<input name="id"  placeholder="id" />
					<input name="text" placeholder="text"  />
					<button class="axiosAsyncPutBtn">전송</button>  
				</form>
			</div>	
			<div class="petch">
				<h6>[UPDATE]비동기 PETCH 요청</h6>
				<form method="" action="" onsubmit="return false">
					<input name="id"  placeholder="id" />
					<input name="text" placeholder="text"  />
					<button>전송</button>  
				</form>
			</div>				
			<div class="delete">
				<h6>[DELETE]비동기 DELETE 요청</h6>
				<form name="axiosAsyncDeleteForm"  method="" action="" onsubmit="return false">
					<input name="id"  placeholder="id" />
					<input name="text" placeholder="text"  />
					<button class="axiosAsyncDeleteBtn">전송</button>  
				</form>
			</div>	
		</div>
		
		
		<!-- SELECT BLOCK -->
		<div class="result">
			<h1>RESULT</h1>
			<div class="body">
			
			</div>
		</div>
	</div>


	<!--  
		XHR
	-->
	<script>
	
	</script>
	
	
	<!-- 
		AJAX
	 -->
	<script>
	</script>
	
	
	<script>
		//xhr 를 이용 비동기 요청
		
		//ajax를 이용 비동기 요청
		
		//fetch 를 이용 비동기 요청
		
		//axios 를 이용 비동기 요청
	
	</script>
	
	<!-- Axios -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.6.8/axios.min.js" integrity="sha512-PJa3oQSLWRB7wHZ7GQ/g+qyv6r4mbuhmiDb8BjSFZ8NZ2a42oTtAq5n0ucWAwcQDlikAtkub+tPVCw4np27WCg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	
	<script>
	
		const projectpath='${pageContext.request.contextPath}';
		//비동기 GET MEMO ADD
		const axiosAsyncGetBtn=document.querySelector('.axiosAsyncGetBtn');
		axiosAsyncGetBtn.addEventListener('click',function(){
			
			//axiosAsynscGetform 내용을 뽑아와서 저장
			const axiosAsyncGetForm = document.axiosAsyncGetForm;
			//저장된 내용들중에서 id의 value만 뽑아와서 id에 저장
			const id=axiosAsyncGetForm.id.value; 
			//저장된 내용들중에서 text만 봅와서 text에 담아준다
			const text=axiosAsyncGetForm.text.value;
			console.log(id,text);
			
			//axios.get 
			//클라이언트 요청 영역
			axios
				.get(projectpath+"/memo/add_get?id="+id+"&text="+text)
				.then(resp=>{
					console.log(resp);
					const isAdded=resp.data;
					if(isAdded===true)
						alert("비동기 GET MEMO ADD 성공!")
					else
						alert("비동기 GET MeMo ADD 실패")
				}) //요청 성공시
				.catch(err=>{console.log(err);}) //요청 실패시
				
			
			
		});
	</script>
	
	
	
		
	
</body>
</html>