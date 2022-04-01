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
   <button onClick="save()">�����ϱ�</button>
   
   <hr>
   
   <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
   <script type="text/javascript">
      
      // data ���� ���� �ۼ�
      let putData = [];
      function input(){
         putData.push({
            'title' : $('input[name=title]').val(),
            'start' : $('input[name=start]').val(),
            'end' : $('input[name=end]').val()
         });
         console.log(putData);
         
      }

   // openAPI �� ��쿡 �������� OR �Ϲ� �ڹٽ�ũ��Ʈ ���� ����
   function save(){
      $.ajax({
         // http://...,
         // ���� ������Ʈ ������ url mapping, main.jsp ����
         url : "ex03sendJson",
         type : "post",
         data : {
            // json Ÿ���� String Ÿ������ ������.
            'json' : JSON.stringify(putData)
         },
      
         // ������ ��û URL�� ���ؼ� �����ϴ� ������ Ÿ��
         // dataType : "json",
                     // res : ������ ��û�� ����� ���
         success : function(res){
            // alert("����!");
            console.log(res);
            
            // .after()
            $('hr').after(res);
            
         },
         error : function(){
            alert("����!");
         }
         
      });
      
   }
   
</script>
</body>
</html>