<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 
	// �Ķ���� ����
	
	// num�� ��������
	int num = Integer.parseInt( request.getParameter("num") );
	
	
	%>
	
	
	
	<form action="ex10result.jsp">
	<fieldset>
		<legend>
		������÷ �ۼ�
		</legend>
	
		���� : <input type="text" name="title"> <br>
		<!-- �Է��ߴ� num�� ����ŭ input�±׸� �������� -->
		<% 
			// num��ŭ input�±� �ݺ��ϱ� 
		
			for(int i=1 ; i<=num; i++){
				out.print( "������" + i + "<input type='text' name='item'> <br>");
			}
		%>
		<input type="submit" value="���� ��÷ ����">
	
	</fieldset>
	
	</form>

</body>
</html>