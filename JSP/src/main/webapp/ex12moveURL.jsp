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
		
			//�Ķ���� ����
			String homepage = request.getParameter("page");
		
			//���� �����Ͱ� ���̹�, ����, �����̶�� -> �´� �������� �̵�
			// sendredirect
			
			if(homepage.equals("���̹�")){
				response.sendRedirect("http://www.naver.com");
			}else if(homepage.equals("����")){
				response.sendRedirect("http://www.daum.net");
			}else{
				response.sendRedirect("http://www.google.com");
			}
		
		
		
		%>



</body>
</html>