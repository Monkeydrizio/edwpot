<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP &amp; request</title>
</head>
<body>
    <h1>Hello!</h1>
    <p>
        The user name
        <%
            @SuppressWarnings("unchecked")
            Set<Character> set = (Set<Character>) request.getAttribute("set"); // è un downcast non checked e quindi in riga 14 facciamo il suppreseWarning e diciamo al compilatore di fidarsi di noia
            if (set == null || set.isEmpty()) {
                out.print("is empty");
            } else {
                out.print("contains these letters:");

                Iterator<Character> it = set.iterator();
                while (it.hasNext()) {
                    out.print(" " + it.next());
                }
            }
        %>
    </p>
</body>
</html>