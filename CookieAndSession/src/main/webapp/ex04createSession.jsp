<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> 세션 만들기 </h1>
	<%
		// 세션 : 서버에 정보를 저장할 수 있는 내장객체 영역 중 하나
		// JSP에선 내장각체 session으로 바로 사용가능
		// Servlet에선 객체생성을 해줘야 한다. 
		
		session.setAttribute("id", "smart");
	
		// 세션의 유효기간 설정 
		// session.setMaxInactiveInterval(초단위로 설정 );  
		session.setMaxInactiveInterval(60);   ///// 활동하지 않는 시간 동안에~~~~~ 그 구간을 결정한다 
		
	
	
	%>
</body>
</html>