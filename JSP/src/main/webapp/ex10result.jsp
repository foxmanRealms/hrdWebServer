<%@page import="java.util.Random"%>
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
		
		// ����, �ݺ��ߴ� input�±׵�(name�� itme)  �������� 
		
		String title = request.getParameter("title");
		String []item = request.getParameterValues("item");
		
		
		// ���� �� ���� 
		
		 Random rd = new Random();
		int random = rd.nextInt(item.length);
		
		
	%>


	<fieldset>
		<legend>
		���� ��÷ ���
		</legend>
		<!--  ���� ������ �޾ƿͼ� ����ϱ� -->
		<%= title %>
		
		<!-- �ݺ��ߴ� input�±׵� �߿��� �������� ����ϱ� -->
		<%= item[random] %>
		
	</fieldset>

</body>
</html>