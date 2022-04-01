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
      //0. post ����� ���ڵ�
      request.setCharacterEncoding("euc-kr");
      //1. ID�� PW�� �Ķ���� ����
      String id =request.getParameter("id");
      String pw =request.getParameter("pw");
      System.out.println("id : "+id);
      System.out.println("pw : "+pw);
      
      
      
      //��������
      ResultSet rs = null;
      PreparedStatement psmt = null;
      Connection conn = null;
      String nick = null;
      String uid = null;
      String upw = null;
      
      
      
      // 2 . DB�� ���� �Է¹��� id, pw�� �ִ��� Ȯ��
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
         String dbid="hr";
         String dbpw="hr";
         
         conn = DriverManager.getConnection(url, dbid, dbpw);
         
         if(conn != null) {
            System.out.println("DB ���� ����..!");
         }else {
            System.out.println("DB ���� ����!");
         }
         
         // 2-2. SQL���� ���ؼ� id, pw ��ȸ
         String sql = "select*from web_member where id=? and pw=?";
         
         // �ۼ��� sql���� DB�� ����
         // ����� ������ �Ǹ� preparedStatement ��ü�� ��ȯ
         psmt = conn.prepareStatement(sql);
         
         // ?�� �� ä���(���ε庯��)
         psmt.setString(1, id);
         psmt.setString(2, pw);
         
         // sql�� ����
         // executeUpdate - > select������ ������ db��ȭ, int���·� ����
         // executeQuery -> select����, DB��ȭ x , result
         rs = psmt.executeQuery();
         if(rs.next()) {
         uid = rs.getString("id");
         upw = rs.getString("pw");
         
         nick = rs.getString("nick");
         System.out.println(nick);
         
         
         HttpSession session = request.getSession();
         
         //MemberVO��ü�� ������ �̵� �Ǵ� ���ǿ� �����ϱ�
         MemberVO vo = new MemberVO(uid, upw);
         session.setAttribute("vo", vo);
         session.setAttribute("id", uid);
         
         // ���ǿ� �г����� �Ȱ� ������ �̵��ϱ�
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
      
      // �α��μ��� -> loginS.jsp�� �������̵�
      // �α��ν��� -> loginF.jsp�� �������̵�
      
//      if(nick != null){
//         System.out.println("�α��� ����");
//         response.sendRedirect("loginS.jsp?nick="+URLEncoder.encode(nick,"EUC-KR"));
//      }else{
//         System.out.println("�α��� ����");
//         response.sendRedirect("loginF.jsp");
//      }

   }

}