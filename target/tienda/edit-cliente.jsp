<%@ page import="pe.edu.autonoma.tienda.entity.Cliente" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 15/08/2020
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    Cliente clientes;
%>
<%
    clientes = (Cliente) request.getAttribute("cliente");
%>
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
            <form action="saveclienteedit" method="post" >
                <fieldset >
                    <label for="id2">Id: </label>
                    <input type="hidden" name="id" id="id"
                           value="<%=clientes.getId()%>">
                    <input type="text" name="id2" id="id2"
                           value="<%=clientes.getId()%>" disabled><br>
                    <legend> Nuevo Cliente</legend>
                    <label for="apellidoNombre">Apellido Nombre: </label>
                    <input type="text" name="apellidoNombre"id="apellidoNombre"
                           value="<%=clientes.getApellidoNombre()%>"><br>
                    <label for="tipoDocumento">Tipo De documento: </label>
                    <input type="text" name="tipoDocumento"id="tipoDocumento"
                           value="<%=clientes.getTipoDocumento()%>"><br>
                    <label for="numeroDocumento">Numero Documento: </label>
                    <input type="text" name="numeroDocumento"id="numeroDocumento"
                           value="<%=clientes.getNumeroDocumento()%>"><br>
                    <label for="direccion">Direccion: </label>
                    <input type="text" name="direccion"id="direccion"
                           value="<%=clientes.getDireccion()%>"><br>

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
