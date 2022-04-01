package Service;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Model.BoardDAO;
import Model.BoardDTO;
import inter.Command;

public class WriteBoardService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			// post ��� ���ڵ�
			request.setCharacterEncoding("UTF-8");
			
			// MultipartRequest ��ü�� �Ű����� ����   �������� ������ ������ �̿��Ѵ�   ���⿡���� file ����
			// savePath : ������ ���� ���
			// ���� ���� ��ġ : WebContent
			// getServletContext : ��û���� ������ ����
			// getRealPath("ã�ư������ ������ �����") : ������ ������
			String savePath = request.getServletContext().getRealPath("./file");  ///// �����н������� �������̰�, () ������ ����δ�
			System.out.println(savePath);
			
			// maxsize : �̹����� �ִ�ũ�� ����   �����ڿ����� ���̱� ���ؼ� 
			int maxsize = 10 *1024*1024; // 10MB
			// 1 mb = 1024 kb
			// 1 kb = 1024 byte 
			
			// encoding: ���ڵ����
			String encoding = "UTF-8";
			
			// filePolicy : �����̸� �ߺ�����(���ϸ��� ��ĥ �� ���ڸ� �����ϰ� �ؼ� �ߺ������ϴ� ��ü)
			DefaultFileRenamePolicy filePolicy = new DefaultFileRenamePolicy();
			
			MultipartRequest multi = new MultipartRequest(request, savePath, maxsize, encoding, filePolicy );
			
			// ������ ��������   ��� �����ؾ� �Ǳ� ������ ������ ó���� �Ѵ�. 
			
			String title= multi.getParameter("title");
			String writer= multi.getParameter("writer");
			//���� �̸��� �ѱ��� ������ ���ڵ�(���� -> �ڵ� )   ,�����̸��� ������� ��������!
			String fileName = "";
			if(multi.getFilesystemName("fileName") != null) {
				fileName = URLEncoder.encode(multi.getFilesystemName("fileName"), "UTF-8" ) ;
				
			}
			
//			String fileName =multi.getFilesystemName("fileName") ;
			String content= multi.getParameter("content");
			
			System.out.println("title : "+title);
			System.out.println("writer : "+writer);
			System.out.println("fileName : "+fileName);
			System.out.println("content : "+content);
			
			BoardDTO dto = new BoardDTO(0,title,writer,fileName,content,"");
			int cnt = new BoardDAO().insertBoard(dto);
			
			if (cnt>0) {
				System.out.println("���Ͼ��ε� ����");
			} else {
				System.out.println("���Ͼ��ε� ����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "boardMain.jsp";
	}

}
