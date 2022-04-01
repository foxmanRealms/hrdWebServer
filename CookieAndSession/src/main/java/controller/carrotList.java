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
		
		
		//1. post������� ���� ������ ���ڵ�
		request.setCharacterEncoding("euc-kr");
		
		//2. �Ķ���� ����
		// item�̶�� name �Ӽ��� ����
		String[] items = request.getParameterValues("item");
		
		//3. ��Ű��ü ����
		// Cookie ������ = new Cookie("��Ű �̸�","��Ű��");
		//	 ��Ű �̸� : item1,2,3...
		//	 ��Ű �� : �޾ƿ� ������
		//	 ��Ű ��ȿ�ð� ���� : 10�� ����
		
		if (items !=null) {
			
			for(int i=0 ; i<items.length;i++) {
				// encode ��ȣȭ = ��ǻ�Ͱ� �����ϴ� ���� ��ȯ 
				// URLEncoder.encode(���ڵ��� �� , ���ڵ����)
				Cookie cookie =new Cookie("item"+(i+1), URLEncoder.encode( items[i] , "euc-kr" )) ;
				
				cookie.setMaxAge(10);
				//4. ��Ű�� �����ϱ�
				response.addCookie(cookie);
			}
			
			
		} else {
			Cookie cookie = new Cookie("item","");
			
			response.addCookie(cookie);
		}
		
		
		
		
		
	
		
		//5. ��Ű �����ϰ� ���� carrot.jsp�� �̵�
		// sendRedirect()
		response.sendRedirect("carrot.jsp");
		
	}

}
