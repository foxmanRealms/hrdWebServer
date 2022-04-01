package Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import inter.Command;

public class LogoutService implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextpage="";
		 
		System.out.println("[LogoutServiceCon]");
		
		// 로그아웃 이란 -> 로그인한 정보삭제 == session삭제
		
		HttpSession session = request.getSession();
		
//		// 1. 세션 삭제          -> 세션종료
//		session.invalidate();   ////// 모든 세션을 다 종료시킨다
		
		// 2. 세션 삭제        -> 특정한 세션만 종료시킨다. 
		session.removeAttribute("info");  
		
		System.out.println("로그아웃 성공");
		
		nextpage = "goMain";
		
		
		return nextpage;
	}

}
