<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> ���� ����� </h1>
	<%
		// ���� : ������ ������ ������ �� �ִ� ���尴ü ���� �� �ϳ�
		// JSP���� ���尢ü session���� �ٷ� ��밡��
		// Servlet���� ��ü������ ����� �Ѵ�. 
		
		session.setAttribute("id", "smart");
	
		// ������ ��ȿ�Ⱓ ���� 
		// session.setMaxInactiveInterval(�ʴ����� ���� );  
		session.setMaxInactiveInterval(60);   ///// Ȱ������ �ʴ� �ð� ���ȿ�~~~~~ �� ������ �����Ѵ� 
		
	
	
	%>
</body>
</html>