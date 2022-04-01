<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <h1>스코프 영역 실습</h1>
   <%
      // 1. Scope에 값을 넣기
      // 값을 넣는 메소드 setAttribute(name,value)
   
      //page scope
      pageContext.setAttribute("page", "페이지 스코프입니다.");
      
      //request scope
      request.setAttribute("request", "리퀘스트 스코프입니다.");
      
      //session scope
      session.setAttribute("session", "세션 스코프입니다.");
      
      //application scope
      application.setAttribute("application", "어플리케이션 스코프입니다.");
      
      
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
      
      // 페이지 이동1
      // forward()방식 : 일종의 교통수단 RequestDispatcher객체 필요
      // url 변경되지 않음, request와 response정보를 유지
      // request.getRequestDispatcher("이동할 경로")
      RequestDispatcher rd = request.getRequestDispatcher("ex02selectScope.jsp");
      rd.forward(request, response);
      
      //페이지 이동2
      //sendRedirect() 이용해서
      // url 변경이 일어남.  정보가 유지되지 않음 
      //response.sendRedirect("ex02selectScope.jsp");
      
   %>
</body>
</html>