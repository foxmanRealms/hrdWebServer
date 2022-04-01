package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MemberDAO;
import Model.MemberDTO;

@WebServlet("/JoinServiceCon")
public class JoinServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[JoinServiceCon]");

		// 1. post방식 인코딩
		request.setCharacterEncoding("utf-8");

		// 2. 회원가입 데이터 받아오기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		System.out.println("email : " + email);
		System.out.println("pw : " + pw);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);
	
		// 3. 데이터 DTO로 묶기
		MemberDTO dto = new MemberDTO(email, pw, tel, address);

		// 4. DB연결할 DAO호출

		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(dto);
		// 세션 선언
		HttpSession session = request.getSession();
		
		System.out.println("여기까지 실행");
		// 5. 실행결과 확인
		if (cnt > 0) {
			System.out.println("-- 회원가입성공");
			
			// email session으로 만들기!
			session.setAttribute(address, session);
			
			response.sendRedirect("join_success.jsp");
		} else {
			System.out.println("-- 회원가입실패");
			response.sendRedirect("goMain");
		}
	}
}
