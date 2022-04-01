package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.MemberDTO;

@WebServlet("/ex02Gson")
public class ex02Gson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DTO�� ��ü�� ���� �־
		// ArrayList�� ���
		// ArrayList -> json �������� ���� 
		
		MemberDTO member1 = new MemberDTO("email1", "010-1111-1111", "���� ����");
		MemberDTO member2 = new MemberDTO("email2", "010-2222-1111", "���� ����");
		MemberDTO member3 = new MemberDTO("email3", "010-3333-1111", "���� ����");
		MemberDTO member4 = new MemberDTO("email4", "010-4444-1111", "���� ���걸");
		
		// ArrayList
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(member1);
		list.add(member2);
		list.add(member3);
		list.add(member4);
		
		
		// ������ ������
		// Gson ��ü ����
		
		Gson gson = new Gson();
		
		// java -> json(���ڿ�)
		// gson�� toJson() -> StringŸ������ Json�� ������ش� 
		String json = gson.toJson(list);
		
		// PrintWriter��ü ���� ���� ���ڵ�
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		
		out.print(json);
	}

}
