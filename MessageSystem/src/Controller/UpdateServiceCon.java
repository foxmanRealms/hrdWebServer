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

@WebServlet("/UpdateServiceCon")
public class UpdateServiceCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("[UpdateServiceCon]");
		
		 // post방식 인코딩
		 request.setCharacterEncoding("euc-kr");
		 
		 // 값 4개
		 
		 String email = request.getParameter("email");
		 String pw = request.getParameter("pw");
		 String tel = request.getParameter("tel");
		 String address = request.getParameter("address");
		 
		 System.out.println("email : "+ email);
		 System.out.println("pw : "+ pw);
		 System.out.println("tel : "+ tel);
		 System.out.println("address : "+ address);
		 
		 MemberDTO dto=new MemberDTO(email,pw,tel,address);
//		 MemberDAO dao=new MemberDAO();
//		 dao.update(dto);        
		 
		 
		// int cnt =  new MemberDAO().update(new MemberDTO(email,pw,tel,address));   ////// 위 3줄과 똑같은 의미이다 
		int cnt =  new MemberDAO().update(dto);   ////// 위 3줄과 똑같은 의미이다 
		 
		if (cnt>0) {
			System.out.println("-- 회원정보 수정 성공");
		
			// 성공시 session에 새로운 정보로 update
			HttpSession session = request.getSession();
			session.setAttribute("info", dto);
		}else {
			System.out.println("--회원정보수정 실패");
		}
		response.sendRedirect("goMain");
		
		
	}

}
