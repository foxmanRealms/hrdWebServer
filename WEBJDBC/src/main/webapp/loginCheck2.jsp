<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 넘어온 ID가 'smart'이고 PW가 '123'이면 로그인 성공  -->
	
	<%
		// 0. post 방식의 인코딩
		request.setCharacterEncoding("euc-kr");
		// 1. ID와 PW를 파라미터 수집
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		// 로그인 성공 -> loginS.jsp로 페이지 이동
		if(id.equals("smart") && pw.equals("123")){
			response.sendRedirect("loginS.jsp");
		} else{
		response.sendRedirect("loginF.jsp");
		}
		// 로그인 실패 -> loginF.jsp로 페이지 이동 
	
	
	
	
	%>
	
</body>
</html>