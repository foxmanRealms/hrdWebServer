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

@WebServlet("/UpdateCon")
public class UpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// post ��� ���ڵ�
		request.setCharacterEncoding("euc-kr");
	
		String id=request.getParameter("id");
		String select=request.getParameter("select");
		String data = request.getParameter("data");
		
		
		//�������� �����              try �� �ٱ��� 
		Connection conn=null;
		PreparedStatement psmt=null;
		String sql = null;
		
		// �����ͺ��̽� �����ϱ� ���� �ʿ��� �� : ����ó�� try~catch   try ���� �ڵ��ϼ�
		
		try {
			//�����ͺ��̽� ���� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
									// @������Ʈ �� ���� �ּ� 
			String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid="hr";
			String dbpw="hr";
			
			 conn = DriverManager.getConnection(url,dbid,dbpw);
			////// Ŀ���� ���鶧 ����Ʈ �����̽� �ڵ��ϼ����� ����� �ڹ� Ŭ���ϸ� �ڵ�����Ʈ �ȴ�.
			
			if (conn != null) {
				System.out.println("�����ͺ��̽� ���� ����!");
			}else {
				System.out.println("���� ���Ф�");
			}
			
			// sql�� �غ� �� ���� 
			// ���� : pw�̸� �Ǵ� nick�̸� 
			// ���̺��� �÷����� ���ε� ������ �� �� ����.
			
			
			
			if (select.equals("pw")) {
				sql="update web_member set pw=? where id=?";
			}else {
				sql="update web_member set nick=? where id=?";
			}
			
			
			
			 psmt = conn.prepareStatement(sql);
			
			////// ���� 1�� ù��° ?��� ���̴�   ?�� ���ε� ������ 
			// 0���� ������ �ƴ϶� 1���� ������� ����.
			psmt.setString(1,data);
			psmt.setString(2,id);
			
			//executeUpdate();  -> insert, update, delete : ���̺� ��ȭ o
			//executeQuerry(); -> select : ���̺� ���� x 
			int cnt = psmt.executeUpdate();
			// cnt : ó���� row���� ���ϵ� �� 
			
			if (cnt>0) {
				System.out.println("ȸ������ ����");
				// ������ �����ϸ� Main.html �̵��ϱ� 
				// ������ �̵�  sendRedirect
				response.sendRedirect("Main.html");
			}else {
				System.out.println("ȸ������ ����");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			///// Ŭ���� ���� sql���� �� �� �ٸ�  1���� ����ó���� ��´�.
		} finally {
			// �׻� �����ؾ��� ��
			// ������ ���� ����   �������  close()
			// ������ ������ �ݴ�� �������� ������ ���� ���� ����
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
