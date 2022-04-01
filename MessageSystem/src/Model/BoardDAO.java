package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {

   // 전역변수 선언
   PreparedStatement psmt = null;
   Connection conn = null;
   ResultSet rs = null;
   int cnt = 0;

   // DB연결 메소드
   public void dbconn() {
      try {
         // 1. DB연결(ojdbc6.jar 넣어주기)
         // 1-1. Class찾기 : DB와 이클립스를 연결해주는 Class
         Class.forName("oracle.jdbc.driver.OracleDriver");

         // 1-2. DB에 접속하기 위한 주소, 아이디, 패스워드 지정
         String url = "jdbc:oracle:thin:@localhost:1521:xe";
         String dbid = "hr";
         String dbpw = "hr";

         // 1-3. Connection객체 사용해서 DB연결!
         conn = DriverManager.getConnection(url, dbid, dbpw);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   // DB close 메소드
   public void dbclose() {
      try {
         if (rs != null)
            rs.close();
         if (psmt != null)
            psmt.close();
         if (conn != null)
            conn.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   // 게시글 작성 메소드
   public int insertBoard(BoardDTO dto) {
	dbconn();
	try {
		String sql="insert into web_board values(board_num.nextval,?,?,?,?,sysdate)";
		
		psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,dto.getTitle());
		psmt.setString(2,dto.getWriter());
		psmt.setString(3,dto.getTitle());
		psmt.setString(4,dto.getTitle());
		
		cnt = psmt.executeUpdate();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		dbclose();
	}return cnt;
	
	
}
   
   // 게시글 목록 조회 메소드
   public ArrayList<BoardDTO> showBoard() {
	   ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
	   dbconn();
	   try {
		String sql="select * from web_board order by b_day desc";
		
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();	
		
		while(rs.next() ) {
			int num = rs.getInt(1);
			String title = rs.getString(2);
			String writer = rs.getString(3);
			String fileName = rs.getString(4);
			String content = rs.getString(5);
			String b_day = rs.getString(6);
			
			BoardDTO dto = new BoardDTO(num,title, writer,fileName,content,b_day);
			list.add(dto);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		dbclose();
	} return list;
	   
	
}
   
   // 해당 게시글 확인 메소드 
   public BoardDTO boardSelectOne(int num) {
	   BoardDTO dto = null;
	  
	   dbconn();
	   
	   try {
		String sql="select * from web_board where num=?";
		
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, num);
		rs = psmt.executeQuery();	
		
		if (rs.next()) {
			int cnum = rs.getInt(1);
			String title = rs.getString(2);
			String writer = rs.getString(3);
			String fileName = rs.getString(4);
			String content = rs.getString(5);
			String b_day = rs.getString(6);
			
			///// 얻은 데이터를 dto에 담아주어야 한다 
			
			dto =new BoardDTO(cnum, title, writer, fileName, content, b_day);
		} 
		
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		dbclose();
	} return dto;
	   
	
}
}