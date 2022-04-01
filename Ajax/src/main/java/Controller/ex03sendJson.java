package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.CalendarDTO;

@WebServlet("/ex03sendJson")
public class ex03sendJson extends HttpServlet {
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      // json Ÿ���� ������ ���� �� �� �ֵ��� DTO����
      String json = request.getParameter("json");
      
      // Gson ��ü ����
      Gson gson = new Gson();
      
      // String -> ��ü ���·�
      // gson.fromJson(������, ������ ������ Ŭ���� ����)
      // CalendarDTO[title, start, end] �迭��
      CalendarDTO[] list = gson.fromJson(json, CalendarDTO[].class);
      
      for(int i = 0; i < list.length; i++) {
         System.out.println(list[i].getTitle());
         System.out.println(list[i].getStart());
         System.out.println(list[i].getEnd());
         System.out.println("====== ���м� ======");
      }
      
   }

}