package kr.co.smhrd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex01Request")
//������ ������ ã�� ���ڿ� : URL ����

public class ex01Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request��ü : ������� ��û�� ���� ������ ��� �ִ� ��ü
		//					���� - �����ϴ� ip�ּ�, ������, ��Ű, ... ��� 
		
		// request.getRemoteAddr();  Ŭ���̾�Ʈ ip�ּҸ� �������� ���
		String ip = request.getRemoteAddr();
		System.out.println(ip);
	
		response.setContentType("text/html;charset=euc-kr");
		
		PrintWriter out=response.getWriter();
		// localhost
		// 0:0:0:0:0:0:0:1
		//  172.30.1.54
		
		// �ǽ�! �� ip�ּҸ� "���Դϴ�!"
		// ���� ip�ּҸ� "�츮�� ȯ���մϴ�!"
		// ������ ip�ּҸ� "������ ȯ���մϴ�!"
		
		
		
		if (ip.equals("220.80.165.124") ) {
			//System.out.println("���Դϴ�!");
			out.println("���Դϴ�!");
			
		}else if (ip.equals("59.0.129.176") ) {
			//System.out.println("������ ȯ���մϴ�!");
			out.println("������ ȯ���մϴ�!");
		}else if (ip.equals("121.147.0.169") ) {
		//	System.out.println("�αپ� ȯ���մϴ�!");
			out.println("�αپ� ȯ���մϴ�!");
		}else if (ip.equals("220.71.97.140") ) {
		//	System.out.println("���뾾 ȯ���մϴ�!");
			out.println("���뾾 ȯ���մϴ�!");
		}else if (ip.equals("211.228.61.214") ) {
		//	System.out.println("������ ȯ���մϴ�!");
			out.println("������ ȯ���մϴ�!");
		}else if (ip.equals("59.0.234.242") ) {
		//	System.out.println("������ ȯ���մϴ�!");
			out.println("������ ȯ���մϴ�!");
		}
		
		
		
		
		
		
	}

}
