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

@WebServlet("/JoinCon2")
public class JoinCon2 extends HttpServlet {
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   request.setCharacterEncoding("euc-kr");
   
   String id = request.getParameter("id");
   String pw = request.getParameter("pw");
   String nick = request.getParameter("nick");
   
   Connection conn = null;
   PreparedStatement psmt = null;
   // 데이터베이스 연결하기전에 필요한것 : 예외처리 try~catch
   try {
      // 데이터베이스 연결
      Class.forName("oracle.jdbc.driver.OracleDriver");
      
      String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
      String dbid="hr";
      String dbpw="hr";
      
      
      conn = DriverManager.getConnection(url, dbid, dbpw);
      
      if(conn!=null) {
         System.out.println("데이터베이스 연결 성공!");
      }else {
         System.out.println("연결 실패..");
      }
      
      String sql ="insert into web_member values(?, ?, ?)";
      psmt = conn.prepareStatement(sql);
      psmt.setString(1, id);
      psmt.setString(2, pw);
      psmt.setString(3, nick);
      
      //executeUpdate(); -> insert, update, delete : 테이블 변화O
      //executeQuery(); -> select  : 테이블에 영향 X
      int cnt = psmt.executeUpdate();
      
      if(cnt>0) {
         System.out.println("회원가입 성공");
      }else {
         System.out.println("회원가입 실패");
      }
      
      
      
      
   } catch (Exception e) {
      e.printStackTrace();
   } finally {
      // 항상 수행해야할것
      // 열었던것을 종료 연결 끊기 close()
      // 열었던 순서와 반대로 마지막에 열었던것을 먼저 닫음
      // psmt -> conn 순서로 닫기
      
      try {
         if(psmt != null)  psmt.close();
         if(conn != null)  conn.close();
      } catch (Exception e2) {
         e2.printStackTrace();
      }
      
   }   
   }
}