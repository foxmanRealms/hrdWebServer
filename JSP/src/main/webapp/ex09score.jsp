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
		// post ��� ���ڵ�

		// �Ķ���� ����
  

		// ��յ� ����ϱ�
		
		// �� ���ǿ� �°� ������ ����� 

		
		
		
		// post ��� ���ڵ�
		request.setCharacterEncoding("euc-kr");
		
		// �Ķ���� ����
		String name =request.getParameter("name");
		
		int java = Integer.parseInt( request.getParameter("java") );
		int web = Integer.parseInt( request.getParameter("web") );
		int iot = Integer.parseInt( request.getParameter("iot") );
		int and = Integer.parseInt( request.getParameter("and") );
		
		// ��յ� ����ϱ�
		
		double avg = (java+web+iot+and)/4;
		
		
		// �� ���ǿ� �°� ������ ����� 
		
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
         <legend>����Ȯ�����α׷�</legend>
         <table width="500">   
            <tr>
               <td>�̸�</td>
               <td><%= name %></td>
            </tr>
            <tr>
               <td>JAVA����</td>
               <td><%= java %></td>
            </tr>
            <tr>
               <td>WEB����</td>
               <td><%= web %></td>
            </tr>
               <tr>
               <td>IOT����</td>
               <td><%= iot %></td>
            </tr>      
            <tr>
               <td>ANDROID����</td>
               <td><%= and %></td>
            </tr>      
            <tr>
               <td> ��� </td>
               <td> <%=avg %></td>
            </tr>
            <tr>
               <td> ���� </td>
               <td> <%=score %></td>
            </tr>                                                                                                         
         </table>
      </fieldset>


</body>
</html>