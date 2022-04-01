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
		
		// �α׾ƿ� �̶� -> �α����� �������� == session����
		
		HttpSession session = request.getSession();
		
//		// 1. ���� ����          -> ��������
//		session.invalidate();   ////// ��� ������ �� �����Ų��
		
		// 2. ���� ����        -> Ư���� ���Ǹ� �����Ų��. 
		session.removeAttribute("info");  
		
		System.out.println("�α׾ƿ� ����");
		
		nextpage = "goMain";
		
		
		return nextpage;
	}

}
