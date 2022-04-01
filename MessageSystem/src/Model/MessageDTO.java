package Model;

public class MessageDTO {

	//필드명 선언할 때 테이블 컬럼명과 같아야 좋다 
	
	private int num;
	private String send_name;
	private String receive_email;
	private String content;

	private String sendDate;     ////// 날짜를 연산할 일이 없기때문에 스트링처리를하였다. 연산이 필요하면 다르게 받아야한다

	public MessageDTO(int num, String send_name, String receive_email, String content, String sendDate) {
		super();
		this.num = num;
		this.send_name = send_name;
		this.receive_email = receive_email;
		this.content = content;
		this.sendDate = sendDate;
	}

	public MessageDTO(String send_name, String receive_email, String content) {
		super();
		this.send_name = send_name;
		this.receive_email = receive_email;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSend_name() {
		return send_name;
	}

	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	public String getReceive_email() {
		return receive_email;
	}

	public void setReceive_email(String receive_email) {
		this.receive_email = receive_email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	
}
