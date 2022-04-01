<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> 세션 삭제하기 </h1>
	
	<%
		// 삭제방법1)  해당 이름에 대한 정보를 삭제 

		session.removeAttribute("id");
		
		/* // 삭제방법2) 모든 세션 삭제 
		// 지양하는 방식이다. (잘 안쓴다)
		session.invalidate() ;
	 */
	
	
	%>
</body>
</html>