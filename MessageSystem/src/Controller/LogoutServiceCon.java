package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LogoutServiceCon")
public class LogoutServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		System.out.println("[LogoutServiceCon]");
		
		// �α׾ƿ� �̶� -> �α����� �������� == session����
		
		HttpSession session = request.getSession();
		
//		// 1. ���� ����          -> ��������
//		session.invalidate();   ////// ��� ������ �� �����Ų��
		
		// 2. ���� ����        -> Ư���� ���Ǹ� �����Ų��. 
		session.removeAttribute("info");  
		
		System.out.println("�α׾ƿ� ����");
		
		response.sendRedirect("goMain");
		
	}

}
