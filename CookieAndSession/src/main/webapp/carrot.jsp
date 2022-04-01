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
	<h1>스인개 당근마켓</h1>
	<form action="carrotList" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td>가격</td>
				<td>장바구니에 담기</td>
			</tr>
			<tr>
				<td>병관쌤하고 10분 면담권</td>
				<td>5만원</td>
				<td><input type="checkbox" name="item" value="병관쌤하고 10분 면담권"></td>
			</tr>
			<tr>
				<td>텃밭에서 키운 상추</td>
				<td>만원</td>
				<td><input type="checkbox" name="item" value="텃밭에서 키운 상추"></td>
			</tr>
			<tr>
				<td>커피 쿠폰</td>
				<td>2백원</td>
				<td><input type="checkbox" name="item" value="2백원"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="장바구니 담기"></td>
			</tr>
		</table>
	</form>
	</div>
	<div id="list">
		<h2>장바구니 목록</h2>
		<%
		//1. 클라이언트로부터 쿠키 받아오기
		Cookie[] cookies = request.getCookies();
		
		//2. 쿠키값이 있다면 쿠키의 이름(name)을 비교하여 쿠키 값(value) 출력하기
		if(cookies !=null){
			for(int i=0; i < cookies.length;i++){
				//쿠키의 이름에 item이 포함되어 있다면
				// 문자열 일부 일치  .contains("문자열")
				if(cookies[i].getName().contains("item")){
					//쿠키값에 URLEncoder.encode 했으니까
					//불러올때는 URLDecoder.decode 해줘야 한다.
				 out.print(URLDecoder.decode(cookies[i].getValue(),"euc-kr") +"<br>");
				}
				
			}
			
		}
		
		
		%>
	</div>
</body>
</html>