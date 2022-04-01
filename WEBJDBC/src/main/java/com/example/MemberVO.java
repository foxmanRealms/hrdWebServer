package com.example;

public class MemberVO {

   //�ܺο��� �ʵ尪 �����Ҷ� getter,setter���ؼ� �����ϵ���
   //private ���������ڸ� ���
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

   
   //��ü�� ����� �ʵ尪���� ����ؼ� Ȯ���ϴ� �뵵
   @Override
   public String toString() {
      return "MemberVO [id=" + id + ", pw=" + pw + ", nick=" + nick + "]";
   }
   
}