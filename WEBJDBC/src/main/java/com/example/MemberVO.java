package com.example;

public class MemberVO {

   //외부에서 필드값 접근할때 getter,setter통해서 접근하도록
   //private 접근제한자를 사용
   private String id;
   private String pw;
   private String nick;
   
   
   public MemberVO(String id, String pw) {
      super();
      this.id = id;
      this.pw = pw;
   }

   public MemberVO(String id, String pw, String nick) {
      super();
      this.id = id;
      this.pw = pw;
      this.nick = nick;
   }
   
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPw() {
      return pw;
   }
   public void setPw(String pw) {
      this.pw = pw;
   }
   public String getNick() {
      return nick;
   }
   public void setNick(String nick) {
      this.nick = nick;
   }

   
   //객체에 저장된 필드값들을 출력해서 확인하는 용도
   @Override
   public String toString() {
      return "MemberVO [id=" + id + ", pw=" + pw + ", nick=" + nick + "]";
   }
   
}