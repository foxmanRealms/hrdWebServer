package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exam01")
public class Exam01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String led = Send.led;
		
		
//		String led=request.getParameter("led");
//		System.out.println(led);
		
		if (led.equals("1")) {
			out.print("{\"LED\":\"1\"}");
		}else if (led.equals("0")) {
			out.print("{\"LED\":\"0\"}");
		}
		
		
		
		//JSON data¸¦ Ãâ·Â
		
	//	out.print("{\"LED\":\"1\"}");
		
	
	}

}
