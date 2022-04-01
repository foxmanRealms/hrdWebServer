package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Send")
public class Send extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String led="0";
			
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		led = request.getParameter("led");
		
		// 제어페이지의 링크를 건다. 
		response.sendRedirect("index2.html");
	
	}

}
