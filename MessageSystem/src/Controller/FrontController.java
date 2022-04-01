package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MessageDAO;
import Model.MessageDTO;
import Service.DeleteService;
import Service.IdCheckService;
import Service.JoinService;
import Service.LoginService;
import Service.LogoutService;
import Service.UpdateService;
import Service.WriteBoardService;
import inter.Command;

//.do�� ������ ���ڿ� ���ΰ��� �� ���� ��Ŵ 
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// FrontController Pattern
		// 1. ��� ��û�� �ϳ��� servlet���� �����ϴ� ����
		// 2. �ߺ��Ǵ� �ڵ带 ���� �� �ְ�, ������ ������ �� �ϳ��� servlet���� ������ �� �ִ�.
		
		System.out.println("frontController ���� ");
		String nextpage="";
		Command com = null;
		
		// � ����� �����ϴ� ���ڿ����� �Ǵ�
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String path = request.getContextPath();
		System.out.println(path);
		
		String command = uri.substring(path.length()+1);
		System.out.println(command);
		
		if(command.equals("loginServiceCon.do")) {
			// ������ü�� �ҷ��� �ʿ� ����
			// �θ� Ŭ������ ������ �ִ� �޼ҵ带
			// ���� Ŭ������ ������(�������̵�)
			
			// �α��� ��� 
			com = new LoginService();
			nextpage = com.execute(request, response);
			
			
			// �α��� ��� ������
			
		} else if(command.equals("JoinServiceCon.do")) {
			// ȸ������ ���
			
			// 
			
			com = new JoinService();
			nextpage = com.execute(request, response);
			
			
			// ȸ������ ������ 
		} else if(command.equals("MsgCon.do")) {
			// �޼��� ���
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
				// �޽��� ��� ������ 
			
			
		} else if(command.equals("LogoutServiceCon.do")) {
			// �α׾ƿ� ���
			
			com = new LogoutService();
			nextpage = com.execute(request, response);
				// �α׾ƿ� ��� ������ 
			
		} else if(command.equals("IdCheckServiceCon.do")) {
			// ���̵� �ߺ�üũ ���
			com = new IdCheckService();
			nextpage = com.execute(request, response);
		
			// �ߺ�üũ ��� ������
		} else if(command.equals("UpdateServiceCon.do")) {
			// ȸ������ ���� ���
			// update.jsp ����
			
			com = new UpdateService();
			nextpage = com.execute(request, response);
				// ����������� ������ 
			
		} else if(command.equals("DeleteServiceCon.do")) {
			// ȸ������ ���� ��� 
			// select.jsp ���� 
			com = new DeleteService();
			nextpage = com.execute(request, response);
			/// ȸ��������� ������
		
		} else if(command.equals("WriteBoardSerivce.do")) {
			// �Խ��� ��� 
			com = new WriteBoardService();
			nextpage = com.execute(request, response);
			/// �Խ��� ������
		
		}// else if ������ ��
		
			if(nextpage!=null) {
			response.sendRedirect(nextpage);
		
	} 
		 
		
		}// service �޼ҵ�
		
	} 


