<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 
	// 파라미터 수집
	
	// num을 가져오기
	int num = Integer.parseInt( request.getParameter("num") );
	
	
	%>
	
	
	
	<form action="ex10result.jsp">
	<fieldset>
		<legend>
		랜덤당첨 작성
		</legend>
	
		주제 : <input type="text" name="title"> <br>
		<!-- 입력했던 num의 수만큼 input태그를 만들어야함 -->
		<% 
			// num만큼 input태그 반복하기 
		
			for(int i=1 ; i<=num; i++){
				out.print( "아이템" + i + "<input type='text' name='item'> <br>");
			}
		%>
		<input type="submit" value="랜덤 당첨 시작">
	
	</fieldset>
	
	</form>

</body>
</html>