package Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberDAO;
import Model.MemberDTO;
import inter.Command;

public class IdCheckService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���̵� �ߺ�üũ ���
		System.out.println("[IdCheckServiceCon]");

		// ���̵��ߺ�üũ ��ư�� ������ �� ajax�� ���� email �� �޾ƿ���

		String email = request.getParameter("email");
		System.out.println("email : " + email);

		// ���̵� �ߺ�üũ �޼ҵ� ȣ���ϱ�
		// MemberDAO dao = new MemberDAO();
		// boolean result2 = dao.idCheck(email);

		boolean result = new MemberDAO().idCheck(email);

		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
		// response.getWriter().print(result);
		// ���̵� �ߺ�üũ ��������

		return null;
	}

}
