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
   // �����ͺ��̽� �����ϱ����� �ʿ��Ѱ� : ����ó�� try~catch
   try {
      // �����ͺ��̽� ����
      Class.forName("oracle.jdbc.driver.OracleDriver");
      
      String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
      String dbid="hr";
      String dbpw="hr";
      
      
      conn = DriverManager.getConnection(url, dbid, dbpw);
      
      if(conn!=null) {
         System.out.println("�����ͺ��̽� ���� ����!");
      }else {
         System.out.println("���� ����..");
      }
      
      String sql ="insert into web_member values(?, ?, ?)";
      psmt = conn.prepareStatement(sql);
      psmt.setString(1, id);
      psmt.setString(2, pw);
      psmt.setString(3, nick);
      
      //executeUpdate(); -> insert, update, delete : ���̺� ��ȭO
      //executeQuery(); -> select  : ���̺� ���� X
      int cnt = psmt.executeUpdate();
      
      if(cnt>0) {
         System.out.println("ȸ������ ����");
      }else {
         System.out.println("ȸ������ ����");
      }
      
      
      
      
   } catch (Exception e) {
      e.printStackTrace();
   } finally {
      // �׻� �����ؾ��Ұ�
      // ���������� ���� ���� ���� close()
      // ������ ������ �ݴ�� �������� ���������� ���� ����
      // psmt -> conn ������ �ݱ�
      
      try {
         if(psmt != null)  psmt.close();
         if(conn != null)  conn.close();
      } catch (Exception e2) {
         e2.printStackTrace();
      }
      
   }   
   }
}