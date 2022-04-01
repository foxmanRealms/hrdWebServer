package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	// �������� ����
	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	int cnt = 0;
	String sql = null;
	UserDTO udto = null;
	
	// DB ���� �޼ҵ�
	public void dbConn() {
		try {
			// 1. DB����(ojdbc6.jar �־��ֱ�)
			// 1-1. Classã�� : DB�� ��Ŭ������ �������ִ� Class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 1-2. DB�� �����ϱ� ���� �ּ�, ���̵�, �н����� ����
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";
			
			// 1-3. Connection ��ü ����ؼ� DB����!
			conn = DriverManager.getConnection(url, db_id, db_pw);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	// DB close �޼ҵ�
	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// ȸ������ �޼ҵ�
/*	
CREATE TABLE t_user
	(
	    user_id           VARCHAR2(30)    NOT NULL, 
	    user_pw           VARCHAR2(30)    NOT NULL, 
	    user_type         CHAR(1)         NOT NULL, 
	    user_company      VARCHAR2(30),
	    user_com_tel      VARCHAR2(30),
	    user_license      VARCHAR2(30),
	    user_name         VARCHAR2(30)    NOT NULL, 
	    user_birthdate    DATE            NOT NULL, 
	    user_gender       CHAR(1)         NOT NULL, 
	    user_phone        VARCHAR2(30)    NOT NULL, 
	    user_region       VARCHAR2(30)    NOT NULL, 
	    user_joindate     DATE            DEFAULT SYSDATE NOT NULL, 
	     PRIMARY KEY (user_id)
	);
*/
	
	// ȸ������ : ������ 0
	public int join0(UserDTO udto) {
		dbConn();
		
		try {
			sql = "insert into t_user values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, udto.getUser_id());
			psmt.setString(2, udto.getUser_pw());
			psmt.setString(3, String.valueOf(udto.getUser_type())); 
			psmt.setString(4, udto.getUser_company());
			psmt.setString(5, udto.getUser_com_tel());
			psmt.setString(6, udto.getUser_license());
			psmt.setString(7, udto.getUser_name());
			psmt.setString(8, udto.getUser_birthdate());
			psmt.setString(9, String.valueOf(udto.getUser_gender()));
			psmt.setString(10, udto.getUser_phone());
			psmt.setString(11, udto.getUser_region());
				
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
			
		}return cnt;
	}
	
	
	// ȸ������ : ��ȣ�� 1
	public int join1(UserDTO udto) {
		dbConn();
		
		try {
			sql = "insert into t_user values(?, ?, ?, null, null, null, ?, ?, ?, ?, ?, sysdate)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, udto.getUser_id());
			psmt.setString(2, udto.getUser_pw());
			psmt.setString(3, String.valueOf(udto.getUser_type())); 
			psmt.setString(4, udto.getUser_name());
			psmt.setString(5, udto.getUser_birthdate());
			psmt.setString(6, String.valueOf(udto.getUser_gender()));
			psmt.setString(7, udto.getUser_phone());
			psmt.setString(8, udto.getUser_region());
				
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
			
		}return cnt;
	}
	
	// ���̵� �ߺ� Ȯ�� �޼ҵ�
	public boolean idCheck(String user_id) {
		dbConn();
		
		// false�� �ߺ� X
		boolean result = false; 
		
		try {
			sql = "select user_id from t_user where user_id = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			rs = psmt.executeQuery();
			
			// rs.next() : ���� �ִ��� ������ �ľ�
			// ���� ������ true(-> �ߺ��� ���̵��� ��)
			// ���� ������ false(-> �ߺ��� ���̵� ���� ��)
			if(rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		} return result;
	}
	
	
	// �α��� �޼ҵ�
	public UserDTO login(String user_id, String user_pw) {
		dbConn();
		
		try {
			sql = "select * from t_user where user_id = ? and user_pw = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			psmt.setString(2, user_pw);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				user_id = rs.getString(1);
				user_pw = rs.getString(2);
				char user_type = (rs.getString(3)).charAt(0);
				String user_company = rs.getString(4);
				String user_com_tel = rs.getString(5);
				String user_license = rs.getString(6);
				String user_name = rs.getString(7);
				String user_birthdate = rs.getString(8);
				char user_gender = (rs.getString(9)).charAt(0);
				String user_phone = rs.getString(10);
				String user_region = rs.getString(11);
				String user_joindate = rs.getString(12);
				
				udto = new UserDTO(user_id, user_pw, user_type, user_company, user_com_tel, user_license, 
						user_name, user_birthdate, user_gender, user_phone, user_region);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		} return udto;
	}
	
	
	// ��й�ȣ ���� �޼ҵ�
	public int editPw(String user_id, String user_pw) {
		dbConn();
		
		try {
			sql = "update t_user set user_pw = ? where user_id = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_pw);
			psmt.setString(2, user_id);
			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		} return cnt;
	}

	
}
