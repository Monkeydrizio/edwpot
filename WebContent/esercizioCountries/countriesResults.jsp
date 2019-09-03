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

<title>Countries Results</title>
</head>

<body>

<table class="table table-dark">
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>
        <c:forEach var="region" items="${CountryBean}">
            <tr>
                <td>${{CountryBean.id}</td>
                <td>${{CountryBean.name}</td>
            </tr>
        </c:forEach>
    </table>
 
<!-- Da sistemare con Bootstrap -->
<hr>
<hr>  
  
<a href="edwpot/esercizioCountries/countriesfinder.html">NEW research</a>

</body>
</html>