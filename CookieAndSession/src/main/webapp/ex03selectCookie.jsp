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
		// 쿠키 정보 조회
		// 쿠키 정보가 하나이상으로 가져올 수 있음
		// -> 배열로 저장
		
		// 1. 쿠키객체 생성
		Cookie[] cookie = request.getCookies();
		
		// 예외처리
		if(cookie !=null){
			// cookie 배열에 있는 쿠키 값을 출력해주기
			// 쿠키의 이름 : getName()
			// 쿠키의 값(value) : getValue()
			
				for(int i=0;i<cookie.length;i++){
					out.print("쿠키의 이름 : " + cookie[i].getName()+"<br>");
					out.print("쿠키의 값 : " + cookie[i].getValue()+"<br>");
					
				}
		}
	
	
	%>
</body>
</html>