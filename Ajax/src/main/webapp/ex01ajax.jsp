<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	num1 :
	<input type="text" name="num1">
	<br> num2 :
	<input type="text" name="num2">
	<br>

	<button onClick="sum()">���ϱ�</button>

	<!-- Ajax���� ���������� ����ϱ� ������ �������� ���� -->
	<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
	// openAPI�� �� ��쿡 �������� or �Ϲ� �ڹٽ�ũ��Ʈ ����      ȥ���ϸ� ������ �߻��� ����� �ִ�
	function sum(){
		$.ajax({
			// http://....
	         // ���� ������Ʈ ������ url mapping, main.jsp����
	         url : "ex01sum",
	         type : "get",
	         data : {
	            "num1" : $('input[name=num1]').val(),
	            "num2" : $('input[name=num2]').val()
	         },
	         //dataType-> ������ ������
	                        //������ ��û�� ����� ���
	         success : function(res) {
	            //alert("����");
	            console.log(res);
	         },
	         error : function(){
	            alert("����");
	         }	
		
		
		});
		

	</script>
</body>
</html>