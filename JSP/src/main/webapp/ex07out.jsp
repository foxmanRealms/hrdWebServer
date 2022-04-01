<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<!-- out객체 : 웹페이지에 정보를 출력하기 위한 객체
				servlet에서 PrintWriter객체를 생성한 것과 같음  -->
	<table border="1"> 
			<tr>
			<%
				for(int i=1 ;i<=10; i++){
					out.print("<td>"+ i + "</td>");
				}
			
			%>
			
			</tr>
	
	</table>
</body>
</html>