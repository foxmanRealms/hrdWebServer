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
			String homepage = request.getParameter("page");
		
			//각각 데이터가 네이버, 다음, 구글이라면 -> 맞는 페이지로 이동
			// sendredirect
			
			if(homepage.equals("네이버")){
				response.sendRedirect("http://www.naver.com");
			}else if(homepage.equals("다음")){
				response.sendRedirect("http://www.daum.net");
			}else{
				response.sendRedirect("http://www.google.com");
			}
		
		
		
		%>



</body>
</html>