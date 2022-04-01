package Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Inter.Command;
import Model.UserDAO;
import Model.UserDTO;

public class LoginService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("[LoginServiceCon.do]");
		
		request.setCharacterEncoding("utf-8");
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		UserDTO udto = new UserDAO().login(user_id, user_pw);
		
		if(udto != null) {
			System.out.println("로그인 성공!");
			
			HttpSession session = request.getSession();
			session.setAttribute("udto", udto);
			
		}else {
			System.out.println("로그인 실패!");
			
		}
		
		String nextpage = "Index.jsp";
		return nextpage;
	}
	

}
