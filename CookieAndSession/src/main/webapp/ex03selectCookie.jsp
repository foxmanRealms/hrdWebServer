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
		// ��Ű ���� ��ȸ
		// ��Ű ������ �ϳ��̻����� ������ �� ����
		// -> �迭�� ����
		
		// 1. ��Ű��ü ����
		Cookie[] cookie = request.getCookies();
		
		// ����ó��
		if(cookie !=null){
			// cookie �迭�� �ִ� ��Ű ���� ������ֱ�
			// ��Ű�� �̸� : getName()
			// ��Ű�� ��(value) : getValue()
			
				for(int i=0;i<cookie.length;i++){
					out.print("��Ű�� �̸� : " + cookie[i].getName()+"<br>");
					out.print("��Ű�� �� : " + cookie[i].getValue()+"<br>");
					
				}
		}
	
	
	%>
</body>
</html>