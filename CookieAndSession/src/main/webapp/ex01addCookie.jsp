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
		// ��Ű : ������Ʈ������ ���� �ӽ����� 
		
		// 1. ��Ű ���� 
		Cookie cookie = new Cookie("id","����Ʈ");
		
		// 2. ��Ű ������ ����ڿ��� ����(����)
		response.addCookie(cookie);
	
	
	%>

</body>
</html>