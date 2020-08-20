<%@ page import="java.util.ArrayList" %>
<%@ page import="pe.edu.autonoma.tienda.entity.Cliente" %>
<%@ page import="java.util.List" %>
<%@ page import="pe.edu.autonoma.tienda.entity.Producto" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 15/08/2020
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<Cliente> clientes = new ArrayList<>();
    List<Producto> productos = new ArrayList<>();
%>
<%
    productos = (List<Producto>) request.getAttribute("productos1");

    clientes = (List<Cliente>) request.getAttribute("clientes1");
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
            <form action="saveventa" method="post" >
                <fieldset >

                    <label for="clienteId">Cliente: </label>
                    <select name="clienteId"id="clienteId">
                        <%
                            for (Cliente cliente : clientes) {
                        %>
                        <option value="<%=cliente.getId()%>"> <%=cliente.getApellidoNombre()%> </option>
                        <%
                            }
                        %>
                    </select><br>
                    <label for="productoId">Producto: </label>
                   <select name="productoId"id="productoId">
                        <%
                            for (Producto producto : productos) {
                        %>
                        <option value="<%=producto.getId()%>"> <%=producto.getDescripcion()%> </option>
                        <%
                            }
                        %>
                    </select><br>
                    <label for="monto">Monto: </label>
                    <input type="number" name="monto"id="monto" ><br>
                    <label for="cantidad">Cantidad: </label>
                    <input type="number" name="cantidad"id="cantidad" ><br>
                    <label for="fecha">Fecha: </label>
                    <input type="text" name="fecha"id="fecha" ><br>
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
