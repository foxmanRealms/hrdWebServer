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
	<h1> ȸ����ü�˻� ������ </h1>
	<table>
	<%

	// ��������
	ResultSet rs = null;
	PreparedStatement psmt = null;
	Connection conn = null;
	
	
	try {
		// 2-1. DB ����
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dbid = "hr";
		String dbpw = "hr";

		conn = DriverManager.getConnection(url, dbid, dbpw);

		if (conn != null) {
			System.out.println("DB���� ����!");
		} else {
			System.out.println("DB���� ����!");
		}

		// 2-2. SQL���� ���ؼ� id,pw ��ȸ
		String sql = "select * from web_member";

		// �ۼ��� sql���� db�� ����
		// ����� ������ �Ǹ� PreparedStatement ��ü�� ��ȯ
		 psmt = conn.prepareStatement(sql);
		// sql�� ����
		// executeUpdate -> select������ ������, DB��ȭ O , int ���·� ���� ��ȭ�� ���� ���� ���� �����ִ� ������
		// executeQuery -> select���� , DB��ȭ X , ResultSet���·� ����

		rs = psmt.executeQuery();
		while(rs.next() ){
			String id=rs.getString("id");
			String pw=rs.getString("pw");
			String nick=rs.getString("nick");
			
			// jsp���� ����� �� => ǥ����, out��ü 
			
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