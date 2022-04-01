<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
   title : <input type="text" name="title"><br>
   start : <input type="date" name="start"><br>
   end : <input type="date" name="end"><br>
   
   <button onClick="input()">input</button>
   <button onClick="save()">저장하기</button>
   
   <hr>
   
   <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
   <script type="text/javascript">
      
      // data 쓰기 위해 작성
      let putData = [];
      function input(){
         putData.push({
            'title' : $('input[name=title]').val(),
            'start' : $('input[name=start]').val(),
            'end' : $('input[name=end]').val()
         });
         console.log(putData);
         
      }

   // openAPI 쓸 경우에 제이쿼리 OR 일반 자바스크립트 문법 선택
   function save(){
      $.ajax({
         // http://...,
         // 같은 프로젝트 내에서 url mapping, main.jsp 파일
         url : "ex03sendJson",
         type : "post",
         data : {
            // json 타입을 String 타입으로 보내줌.
            'json' : JSON.stringify(putData)
         },
      
         // 서버가 요청 URL을 통해서 응답하는 내용의 타입
         // dataType : "json",
                     // res : 서버에 요청된 결과가 담김
         success : function(res){
            // alert("성공!");
            console.log(res);
            
            // .after()
            $('hr').after(res);
            
         },
         error : function(){
            alert("실패!");
         }
         
      });
      
   }
   
</script>
</body>
</html>