package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// post 방식 인코딩
		request.setCharacterEncoding("euc-kr");
	
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String nick=request.getParameter("nick");
		
		
		//전역변수 만들기              try 문 바깥에 
		Connection conn=null;
		PreparedStatement psmt=null;
		
		// 데이터베이스 연결하기 전에 필요한 것 : 예외처리 try~catch   try 이후 자동완성
		
		try {
			//데이터베이스 연결 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
									// @프로젝트 때 받은 주소 
			String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid="hr";
			String dbpw="hr";
			
			 conn = DriverManager.getConnection(url,dbid,dbpw);
			////// 커섹션 만들때 시프트 스페이스 자동완성으로 보라색 자바 클릭하면 자동임포트 된다.
			
			if (conn != null) {
				System.out.println("데이터베이스 연결 성공!");
			}else {
				System.out.println("연결 실패ㅜ");
			}
			
			// sql문 준비 및 실행 
			String sql="insert into web_member values(?,?,?)";
			
			 psmt = conn.prepareStatement(sql);
			
			////// 여기 1은 첫번째 ?라는 뜻이다   ?는 바인드 변수다 
			// 0부터 시작이 아니라 1부터 순서대로 들어간다.
			psmt.setString(1,id);
			psmt.setString(2,pw);
			psmt.setString(3,nick);
			
			
			//executeUpdate();  -> insert, update, delete : 테이블 변화 o
			//executeQuerry(); -> select : 테이블에 영향 x 
			int cnt = psmt.executeUpdate();
			// cnt : 처리된 row값이 리턴된 값 
			
			if (cnt>0) {
				System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			///// 클래스 오류 sql오류 를 둘 다를  1가지 예외처리로 잡는다.
		} finally {
			// 항상 수행해야할 것
			// 열었던 것을 종료   연결끊기  close()
			// 열었던 순서와 반대로 마지막에 열었던 것을 먼저 닫음
			// psmt -> conn
			
			
			
			try {
				
				if (psmt!=null)  psmt.close();
				if (conn!=null)  conn.close();
				
			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
			
			
			
			
		}
		
		
	}

}
