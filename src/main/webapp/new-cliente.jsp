<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 15/08/2020
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Store</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<nav id="header-nav">
    <div id="header-logo">
        Store
    </div>
    <ul id="nav-menu">
        <li><a href="showclientes">Clientes</a></li>
        <li><a href="showproductos">Productos</a></li>
        <li><a href="showventas">Ventas</a></li>
    </ul>
</nav>
<main>
    <section id="secction-main">
        <div>.</div>
        <div>
            <form action="savecliente" method="post" >
                <fieldset >
                    <legend> Nuevo Cliente</legend>
                    <label for="apellidoNombre">Apellido Nombre: </label>
                    <input type="text" name="apellidoNombre"id="apellidoNombre" ><br>
                    <label for="tipoDocumento">Tipo De documento: </label>
                    <input type="text" name="tipoDocumento"id="tipoDocumento" ><br>
                    <label for="numeroDocumento">Numero Documento: </label>
                    <input type="text" name="numeroDocumento"id="numeroDocumento" ><br>
                    <label for="direccion">Direccion: </label>
                    <input type="text" name="direccion"id="direccion" ><br>

                </fieldset>
                <button type="submit">Enviar</button>
            </form>
        </div>
        <div>
            .
        </div>
    </section>
</main>
</body>
</html>
