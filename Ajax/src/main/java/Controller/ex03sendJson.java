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
      
      // json 타입의 데이터 쉽게 쓸 수 있도록 DTO생성
      String json = request.getParameter("json");
      
      // Gson 객체 생성
      Gson gson = new Gson();
      
      // String -> 객체 형태로
      // gson.fromJson(데이터, 저장할 변수의 클래스 정보)
      // CalendarDTO[title, start, end] 배열로
      CalendarDTO[] list = gson.fromJson(json, CalendarDTO[].class);
      
      for(int i = 0; i < list.length; i++) {
         System.out.println(list[i].getTitle());
         System.out.println(list[i].getStart());
         System.out.println(list[i].getEnd());
         System.out.println("====== 구분선 ======");
      }
      
   }

}