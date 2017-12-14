<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<!-- ^ 마이크로소프트 독단의 엣지 브라우저가 있어서 따로 설정해줘야... -->
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<!-- ^ 매체에 따라 디바이스의 기준으로 사이즈를 정하라.... 뷰포트메타 -->
			
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

			<link href="css/bootstrap.min.css" rel="stylesheet">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
			<script src="js/bootstrap.min.js"></script>
			<!-- ^ 부트스트랩.. -->
			
<title>Insert title here</title>
</head>
<body>
	<h1>add <small>page</small></h1>
	
	<form action="insert.do" method="post">
	
		<div class="form-group">
		    <label  class="control-label" for="sabun">sabun</label>
		    <input class="form-control" type="text" name="sabun" id="sabun" placeholder="sabun">
		 </div>
		 
		 <div class="form-group">
		    <label  class="control-label" for="name">name</label>
		    <input class="form-control" type="text" name="name" id="name" placeholder="name">
		 </div>
		 
		 <div class="form-group">
		    <label  class="control-label" for="nalzza">nalzza</label>
		    <input class="form-control" type="date" name="nalzza" id="nalzza">
		 </div>
		 <div class="form-group">
		    <label  class="control-label" for="pay">pay</label>
		    <input class="form-control" type="text" name="pay" id="pay" placeholder="pay">
		 </div>
	
		  <button type="submit" class="btn btn-default">Submit</button>
			
	</form>
</body>
</html>