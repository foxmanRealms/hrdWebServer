<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> 100������ ��</h1>
	<!-- �ڹ��ڵ带 ���� ���� ��ũ��Ʋ��  -->
	<% 
	int sum=0;
	for(int i=1 ;i<=100; i++){
		sum+=i;
	}
		
	%>
	
	<!-- ���������� ��� �����ֱ� ���� ǥ���� =  -->
	<%= 
	sum
	%>
	
	
</body>
</html>