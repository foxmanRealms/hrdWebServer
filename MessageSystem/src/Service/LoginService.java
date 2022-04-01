package Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberDAO;
import Model.MemberDTO;
import inter.Command;

public class LoginService implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �α��� ���
		
		System.out.println("[LoginServiceCon]");

		// 1. post��� ���ڵ�
		request.setCharacterEncoding("utf-8");
		// 2. email.pw �޾ƿ���
		String email = request.getParameter("loginemail");
		String pw = request.getParameter("pw");
		
		// 3. login�޼ҵ� ȣ��
		MemberDTO dto= new MemberDAO().login(email,pw);
		
		// 4. �������п���
		if (dto!=null) {
			System.out.println("--�α��� ����");
			System.out.println(dto.getEmail());
			HttpSession session= request.getSession();
			session.setAttribute("info", dto);
		}else {
			System.out.println("--�α��� ����");
		}
		
		String nextpage = "goMain";
		// �α��α�� ��������
		return nextpage;
	}
}
