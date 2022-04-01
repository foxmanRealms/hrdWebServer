package kr.co.smhrd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex01Request")
//실행할 서블릿을 찾는 문자열 : URL 맵핑

public class ex01Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request객체 : 사용자의 요청을 통해 정보를 담고 있는 객체
		//					정보 - 접속하는 ip주소, 데이터, 쿠키, ... 등등 
		
		// request.getRemoteAddr();  클라이언트 ip주소를 가져오는 기능
		String ip = request.getRemoteAddr();
		System.out.println(ip);
	
		response.setContentType("text/html;charset=euc-kr");
		
		PrintWriter out=response.getWriter();
		// localhost
		// 0:0:0:0:0:0:0:1
		//  172.30.1.54
		
		// 실습! 내 ip주소면 "저입니다!"
		// 팀원 ip주소면 "우리팀 환영합니다!"
		// 선생님 ip주소면 "선생님 환영합니다!"
		
		
		
		if (ip.equals("220.80.165.124") ) {
			//System.out.println("저입니다!");
			out.println("저입니다!");
			
		}else if (ip.equals("59.0.129.176") ) {
			//System.out.println("시윤씨 환영합니다!");
			out.println("시윤씨 환영합니다!");
		}else if (ip.equals("121.147.0.169") ) {
		//	System.out.println("민근씨 환영합니다!");
			out.println("민근씨 환영합니다!");
		}else if (ip.equals("220.71.97.140") ) {
		//	System.out.println("정용씨 환영합니다!");
			out.println("정용씨 환영합니다!");
		}else if (ip.equals("211.228.61.214") ) {
		//	System.out.println("진수씨 환영합니다!");
			out.println("진수씨 환영합니다!");
		}else if (ip.equals("59.0.234.242") ) {
		//	System.out.println("선생님 환영합니다!");
			out.println("선생님 환영합니다!");
		}
		
		
		
		
		
		
	}

}
