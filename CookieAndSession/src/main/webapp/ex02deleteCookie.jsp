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
		// 쿠키를 삭제하는 방법
		// 쿠키값 수정과 유사하다 
		Cookie cookie = new Cookie("id","");
		
	
		// 쿠키의 유효기간 설정
		// setMaxAge(초단위)
		//60*60...  웹브라우저가 꺼져있어도 유지된다. 
		// 만약 setMaxAge 설정을 안하면 브라우저 종료시 쿠키 삭제됨
		cookie.setMaxAge(0);  
		
		//쿠키 객체를 생성하면 사용자에게 전송하는 것까지!
		response.addCookie(cookie);   
	%>

</body>
</html>