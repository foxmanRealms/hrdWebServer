<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- �Ѿ�� ID�� 'smart'�̰� PW�� '123'�̸� �α��� ����  -->
	
	<%
		// 0. post ����� ���ڵ�
		request.setCharacterEncoding("euc-kr");
		// 1. ID�� PW�� �Ķ���� ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		// �α��� ���� -> loginS.jsp�� ������ �̵�
		if(id.equals("smart") && pw.equals("123")){
			response.sendRedirect("loginS.jsp");
		} else{
		response.sendRedirect("loginF.jsp");
		}
		// �α��� ���� -> loginF.jsp�� ������ �̵� 
	
	
	
	
	%>
	
</body>
</html>