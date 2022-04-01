package kr.co.smhrd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex04Plus")
public class ex04Plus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out= response.getWriter();
		
		String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2");
	
	// 문자열을 정수형으로 바꾸기
	int num11 =Integer.parseInt(num1);
	int num22 =Integer.parseInt(num2);
	
	out.print(num11+num22);
	}

}
