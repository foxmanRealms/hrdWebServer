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
		//파라미터 수집
		
		// 주제, 반복했던 input태그들(name이 itme)  가져오기 
		
		String title = request.getParameter("title");
		String []item = request.getParameterValues("item");
		
		
		// 랜덤 수 생성 
		
		 Random rd = new Random();
		int random = rd.nextInt(item.length);
		
		
	%>


	<fieldset>
		<legend>
		랜덤 당첨 결과
		</legend>
		<!--  주제 데이터 받아와서 출력하기 -->
		<%= title %>
		
		<!-- 반복했던 input태그들 중에서 랜덤으로 출력하기 -->
		<%= item[random] %>
		
	</fieldset>

</body>
</html>