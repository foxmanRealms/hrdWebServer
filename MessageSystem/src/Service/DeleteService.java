package Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Command;
import Model.MemberDAO;

public class DeleteService implements Command{
   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
   
      String email = request.getParameter("email");
      
      MemberDAO dao = new MemberDAO();
      int cnt = dao.delete(email);
      
      if(cnt>0) {
         response.sendRedirect("select.jsp");
         System.out.println("삭제 성공");
      }else {
         response.sendRedirect("select.jsp");
         System.out.println("삭제 실패");
      }
      
      String nextpage = "select.jsp";
      
      return nextpage;
   }
}