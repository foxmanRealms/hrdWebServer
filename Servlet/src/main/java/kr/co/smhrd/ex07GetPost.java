package kr.co.smhrd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex07GetPost")
public class ex07GetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
//
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data=request.getParameter("data");
		System.out.println("get��Ŀ��� ���� �� : " + data);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post������� ���ڵ� �� ���� 
		//request��ü���� ���ڵ� �ؾ��Ѵ�.
		// -> ���� �������� ���� (�Ķ���� ����) ���ڵ��� ����� �Ѵ�.
		request.setCharacterEncoding("euc-kr");
		
		
		String data=request.getParameter("data");
		System.out.println("post��Ŀ��� ���� �� : " + data);
	}

}
