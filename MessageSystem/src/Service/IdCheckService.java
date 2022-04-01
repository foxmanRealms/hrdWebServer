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
		// 아이디 중복체크 기능
		System.out.println("[IdCheckServiceCon]");

		// 아이디중복체크 버튼을 눌렀을 때 ajax로 보낸 email 값 받아오기

		String email = request.getParameter("email");
		System.out.println("email : " + email);

		// 아이디 중복체크 메소드 호출하기
		// MemberDAO dao = new MemberDAO();
		// boolean result2 = dao.idCheck(email);

		boolean result = new MemberDAO().idCheck(email);

		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
		// response.getWriter().print(result);
		// 아이디 중복체크 마지막줄

		return null;
	}

}
