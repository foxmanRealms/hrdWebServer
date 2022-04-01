package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

	// �������� ����

	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	int cnt = 0;
	MemberDTO dto =null;

	// DB���� �޼ҵ�
	public void dbconn() {
		try {
			// 1. DB����(ojdbc6.�ڸ�����) C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
			// 1-1. classã�� : DB�� ��Ŭ������ �������ִ� Class

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 1-2. DB�� �����ϱ� ���� �ּ�, ���̵�, �н����� ����

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			// 1-3 Connection��ü ����ؼ� DB����!

			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DB close �޼ҵ�
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

	// ȸ������ �޼ҵ� (��� �����ϴ� )

	public int join(MemberDTO dto) {
		try {
			// db���� �޼ҵ� ȣ��
			dbconn();

			// 2. DB����
			// SQL�� �ۼ�

			String sql = "insert into web_member2 values(?,?,?,?)";

			// sql�� db�� ����
			psmt = conn.prepareStatement(sql);

			// ?�� �� ä���
			psmt.setString(1, dto.getEmail());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getTel());
			psmt.setString(4, dto.getAddress());

			// sql�� ����
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbclose();
		}
		return cnt;

	}

	// ���̵� �ߺ�üũ �޼ҵ�
	public boolean idCheck(String email) {
		// false = �ߺ�X
		boolean result = false;
		try {
			dbconn();

			psmt.setString(1, email);
			rs = psmt.executeQuery();

			// rs.next() : ���� �ִ��� ������ �ľ�
			// : ���� ������ true (�ߺ��� ���̵� �� ��)
			// : ���� ������ false (�ߺ��� ���̵� ���� ��)
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

	// �α��� �޼ҵ�
	public MemberDTO login(String email,String pw) {
		dbconn();
		try {
			//�α��� = ����ڰ� �Է��� email,pw�� �ִ��� ������ Ȯ��, �ʿ��� �� �ҷ�����
			String sql="select * from web_member2 where email=? and pw=?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, email);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			////// rs.next �� Ŀ���� ��ġ�� ���ؼ� ���� �ִ��� �Ǵ����ش�. �ø��� ������
			if(rs.next()) {
				email = rs.getString(1);
				pw = rs.getString(2);
				String tel = rs.getString(3);
				String address = rs.getString(4);
				
				//������ 
				dto = new MemberDTO (email,pw,tel,address);
					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbclose();
		}return dto;
	}

	// ȸ���������� �޼ҵ�
	public int update(MemberDTO dto) {
		dbconn();
		try {
			String sql="update web_member2 set pw=?,tel=?,address=? where email=?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getPw());
			psmt.setString(2, dto.getTel());
			psmt.setString(3, dto.getAddress());
			psmt.setString(4, dto.getEmail());
			
			cnt = psmt.executeUpdate();   ///// int ������ ��ȯ�Ѵ�. �۾��� ���� ���ڴ�  
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbclose();
		} return cnt;
		
	}
	
	// ȸ������ �޼ҵ�
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