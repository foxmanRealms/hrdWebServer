<%@page import="com.example.MemberVO"%>
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
   //자식클래스 변수 String = (자식클래스 타입)부모타입의 데이터 
   //다운캐스팅 필요
   String id = (String)session.getAttribute("id");
   
   MemberVO vo = (MemberVO)session.getAttribute("vo");
   
   if(vo != null){
      System.out.print("현재 로그인 된 사람의 정보는 : "+ vo.getId() + vo.getPw()+ vo.getNick());
   }
   
   
   
   
   if(id != null){
      out.print(id+"님 환영합니다.");      
   }else{
      out.print("로그인 상태가 아닙니다.");
   }
   
   
   %>
   <h1>메인 페이지</h1>
   <a href="join.html">회원 가입 페이지</a><br>
   <a href="login.html">회원 로그인 페이지</a><br>
   <a href="logout.jsp">로그아웃</a><br>
   <a href="delete.html">회원 삭제 페이지</a><br>
   <a href="update.html">회원 수정 페이지</a><br>
   <a href="selectAll.jsp">회원 전체 검색 페이지</a>
</body>
</html>