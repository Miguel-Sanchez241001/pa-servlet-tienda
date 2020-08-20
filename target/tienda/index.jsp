<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 02/08/2020
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
String username, message;

%>
<%
    username = (String) request.getAttribute("username");
    message = (String) request.getAttribute("message");
%>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Store</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<header>

</header>
<main>
    <section id="secction-main-login">
        <div>.</div>
        <div id="login">
            <h3>Sign in</h3> <br>
            <%
                if( message != null ) {
            %>
            <p class="text-error"><%=message%></p>
            <%
                }
            %>
            <form id="form-login" action="singin" method="post">

                <label for="username">Usuario: </label>
                <input type="text" name="username" id="username" placeholder="Ingrese el username"
                       value="<%=(username!=null ? username : "")%>"><br>
                <label for="password">Contraseña: </label>
                <input type="password" name="password" id="password">

                <button type="submit">Ingresar</button>
            </form>
        </div>
        <div>
            .
        </div>
    </section>
</main>
<footer>

</footer>

</body>
</html>
