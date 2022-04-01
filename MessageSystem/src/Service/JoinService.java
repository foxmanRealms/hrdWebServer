package Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberDAO;
import Model.MemberDTO;
import inter.Command;

public class JoinService implements Command{

	// 1. Command �������̽� ����
	
	// 2. �������̽��� �ִ� execute()�޼ҵ� �������̵�
	// �ڵ��ϼ� -> ����
	

	// 3. ������ �̵� response... -> ����
	//       String nextpage="�̵��� �ּ�"
	// 4. �޼ҵ� return ������ nextpage 
	
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextpage="";
		
		System.out.println("[JoinServiceCon]");

		// 1. post��� ���ڵ�
		request.setCharacterEncoding("utf-8");

		// 2. ȸ������ ������ �޾ƿ���
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		System.out.println("email : " + email);
		System.out.println("pw : " + pw);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);

		// 3. ������ DTO�� ����
		MemberDTO dto = new MemberDTO(email, pw, tel, address);

		// 4. DB������ DAOȣ��

		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(dto);
		// ���� ����
		HttpSession session = request.getSession();
		
		System.out.println("������� ����");
		// 5. ������ Ȯ��
		if (cnt > 0) {
			System.out.println("-- ȸ�����Լ���");
			
			// email session���� �����!
			session.setAttribute("email", email);
			
			nextpage = "join_success.jsp";
		} else {
			System.out.println("-- ȸ�����Խ���");
			nextpage = "goMain";
		}	// ȸ������ ��������
		
		
		
		
		return nextpage;
	}
	
	
	
	
}
