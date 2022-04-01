<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> 100까지의 합</h1>
	<!-- 자바코드를 쓰기 위해 스크립틀릿  -->
	<% 
	int sum=0;
	for(int i=1 ;i<=100; i++){
		sum+=i;
	}
		
	%>
	
	<!-- 웹페이지에 결과 보여주기 위해 표현식 =  -->
	<%= 
	sum
	%>
	
	
</body>
</html>