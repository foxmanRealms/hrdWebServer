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
		// ��Ű�� �����ϴ� ���
		// ��Ű�� ������ �����ϴ� 
		Cookie cookie = new Cookie("id","");
		
	
		// ��Ű�� ��ȿ�Ⱓ ����
		// setMaxAge(�ʴ���)
		//60*60...  ���������� �����־ �����ȴ�. 
		// ���� setMaxAge ������ ���ϸ� ������ ����� ��Ű ������
		cookie.setMaxAge(0);  
		
		//��Ű ��ü�� �����ϸ� ����ڿ��� �����ϴ� �ͱ���!
		response.addCookie(cookie);   
	%>

</body>
</html>