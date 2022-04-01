package kr.co.smhrd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex06Table")
public class ex06Table extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out= response.getWriter();
		
		
		//파라메터 수집
		String room = request.getParameter("room");
		//문자열 -> 정수형
		int roomNum=Integer.parseInt(room);
		
		
	out.print("<table border='1'><tr>");
	for (int i = 1; i <= roomNum; i++) {
		out.print("<td>"+i+ "</td>");
	}
	out.print( "</tr></table>");
	
	}

}
