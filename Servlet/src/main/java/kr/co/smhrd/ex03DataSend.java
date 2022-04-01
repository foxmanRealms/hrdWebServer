package kr.co.smhrd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex03DataSend")
public class ex03DataSend extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get방식으로 데이터 전송 -> 설정에서 인코딩 해줘야 한다.
		// post 방식
		//request.setCharacterEncoding("euc-kr");
		
		
		// getParameter("name 속성값");
		String data = request.getParameter("data");
			////// name값을 넣어줘야한다.
		System.out.println(data);
	}

}
