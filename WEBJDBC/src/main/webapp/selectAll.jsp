<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원전체검색 페이지 </h1>
	<table>
	<%

	// 전역변수
	ResultSet rs = null;
	PreparedStatement psmt = null;
	Connection conn = null;
	
	
	try {
		// 2-1. DB 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dbid = "hr";
		String dbpw = "hr";

		conn = DriverManager.getConnection(url, dbid, dbpw);

		if (conn != null) {
			System.out.println("DB연결 성공!");
		} else {
			System.out.println("DB연결 실패!");
		}

		// 2-2. SQL문을 통해서 id,pw 조회
		String sql = "select * from web_member";

		// 작성한 sql문을 db에 전달
		// 제대로 전달이 되면 PreparedStatement 객체로 반환
		 psmt = conn.prepareStatement(sql);
		// sql문 실행
		// executeUpdate -> select구문을 제외한, DB변화 O , int 형태로 리턴 변화한 행의 갯수 들을 보여주는 식으로
		// executeQuery -> select구문 , DB변화 X , ResultSet형태로 리턴

		rs = psmt.executeQuery();
		while(rs.next() ){
			String id=rs.getString("id");
			String pw=rs.getString("pw");
			String nick=rs.getString("nick");
			
			// jsp에서 출력할 때 => 표현식, out객체 
			
			out.print( "<tr>");
			out.print( "<td>"+id+"</td>");
			out.print( "<td>"+pw+"</td>");
			out.print( "<td>"+nick+"</td>");
			out.print( "</tr>");
		}

	} catch (Exception e) {
		e.printStackTrace();

	} finally {
		try {
			if (rs != null) rs.close();
			if (psmt != null) psmt.close();
			if (conn != null) conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	%>
	</table>
</body>
</html>