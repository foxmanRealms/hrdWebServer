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
		String data =request.getParameter("data");
		// out 내장객체로 출력
		out.print(data);
	
	%>
	
	<%= data %>
</body>
</html>