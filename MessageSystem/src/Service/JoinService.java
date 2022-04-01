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

	// 1. Command 인터페이스 구현
	
	// 2. 인터페이스에 있는 execute()메소드 오버라이딩
	// 자동완성 -> 편리함
	

	// 3. 페이지 이동 response... -> 삭제
	//       String nextpage="이동할 주소"
	// 4. 메소드 return 값으로 nextpage 
	
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextpage="";
		
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
			session.setAttribute("email", email);
			
			nextpage = "join_success.jsp";
		} else {
			System.out.println("-- 회원가입실패");
			nextpage = "goMain";
		}	// 회원가입 마지막줄
		
		
		
		
		return nextpage;
	}
	
	
	
	
}
