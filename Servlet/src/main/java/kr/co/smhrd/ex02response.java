package kr.co.smhrd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/response")
public class ex02response extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// response ��ü : ����ڿ��� ������ ���ִ� ��ü
			//				�� ) HTML���� ����, ������ �̵�
		
		// 1.���ڵ�, � ������ �����͸� ��������
		response.setContentType("text/html;charset=euc-kr");
		// ���ڵ� : ��ǻ�Ͱ� ������ �� �ֵ��� ��ȣȭ (<->���ڵ�)
		// �ѱ� ���ڵ� �ϴ� ��� : euc-kr, utf-8
		
		//2. ��� ��Ʈ��
		// �ڹ� Scanner
		// PrintWriter
		PrintWriter out=response.getWriter();
		out.print("");
		out.print("<body>�ȳ��ϼ���!</body></html>");

	}

}
