<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<!-- STYLE -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1,
shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style type="text/css">
#mytab {
	text-align: center;
}
</style>

<!-- AJAX -->


<title>Countries Results</title>
</head>

<body>

	<!--  

	<div class="container-fluid">
	<div class="row"></div>
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<p>Le nazioni di quale continente vuoi visualizzare?</p>
			</div>
			<div class="col"></div>
		</div>
		<div class="row"></div>
		<div class="row">
		<div class="col">
		<button id="eu">Europe</button>
		</div>
		<div class="col">
		<button id="amer">Americas</button>
		</div>
		<div class="col">
		<button id="as">Asia</button>
		</div>
		<div class="col">
		<button id="mea">Middle East and	Africa</button>
		</div>
	
-->

	<div class="container-fluid">
		<div class="row"></div>
		<div class="row">
			<div class="col"></div>
			<div class="col">
				<p>Le nazioni di quale continente vuoi visualizzare?</p>
			</div>
			<div class="col"></div>
		</div>
		<div class="row"></div>
		<div class="row">
			<div class="col"></div>
			<form action="/edwpot/esercizioCountries/ControllerCountry">
				<input type="radio" id="eu" name="regionId" value="1" /> <label for="eu">Europe</label> <input
					type="radio" id="as" name="regionId" value="3" /> <label for="as">Asia</label> <input
					type="radio" id="amer" name="regionId" value="2" /> <label for="amer">Americas</label> <input
					type="radio" id="mea" name="regionId" value="4" /> <label for="mea">Middle East and
					Africa</label>
				<button type="submit">Search</button>
			</form>
			<div class="col"></div>
		</div>


		<div class="row"></div>

		<%-- c:if test="${(countries != null) && (countries.isEmpty() == false)}" --%>
		<c:if test="${(countries != null)}">

			<div class="row mytab">
				<table class="table table-dark">
					<tr>
						<th>id</th>
						<th>name</th>
					</tr>
					<c:forEach var="country" items="${countries}">
						<tr>
							<td>${country.id}</td>
							<td>${country.name}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
	</div>
</body>
</html>