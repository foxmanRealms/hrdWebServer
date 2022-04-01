package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/carrotList")
public class carrotList extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//1. post방식으로 보낸 데이터 인코딩
		request.setCharacterEncoding("euc-kr");
		
		//2. 파라미터 수집
		// item이라는 name 속성값 지정
		String[] items = request.getParameterValues("item");
		
		//3. 쿠키객체 생성
		// Cookie 변수명 = new Cookie("쿠키 이름","쿠키값");
		//	 쿠키 이름 : item1,2,3...
		//	 쿠키 값 : 받아온 데이터
		//	 쿠키 유효시간 설정 : 10초 정도
		
		if (items !=null) {
			
			for(int i=0 ; i<items.length;i++) {
				// encode 암호화 = 컴퓨터가 이해하는 언어로 변환 
				// URLEncoder.encode(인코딩할 값 , 인코딩방식)
				Cookie cookie =new Cookie("item"+(i+1), URLEncoder.encode( items[i] , "euc-kr" )) ;
				
				cookie.setMaxAge(10);
				//4. 쿠키를 저장하기
				response.addCookie(cookie);
			}
			
			
		} else {
			Cookie cookie = new Cookie("item","");
			
			response.addCookie(cookie);
		}
		
		
		
		
		
	
		
		//5. 쿠키 저장하고 나면 carrot.jsp로 이동
		// sendRedirect()
		response.sendRedirect("carrot.jsp");
		
	}

}
