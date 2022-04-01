package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex01sum")
public class ex01sum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		int num1 = Integer.parseInt(request.getParameter("num1") );
		int num2 = Integer.parseInt(request.getParameter("num2") );
		
		String result = num1+" 과 "+ num2+" 의 합은 "+(num1+num2)+"입니다.";
		
		// 되돌려주기 위한 객체 -> response
		// Ajax에서 값을 돌려줄때 PrintWriter객체 
		// response 인코딩
		// Ajax의 특징 : 인코딩 방식은 UTF-8만 쓸수 있음
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(result);
 		
	}

}
