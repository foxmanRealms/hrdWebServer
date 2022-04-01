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
			// post 방식 인코딩
			request.setCharacterEncoding("UTF-8");
			
			// MultipartRequest 객체의 매개변수 정리   웹컨텐츠 이하의 폴더를 이용한다   여기에서는 file 폴더
			// savePath : 파일의 저장 경로
			// 서블릿 실행 위치 : WebContent
			// getServletContext : 요청들어온 서블릿의 정보
			// getRealPath("찾아가고싶은 파일의 상대경로") : 서블릿의 절대경로
			String savePath = request.getServletContext().getRealPath("./file");  ///// 리얼패스까지는 절대경로이고, () 안쪽은 상대경로다
			System.out.println(savePath);
			
			// maxsize : 이미지의 최대크기 지정   서버자원낭비를 줄이기 위해서 
			int maxsize = 10 *1024*1024; // 10MB
			// 1 mb = 1024 kb
			// 1 kb = 1024 byte 
			
			// encoding: 인코딩방식
			String encoding = "UTF-8";
			
			// filePolicy : 파일이름 중복제거(파일명이 겹칠 때 숫자를 증가하게 해서 중복제거하는 객체)
			DefaultFileRenamePolicy filePolicy = new DefaultFileRenamePolicy();
			
			MultipartRequest multi = new MultipartRequest(request, savePath, maxsize, encoding, filePolicy );
			
			// 데이터 꺼내오기   디비에 저장해야 되기 때문에 이하의 처리를 한다. 
			
			String title= multi.getParameter("title");
			String writer= multi.getParameter("writer");
			//파일 이름에 한글이 있으면 인코딩(문자 -> 코드 )   ,파일이름에 공백없이 가져오기!
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
				System.out.println("파일업로드 성공");
			} else {
				System.out.println("파일업로드 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "boardMain.jsp";
	}

}
