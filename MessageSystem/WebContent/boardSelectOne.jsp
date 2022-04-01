<%@page import="Model.BoardDTO"%>
<%@page import="Model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assetsBoard/css/main.css" />
<link rel="stylesheet" href="assetsBoard/css/board.css" />
</head>
<body>
	<% int num = Integer.parseInt(request.getParameter("num"));
		BoardDAO dao =new BoardDAO();
		BoardDTO dto = dao.boardSelectOne(num);
		
	%>
	
	
	<table>
		<tr>
			<td>제목</td>
			<td><%= dto.getTitle() %></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%= dto.getWriter() %></td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
			<img src="file/<%=dto.getFilename()%>">
			<%=dto.getContent() %></td>
			
		</tr>
	
	</table>


</body>
</html>