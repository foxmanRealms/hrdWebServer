package kr.co.smhrd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex04Mini")
public class ex04Mini extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// ������ �������� ���ڵ����, ������ ����� ����
		response.setContentType("text/html; charset=euc-kr");
		// ��� ��Ʈ�� ��ü�� ����
		PrintWriter out= response.getWriter();
	
		
		String mini=request.getParameter("mini");
		
		if (mini.equals("one")) {
			out.print("<img src='images/one.jpg' >");
			
		}else if (mini.equals("two")) {
			out.print("<img src='images/two.jpg' >");
			
		}else {
			out.print("<img src='images/three.jpg' >");
			
		}
		
		
		out.print("<img src='images/one.jpg' >");
		
		
		
	}

}
