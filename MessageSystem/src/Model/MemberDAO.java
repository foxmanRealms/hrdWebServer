package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

	// 전역변수 선언

	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	int cnt = 0;
	MemberDTO dto =null;

	// DB연결 메소드
	public void dbconn() {
		try {
			// 1. DB연결(ojdbc6.자르파일) C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
			// 1-1. class찾기 : DB와 이클립스를 연결해주는 Class

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 1-2. DB에 접속하기 위한 주소, 아이디, 패스워드 지정

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			// 1-3 Connection객체 사용해서 DB연결!

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

	// 회원가입 메소드 (디비에 저장하는 )

	public int join(MemberDTO dto) {
		try {
			// db연결 메소드 호출
			dbconn();

			// 2. DB실행
			// SQL문 작성

			String sql = "insert into web_member2 values(?,?,?,?)";

			// sql문 db에 전달
			psmt = conn.prepareStatement(sql);

			// ?에 값 채우기
			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getTel());
			psmt.setString(4, dto.getAddress());

			// sql문 실행
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbclose();
		}
		return cnt;

	}

	// 아이디 중복체크 메소드
	public boolean idCheck(String email) {
		// false = 중복X
		boolean result = false;
		try {
			dbconn();

			psmt.setString(1, email);
			rs = psmt.executeQuery();

			// rs.next() : 값이 있는지 없는지 파악
			// : 값이 있으면 true (중복된 아이디 일 때)
			// : 값이 없으면 false (중복된 아이디가 없을 때)
			if (rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbclose();
		}
		return result;
	}

	// 로그인 메소드
	public MemberDTO login(String email,String pw) {
		dbconn();
		try {
			//로그인 = 사용자가 입력한 email,pw가 있는지 없는지 확인, 필요한 값 불러오기
			String sql="select * from web_member2 where email=? and pw=?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, email);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			////// rs.next 는 커서의 위치를 통해서 값이 있는지 판단해준다. 올리고 내리고
			if(rs.next()) {
				email = rs.getString(1);
				pw = rs.getString(2);
				String tel = rs.getString(3);
				String address = rs.getString(4);
				
				//실행결과 
				dto = new MemberDTO (email,pw,tel,address);
					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbclose();
		}return dto;
	}

	// 회원정보수정 메소드
	public int update(MemberDTO dto) {
		dbconn();
		try {
			String sql="update web_member2 set pw=?,tel=?,address=? where email=?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getPw());
			psmt.setString(2, dto.getTel());
			psmt.setString(3, dto.getAddress());
			psmt.setString(4, dto.getEmail());
			
			cnt = psmt.executeUpdate();   ///// int 값으로 반환한다. 작업된 행의 숫자다  
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbclose();
		} return cnt;
		
	}
	
	// 회원삭제 메소드
	public int delete(String email) {
		dbconn();
		try {
			String sql = "delete from web_member2 where email=?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, email);
			
			cnt = psmt.executeUpdate();
		
			
		} catch (Exception e) {
			 e.printStackTrace();
		}finally {
			dbclose();
		}
		
		return cnt;
	}
	
	
	
}