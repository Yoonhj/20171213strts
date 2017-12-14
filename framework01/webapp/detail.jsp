<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1">

			<link href="css/bootstrap.min.css" rel="stylesheet">
	<style>
	
		table a{
		display: block;
		}
	
	</style>	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
			<!-- ^ 부트스트랩.. -->
<script type="text/javascript">
	
	var result =false; 

	$(function(){
		$('form').submit(function(){
			return result;
		});

		$('button').eq(0).hide();
		$('button').eq(1).click(function(){
			$('button').eq(0).show();
			$('button').eq(2).hide();
			$('button').eq(1).hide();
			result=true;
			
			$('h1').html("UPDATE <small>Page</small>");
			
			$('input').eq(1).prop('readonly', false); //이 기능이 발동하면 리드온리가 팔스로
			$('input').eq(3).prop('readonly', false);
			//attr() 는 'readonly', '?????' 가 되므로 prop으로 바뀜
		});
		
	});

</script>
<title>Insert title here</title>
</head>
<body>
	<h1>detail <small>page</small></h1>

	<form action="update.do" method="post">
	
		<div class="form-group">
		    <label  class="control-label" for="sabun">sabun</label>
		    <input class="form-control" type="text" value="${bean.sabun }" name="sabun" id="sabun" placeholder="sabun" readonly="readonly">
		 </div>
		 
		 <div class="form-group">
		    <label  class="control-label" for="name">name</label>
		    <input class="form-control" type="text" value="${bean.name }" name="name" id="name" placeholder="name" readonly="readonly">
		 </div>
		 
		 <div class="form-group">
		    <label  class="control-label" for="nalzza">nalzza</label>
		    <input class="form-control" type="date" value="${bean.nalzza }" name="nalzza" id="nalzza" readonly="readonly">
		 </div>
		 <div class="form-group">
		    <label  class="control-label" for="pay">pay</label>
		    <input class="form-control" type="text" value="${bean.pay }" name="pay" id="pay" placeholder="pay" readonly="readonly">
		 </div>
	
		  <button type="submit" class="btn btn-default">Submit</button>
			<button type="button"  class="btn btn-info">수정</button>
			<button type="button"  class="btn btn-info">삭제</button>		
	</form>



</body>
</html>