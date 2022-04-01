<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <h1>스코프 영역 차이 비교하기</h1>
   <%
         // 2. Scope영역에서 값 꺼내오기
         // 다운캐스팅 필요
         String pageS = (String)pageContext.getAttribute("page");
         String requestS = (String)request.getAttribute("request");
         String sessionS = (String)session.getAttribute("session");
         String applicationS = (String)application.getAttribute("application");
         
         
         out.print(pageS+"<br>");
         out.print(requestS+"<br>");
         out.print(sessionS+"<br>");
         out.print(applicationS+"<br>");
   
   
   
   
   %>
</body>
</html>