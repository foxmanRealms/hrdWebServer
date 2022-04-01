<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	num1 :
	<input type="text" name="num1">
	<br> num2 :
	<input type="text" name="num2">
	<br>

	<button onClick="sum()">더하기</button>

	<!-- Ajax에서 제이쿼리를 사용하기 때문에 제이쿼리 삽입 -->
	<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
	// openAPI를 쓸 경우에 제이쿼리 or 일반 자바스크립트 문법      혼용하면 오류가 발생할 우려가 있다
	function sum(){
		$.ajax({
			// http://....
	         // 같은 프로젝트 내에서 url mapping, main.jsp파일
	         url : "ex01sum",
	         type : "get",
	         data : {
	            "num1" : $('input[name=num1]').val(),
	            "num2" : $('input[name=num2]').val()
	         },
	         //dataType-> 데이터 보낼때
	                        //서버에 요청된 결과가 담김
	         success : function(res) {
	            //alert("성공");
	            console.log(res);
	         },
	         error : function(){
	            alert("실패");
	         }	
		
		
		});
		

	</script>
</body>
</html>