package Model;

public class MemberDTO {

	private String email;
	private String pw;
	private String tel;
	private String address;
	
	// 알트 시프트 에스
	// 오른쪽 마우스 >>> 소스
	// 생성자 
	
	
	public MemberDTO(String email, String pw, String tel, String address) {
		super();
		this.email = email;
		this.pw = pw;
		this.tel = tel;
		this.address = address;
	}
	
	// getter setter
	
	public MemberDTO(String email, String tel, String address) {
		super();
		this.email = email;
		this.tel = tel;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
