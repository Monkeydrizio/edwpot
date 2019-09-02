<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<sql:query dataSource="jdbc/hr" var="eucon">select country_id, country_name FROM countries NATURAL JOIN regions WHERE region_name='Europe' ORDER BY country_name</sql:query>

<!-- STYLE -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1,
shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<title>Select Join Europe</title>
</head>
<body>

	<table class="table table-dark">
		<tr>
			<th>id</th>
			<th>name</th>
		</tr>
		<c:forEach var="cur" items="${eucon.rows}">
			<tr>
				<td>${cur.COUNTRY_ID}</td>
				<td>${cur.COUNTRY_NAME}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>