package kr.co.smhrd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex09join")
public class ex09join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 한글 인코딩
		request.setCharacterEncoding("euc-kr");
		
		// 파라미터 수집
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String mail = request.getParameter("mail");
		String []food = request.getParameterValues("food");
		String []hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");		
		String color = request.getParameter("color");		
		String board = request.getParameter("board");
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(pw);
		System.out.println(mail);
		
		String foods="";
		for (int i = 0; i < food.length; i++) {
			foods +=food[i];
		}
		String hobbies="";
		for (int i = 0; i < hobby.length; i++) {
			hobbies +=hobby[i];
		}
		
		System.out.println(gender);
		System.out.println(color);
		System.out.println(board);
	}

}
