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
		������ �̵��ϱ� 1. a �±� 
					2. sendRedirect()  ->  JSP ���尴ü response���
					3. forward()
		
	-->
	
	<!--  
	<a href="http://www.naver.com">���̹��� �̵�</a> -->
	<% 
		// sendRedirect  ������ �����̵�
		response.sendRedirect("http://www.naver.com");
	
		System.out.print("sendRediect ���� �ڵ�");
	
	%>
	
	
</body>
</html>