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
	<button onClick="dataload()">데이터 가져오기</button>

	<table border="1">

		<!-- head -->
		<thead>
			<tr>
				<td>이메일</td>
				<td>전화번호</td>
				<td>주소</td>
			</tr>
		</thead>


		<!-- body -->
		<tbody id="tbody">

		</tbody>

	</table>

	<!-- Ajax에서 제이쿼리를 사용하기 때문에 제이쿼리 삽입 -->
	<script type="text/javascript" src="js\jquery-3.6.0.min.js">
		
	</script>
	<script type="text/javascript">
		function dataload() {
			$.ajax({

				// 같은 프로젝트 내에서
				// url mapping,
				// main.jsp같은 파일 경로를 지정할 수 있음 

				url : "ex02Gson",
				type : "get",

				// data로 보내지 않을 예정
				// data : {
				// "num1" : $('input[name=num1]').val(),   
				// "num2" : $('input[name=num2]').val(),   
				// },
				dataType : "json",

				success : function(res) {
					// 서버에 요청된 결과가 담김

					// alert("성공");

					console.log(res);
					$('#tbody').html('');
					for (let i = 0; i < res.length; i++) {
						let table = '<tr>'
						table += '<td>' + res[i].email + '</td>'
						table += '<td>' + res[i].tel + '</td>'
						table += '<td>' + res[i].address + '</td>'
						table += '</tr>'

						// 자바스크립트에서 html코드 태그 만드는 방법 4가지
						// .html() -> 덮어쓰는 형식
						// .after() -> 뒤에 추가
						// .before() -> 앞에 추가
						// .append() -> 선택한 태그 내부에 추가
						$('#tbody').append(table);

					}

				},
				error : function(res) {
					alert("실패");
				}
			});
		}
	</script>


</body>
</html>