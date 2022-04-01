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

//.do로 끝나는 문자열 맵핑값을 다 포함 시킴 
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// FrontController Pattern
		// 1. 모든 요청을 하나의 servlet으로 정의하는 패턴
		// 2. 중복되는 코드를 줄일 수 있고, 보안을 적용할 때 하나의 servlet에서 적용할 수 있다.
		
		System.out.println("frontController 실행 ");
		String nextpage="";
		Command com = null;
		
		// 어떤 기능을 수행하는 문자열인지 판단
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String path = request.getContextPath();
		System.out.println(path);
		
		String command = uri.substring(path.length()+1);
		System.out.println(command);
		
		if(command.equals("loginServiceCon.do")) {
			// 여러객체를 불러올 필요 없이
			// 부모 클래스가 가지고 있는 메소드를
			// 하위 클래스가 재정의(오버라이딩)
			
			// 로그인 기능 
			com = new LoginService();
			nextpage = com.execute(request, response);
			
			
			// 로그인 기능 마지막
			
		} else if(command.equals("JoinServiceCon.do")) {
			// 회원가입 기능
			
			// 
			
			com = new JoinService();
			nextpage = com.execute(request, response);
			
			
			// 회원가입 마지막 
		} else if(command.equals("MsgCon.do")) {
			// 메세지 기능
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
				// 메시지 기능 마지막 
			
			
		} else if(command.equals("LogoutServiceCon.do")) {
			// 로그아웃 기능
			
			com = new LogoutService();
			nextpage = com.execute(request, response);
				// 로그아웃 기능 마지막 
			
		} else if(command.equals("IdCheckServiceCon.do")) {
			// 아이디 중복체크 기능
			com = new IdCheckService();
			nextpage = com.execute(request, response);
		
			// 중복체크 기능 마지막
		} else if(command.equals("UpdateServiceCon.do")) {
			// 회원정보 수정 기능
			// update.jsp 수정
			
			com = new UpdateService();
			nextpage = com.execute(request, response);
				// 정보수정기능 마지막 
			
		} else if(command.equals("DeleteServiceCon.do")) {
			// 회원정보 삭제 기능 
			// select.jsp 수정 
			com = new DeleteService();
			nextpage = com.execute(request, response);
			/// 회원삭제기능 마지막
		
		} else if(command.equals("WriteBoardSerivce.do")) {
			// 게시판 기능 
			com = new WriteBoardService();
			nextpage = com.execute(request, response);
			/// 게시판 마지막
		
		}// else if 마지막 줄
		
			if(nextpage!=null) {
			response.sendRedirect(nextpage);
		
	} 
		 
		
		}// service 메소드
		
	} 


