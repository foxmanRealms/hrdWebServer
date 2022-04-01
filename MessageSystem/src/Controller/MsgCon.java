package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MessageDAO;
import Model.MessageDTO;

@WebServlet("/MsgCon")
public class MsgCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// post��� ���ڵ�
		request.setCharacterEncoding("UTF-8");
		
		// �Ķ���� ����
		String send_name = request.getParameter("send_name");
		String receive_email = request.getParameter("receive_email");
		String content = request.getParameter("content");
		
		// DTO��ü ���� -> �Ű����� 3�� ���� �����ڷ� ȣ�� 
		
		MessageDTO dto = new MessageDTO(send_name, receive_email, content);
		
		MessageDAO dao = new MessageDAO();
		int cnt = dao.sendMsg(dto);
		
		if (cnt>0) {
			System.out.println("�޼��� ���� ����");
		}else{
			
		System.out.println("�޼��� ���� ����");
		}
		response.sendRedirect("goMain");
	}
	
}
