package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MemberDAO;


@WebServlet("/IdCheckServiceCon")
public class IdCheckServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[IdCheckServiceCon]");
		
		request.setCharacterEncoding("euc-kr");
		
		//���̵��ߺ�üũ ��ư�� ������ �� ajax�� ���� email �� �޾ƿ���
		String email = request.getParameter("email");
		System.out.println("email : "+email);
		
		// ���̵� �ߺ�üũ �޼ҵ� ȣ���ϱ�
		
		boolean result = new MemberDAO().idCheck(email);
		
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
