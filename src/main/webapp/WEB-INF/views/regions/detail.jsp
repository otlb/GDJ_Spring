<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <c:import url="../temps/bootStrap_css.jsp"></c:import>
  </head>
<body>
	 <c:import url="../temps/header.jsp"></c:import>
    
    <section class="container-fluid">    	
    	
    	<c:if test="${dto != null }">
    	<table class="table table-hover">
    		<thead>
    			<tr>
    				<th>ID</th>
    				<th>NAME</th>
    			</tr>
    		</thead>
    		<tr>
    			<td>${dto.region_id}</td>
    			<td>${dto.region_name}</td>
    		</tr>
    	</table>
    	</c:if>
    	
    	<c:if test="${empty dto}">
    			<h3>없는 번호 입니다.</h3>
    		</c:if>
    	
    </section>

 	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>