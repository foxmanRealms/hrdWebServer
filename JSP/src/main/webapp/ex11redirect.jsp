<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		페이지 이동하기 1. a 태그 
					2. sendRedirect()  ->  JSP 내장객체 response사용
					3. forward()
		
	-->
	
	<!--  
	<a href="http://www.naver.com">네이버로 이동</a> -->
	<% 
		// sendRedirect  페이지 강제이동
		response.sendRedirect("http://www.naver.com");
	
		System.out.print("sendRediect 이후 코드");
	
	%>
	
	
</body>
</html>