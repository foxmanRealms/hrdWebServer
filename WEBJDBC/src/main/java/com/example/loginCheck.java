package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //0. post 방식의 인코딩
      request.setCharacterEncoding("euc-kr");
      //1. ID와 PW를 파라미터 수집
      String id =request.getParameter("id");
      String pw =request.getParameter("pw");
      System.out.println("id : "+id);
      System.out.println("pw : "+pw);
      
      
      
      //전역변수
      ResultSet rs = null;
      PreparedStatement psmt = null;
      Connection conn = null;
      String nick = null;
      String uid = null;
      String upw = null;
      
      
      
      // 2 . DB에 내가 입력받은 id, pw가 있는지 확인
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
         String dbid="hr";
         String dbpw="hr";
         
         conn = DriverManager.getConnection(url, dbid, dbpw);
         
         if(conn != null) {
            System.out.println("DB 연결 성공..!");
         }else {
            System.out.println("DB 연결 실패!");
         }
         
         // 2-2. SQL문을 통해서 id, pw 조회
         String sql = "select*from web_member where id=? and pw=?";
         
         // 작성한 sql문을 DB에 전달
         // 제대로 전달이 되면 preparedStatement 객체로 반환
         psmt = conn.prepareStatement(sql);
         
         // ?에 값 채우기(바인드변수)
         psmt.setString(1, id);
         psmt.setString(2, pw);
         
         // sql문 실행
         // executeUpdate - > select구문을 제외한 db변화, int형태로 리턴
         // executeQuery -> select구문, DB변화 x , result
         rs = psmt.executeQuery();
         if(rs.next()) {
         uid = rs.getString("id");
         upw = rs.getString("pw");
         
         nick = rs.getString("nick");
         System.out.println(nick);
         
         
         HttpSession session = request.getSession();
         
         //MemberVO객체로 데이터 이동 또는 세션에 저장하기
         MemberVO vo = new MemberVO(uid, upw);
         session.setAttribute("vo", vo);
         session.setAttribute("id", uid);
         
         // 세션에 닉네임을 안고 페이지 이동하기
         response.sendRedirect("Main.jsp");
         
         
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(rs != null) rs.close();
            if(psmt != null) psmt.close();
            if(conn != null) conn.close();
            
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      
      // 로그인성공 -> loginS.jsp로 페이지이동
      // 로그인실패 -> loginF.jsp로 페이지이동
      
//      if(nick != null){
//         System.out.println("로그인 성공");
//         response.sendRedirect("loginS.jsp?nick="+URLEncoder.encode(nick,"EUC-KR"));
//      }else{
//         System.out.println("로그인 실패");
//         response.sendRedirect("loginF.jsp");
//      }

   }

}