<%@ page import="java.util.ArrayList" %>
<%@ page import="pe.edu.autonoma.tienda.entity.Venta" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 15/08/2020
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<Venta> ventas = new ArrayList<>();
%>
<%
    ventas = (List<Venta>) request.getAttribute("ventas");
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
            <h2>Ventas</h2>
            <table id="table-trabajadores" class="table-collapse">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Cliente</th>
                    <th>Producto</th>
                    <th>Monto</th>
                    <th>Cantidad</th>
                    <th>Fecha </th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Venta ventas: ventas) {
                %>
                <tr>
                    <td><%=ventas.getId()%></td>
                    <td><%=ventas.getClienteId().getApellidoNombre()%></td>
                    <td><%=ventas.getProductoId().getDescripcion()%></td>
                    <td><%=ventas.getMonto()%></td>
                    <td><%=ventas.getCantidad()%></td>
                    <td><%=ventas.getFecha()%></td>

                    <td>
                        <a href="editventa?id=<%=ventas.getId()%>" class="a-button a-button-edit">Editar</a>
                    </td>
                    <td>
                        <a href="deleteventa?id=<%=ventas.getId()%>" class="a-button a-button-del">Borrar</a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
                <tfoot></tfoot>
            </table>

            <a href="newventacliente" class="a-button a-button-new">Nueva Venta</a>
        </div>
        <div>
            .
        </div>
    </section>
</main>






</body>
</html>
