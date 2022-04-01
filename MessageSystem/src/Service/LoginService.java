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

		// 로그인 기능
		
		System.out.println("[LoginServiceCon]");

		// 1. post방식 인코딩
		request.setCharacterEncoding("utf-8");
		// 2. email.pw 받아오기
		String email = request.getParameter("loginemail");
		String pw = request.getParameter("pw");
		
		// 3. login메소드 호출
		MemberDTO dto= new MemberDAO().login(email,pw);
		
		// 4. 성공실패여부
		if (dto!=null) {
			System.out.println("--로그인 성공");
			System.out.println(dto.getEmail());
			HttpSession session= request.getSession();
			session.setAttribute("info", dto);
		}else {
			System.out.println("--로그인 실패");
		}
		
		String nextpage = "goMain";
		// 로그인기능 마지막줄
		return nextpage;
	}
}
