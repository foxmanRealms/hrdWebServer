package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MemberDAO;

@WebServlet("/DeleteServiceCon")
public class DeleteServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
		 
		 MemberDAO dao = new MemberDAO();
		 int cnt = dao.delete(email);
		 
		 if (cnt>0) {
			response.sendRedirect("select.jsp");
		}else {
			response.sendRedirect("select.jsp");
			System.out.println("삭제 실패");
		}
			
			
			
	}

}
