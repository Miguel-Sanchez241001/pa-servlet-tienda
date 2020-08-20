<%@ page import="java.util.ArrayList" %>
<%@ page import="pe.edu.autonoma.tienda.entity.Producto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 15/08/2020
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<Producto> productos = new ArrayList<>();
%>
<%
    productos = (List<Producto>) request.getAttribute("productos");
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
            <h2>Productos</h2>
            <table id="table-trabajadores" class="table-collapse">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Descripcion</th>
                    <th>Stock</th>
                    <th>Marca</th>
                    <th>Categoria</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Producto productos: productos) {
                %>
                <tr>
                    <td><%=productos.getId()%></td>
                    <td><%=productos.getDescripcion()%></td>
                    <td><%=productos.getStock()%></td>
                    <td><%=productos.getMarca()%></td>
                    <td><%=productos.getCategoria()%></td>

                    <td>
                        <a href="editproducto?id=<%=productos.getId()%>" class="a-button a-button-edit">Editar</a>
                    </td>
                    <td>
                        <a href="deleteproducto?id=<%=productos.getId()%>" class="a-button a-button-del">Borrar</a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
                <tfoot></tfoot>
            </table>

            <a href="new-producto.jsp" class="a-button a-button-new">Nuevo Producto</a>
        </div>
        <div>
            .
        </div>
    </section>
</main>
</body>
</html>
