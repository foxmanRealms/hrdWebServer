<!-- 1.������   -->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 2. ���� : ���� ���� �Ǵ� �޼ҵ� ���� 
					�������� ����. 
	-->
	<%! 
	int num=0;
	
	public void show(){
		System.out.print("�����ֱ�");
	}
	%>
	<!-- 3. ��ũ��Ʋ�� : �ڹٹ����� �� �� �ִ� ����  
					�ַ� ����ϴ� jsp ���-->
	<% 
	int num2 =0;
	
	// java �ּ�
	/* java �ּ� */
	
	
	%>
	
	<%-- java�ּ� --%>
	
	
	<!-- 4. ǥ���� : ���������� ������� ������ �� ����
					����, �޼ҵ�   
					�����ݷ�(;) �������� ���� 	-->
	<%= 
	num++
	%>
	
	<%= num2++
	%>
	
	<h1> jsp���� ����
	</h1>
</body>
</html>