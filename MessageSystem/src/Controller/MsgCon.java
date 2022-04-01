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
		 
		// post방식 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터 수집
		String send_name = request.getParameter("send_name");
		String receive_email = request.getParameter("receive_email");
		String content = request.getParameter("content");
		
		// DTO객체 생성 -> 매개변수 3개 담은 생성자로 호출 
		
		MessageDTO dto = new MessageDTO(send_name, receive_email, content);
		
		MessageDAO dao = new MessageDAO();
		int cnt = dao.sendMsg(dto);
		
		if (cnt>0) {
			System.out.println("메세지 전송 성공");
		}else{
			
		System.out.println("메세지 전송 실패");
		}
		response.sendRedirect("goMain");
	}
	
}
