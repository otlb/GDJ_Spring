<%@page import="com.winter.app.regions.RegionDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <c:import url="../temps/bootStrap_css.jsp"></c:import>
</head>
<body>
	
	<c:import url="../temps/header.jsp"></c:import>
	<h1>Regions List</h1>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
			</tr>		
		</thead>
		<!--for(타입명 변수명:배열명  -->
		<!-- items = 배열명 , var = 변수명  -->
		<c:forEach items="${requestScope.list}" var="dto"><!-- items 를 dto에 넣는다 -->
			<tr>
				<td>${pageScope.dto.region_id}</td>
				<td><a href="./detail?region_id=${dto.region_id}">${pageScope.dto.region_name}</a></td>
			</tr>
		</c:forEach>
			
		<tbody>
			
		</tbody>	
	</table>
	<a class="btn btn-outline-dark btn-lg"  href="./add">ADD</a>
	
	
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>