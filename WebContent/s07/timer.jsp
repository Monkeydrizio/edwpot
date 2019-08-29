<%@ page import="java.time.LocalTime"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello JSP</title>
</head>
<body>
    <h1>
        <%
            out.print(LocalTime.now());  //out è la pagina stessa
        %>
    </h1>
</body>
</html>