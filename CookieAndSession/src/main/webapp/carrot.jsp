<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
* {
	text-align: center;
}
#checklist{
	width:70%
}
table {
	width: 100%;
	border-top: 1px solid #444444;
	border-collapse: collapse;
}

td {
	border-bottom: 1px solid #444444;
	padding: 10px;
}
#list{
	background-color: orange;
	width: 20%;
    position: fixed;
    right: 0;
    top: 0;
    height: 200px;
    border-radius: 3%
}
</style>
</head>
<body>
	<div id="checklist">
	<h1>���ΰ� ��ٸ���</h1>
	<form action="carrotList" method="post">
		<table>
			<tr>
				<td>�̸�</td>
				<td>����</td>
				<td>��ٱ��Ͽ� ���</td>
			</tr>
			<tr>
				<td>�������ϰ� 10�� ����</td>
				<td>5����</td>
				<td><input type="checkbox" name="item" value="�������ϰ� 10�� ����"></td>
			</tr>
			<tr>
				<td>�Թ翡�� Ű�� ����</td>
				<td>����</td>
				<td><input type="checkbox" name="item" value="�Թ翡�� Ű�� ����"></td>
			</tr>
			<tr>
				<td>Ŀ�� ����</td>
				<td>2���</td>
				<td><input type="checkbox" name="item" value="2���"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="��ٱ��� ���"></td>
			</tr>
		</table>
	</form>
	</div>
	<div id="list">
		<h2>��ٱ��� ���</h2>
		<%
		//1. Ŭ���̾�Ʈ�κ��� ��Ű �޾ƿ���
		Cookie[] cookies = request.getCookies();
		
		//2. ��Ű���� �ִٸ� ��Ű�� �̸�(name)�� ���Ͽ� ��Ű ��(value) ����ϱ�
		if(cookies !=null){
			for(int i=0; i < cookies.length;i++){
				//��Ű�� �̸��� item�� ���ԵǾ� �ִٸ�
				// ���ڿ� �Ϻ� ��ġ  .contains("���ڿ�")
				if(cookies[i].getName().contains("item")){
					//��Ű���� URLEncoder.encode �����ϱ�
					//�ҷ��ö��� URLDecoder.decode ����� �Ѵ�.
				 out.print(URLDecoder.decode(cookies[i].getValue(),"euc-kr") +"<br>");
				}
				
			}
			
		}
		
		
		%>
	</div>
</body>
</html>