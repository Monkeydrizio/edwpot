<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sql:query dataSource="jdbc/hr" var="regions">select * from regions</sql:query>
<!-- creo una variabile con var -->
<title>HR Regions</title>

<!-- STYLE -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1,
shrink-to-fit=no">
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	<table class="table table-dark">
		<tr>
			<th>id</th>
			<th>name</th>
		</tr>
		<c:forEach var="cur" items="${regions.rows}">
			<tr>
				<td>${cur.REGION_ID}</td>
				<td>${cur.REGION_NAME}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>