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
		// 쿠키 : 웹사이트정보를 담은 임시파일 
		
		// 1. 쿠키 생성 
		Cookie cookie = new Cookie("id","스마트");
		
		// 2. 쿠키 정보를 사용자에게 전송(저장)
		response.addCookie(cookie);
	
	
	%>

</body>
</html>