<!-- 1.지시자   -->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 2. 선언문 : 변수 선언 또는 메소드 정의 
					사용비중이 적다. 
	-->
	<%! 
	int num=0;
	
	public void show(){
		System.out.print("보여주기");
	}
	%>
	<!-- 3. 스크립틀릿 : 자바문법을 쓸 수 있는 공간  
					주로 사용하는 jsp 요소-->
	<% 
	int num2 =0;
	
	// java 주석
	/* java 주석 */
	
	
	%>
	
	<%-- java주석 --%>
	
	
	<!-- 4. 표현식 : 웹페이지에 결과값을 보여줄 수 있음
					변수, 메소드   
					세미콜론(;) 쓰지않음 주의 	-->
	<%= 
	num++
	%>
	
	<%= num2++
	%>
	
	<h1> jsp파일 메인
	</h1>
</body>
</html>