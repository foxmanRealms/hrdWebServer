ex02Gson.jsp

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<button onClick="dataload()">������ ��������</button>

	<table border="1">

		<!-- head -->
		<thead>
			<tr>
				<td>�̸���</td>
				<td>��ȭ��ȣ</td>
				<td>�ּ�</td>
			</tr>
		</thead>


		<!-- body -->
		<tbody id="tbody">

		</tbody>

	</table>

	<!-- Ajax���� ���������� ����ϱ� ������ �������� ���� -->
	<script type="text/javascript" src="js\jquery-3.6.0.min.js">
		
	</script>
	<script type="text/javascript">
		function dataload() {
			$.ajax({

				// ���� ������Ʈ ������
				// url mapping,
				// main.jsp���� ���� ��θ� ������ �� ���� 

				url : "ex02Gson",
				type : "get",

				// data�� ������ ���� ����
				// data : {
				// "num1" : $('input[name=num1]').val(),   
				// "num2" : $('input[name=num2]').val(),   
				// },
				dataType : "json",

				success : function(res) {
					// ������ ��û�� ����� ���

					// alert("����");

					console.log(res);
					$('#tbody').html('');
					for (let i = 0; i < res.length; i++) {
						let table = '<tr>'
						table += '<td>' + res[i].email + '</td>'
						table += '<td>' + res[i].tel + '</td>'
						table += '<td>' + res[i].address + '</td>'
						table += '</tr>'

						// �ڹٽ�ũ��Ʈ���� html�ڵ� �±� ����� ��� 4����
						// .html() -> ����� ����
						// .after() -> �ڿ� �߰�
						// .before() -> �տ� �߰�
						// .append() -> ������ �±� ���ο� �߰�
						$('#tbody').append(table);

					}

				},
				error : function(res) {
					alert("����");
				}
			});
		}
	</script>


</body>
</html>