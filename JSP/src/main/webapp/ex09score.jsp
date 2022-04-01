<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<style>
   tr{
      height: 40px;
      text-align: center;
   }
   table{
      margin: 0 auto;
   }
</style>

<body>
		<%
		// post 방식 인코딩

		// 파라미터 수집
  

		// 평균도 계산하기
		
		// 각 조건에 맞게 학점을 만들기 

		
		
		
		// post 방식 인코딩
		request.setCharacterEncoding("euc-kr");
		
		// 파라미터 수집
		String name =request.getParameter("name");
		
		int java = Integer.parseInt( request.getParameter("java") );
		int web = Integer.parseInt( request.getParameter("web") );
		int iot = Integer.parseInt( request.getParameter("iot") );
		int and = Integer.parseInt( request.getParameter("and") );
		
		// 평균도 계산하기
		
		double avg = (java+web+iot+and)/4;
		
		
		// 각 조건에 맞게 학점을 만들기 
		
		String score ="";
		if(avg >=95){
			score="A+";
		}else if(avg >=90){
			score="A";
		}else if(avg >=85){
			score="B+";
		}else if(avg >=80){
			score="B";
		}else {
			score="F";
		}
		
		
		%>

<fieldset>
         <legend>성적확인프로그램</legend>
         <table width="500">   
            <tr>
               <td>이름</td>
               <td><%= name %></td>
            </tr>
            <tr>
               <td>JAVA점수</td>
               <td><%= java %></td>
            </tr>
            <tr>
               <td>WEB점수</td>
               <td><%= web %></td>
            </tr>
               <tr>
               <td>IOT점수</td>
               <td><%= iot %></td>
            </tr>      
            <tr>
               <td>ANDROID점수</td>
               <td><%= and %></td>
            </tr>      
            <tr>
               <td> 평균 </td>
               <td> <%=avg %></td>
            </tr>
            <tr>
               <td> 학점 </td>
               <td> <%=score %></td>
            </tr>                                                                                                         
         </table>
      </fieldset>


</body>
</html>