<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<!-- ^ 마이크로소프트 독단의 엣지 브라우저가 있어서 따로 설정해줘야... -->
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<!-- ^ 매체에 따라 디바이스의 기준으로 사이즈를 정하라.... 뷰포트메타 -->
			
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

			<link href="css/bootstrap.min.css" rel="stylesheet">
			
	<style>
	
		table a{
		display: block;
		}
	
	</style>		
			
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
			<script src="js/bootstrap.min.js"></script>
			<!-- ^ 부트스트랩.. -->
			   
<title>Insert title here</title>
</head>
<body>
	<h1>list <small>page</small></h1>
	<table class="table table-striped table-hover">
		<tr  class="info">
			<th>사번</th>
			<th>이름</th>
			<th>날짜</th>
			<th>페이</th>
		</tr>
		
<c:forEach items="${alist }" var="bean">
		<tr>
			<td class="success"><a href="detail.do?idx=${bean.sabun }">${bean.sabun }</a></td>
			<td class="warning"><a href="detail.do?idx=${bean.sabun }">${bean.name }</a></td>
			<td><a href="detail.do?idx=${bean.sabun }">${bean.nalzza }</a></td>
			<td><a href="detail.do?idx=${bean.sabun }">${bean.pay }</a></td>
			
		</tr>
</c:forEach>		
	</table>
	
	<a href="add.do" class="btn btn-default btn-info" role="button" >input</a>
	
	
</body>
</html>