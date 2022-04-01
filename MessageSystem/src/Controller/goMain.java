package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberDTO;
import Model.MessageDAO;
import Model.MessageDTO;

@WebServlet("/goMain")
public class goMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// ���� ����
		HttpSession session = request.getSession();
		MemberDTO dto=(MemberDTO) session.getAttribute("info");
		
		
		// �޼��� ���
		if(dto !=null) {
			// �α��� ����
			MessageDAO dao = new MessageDAO();
			List<MessageDTO>msglist= dao.selectMsg(dto.getEmail());
			
			// List�� ��� ���� ���� ä�� ������ �̵�
			// forward ��� ���� �̵��ϱ� ���� List ���� ����
			// request scope
			request.setAttribute("msglist", msglist);
			
		}else {
			
		}
		
		// forward ������� ������ �̵� 
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
		
		
	}

}
