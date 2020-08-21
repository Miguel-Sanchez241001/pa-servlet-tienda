<%@ page import="java.util.ArrayList" %>
<%@ page import="pe.edu.autonoma.tienda.entity.Cliente" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 15/08/2020
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<Cliente> clientes = new ArrayList<>();
%>
<%
    clientes = (List<Cliente>) request.getAttribute("clientes");
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
            <h2>Clientes</h2>
            <table id="table-trabajadores" class="table-collapse">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Nombre Apellido</th>
                    <th>Tipo documento</th>
                    <th>Numero de documento</th>
                    <th>Direccion</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Cliente clientes: clientes) {
                %>
                <tr>
                    <td><%=clientes.getId()%></td>
                    <td><%=clientes.getApellidoNombre()%></td>
                    <td><%=clientes.getTipoDocumento()%></td>
                    <td><%=clientes.getNumeroDocumento()%></td>
                    <td><%=clientes.getDireccion()%></td>
                    <td>
                        <a href="editcliente?id=<%=clientes.getId()%>" class="a-button a-button-edit">Editar</a>
                    </td>
                    <td>
                        <a href="deletecliente?id=<%=clientes.getId()%>" class="a-button a-button-del">Borrar</a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
                <tfoot></tfoot>
            </table>

            <a href="new-cliente.jsp" class="a-button a-button-new">Nuevo Cliente</a>
        </div>
        <div>
            .
        </div>
    </section>

</main>

</body>
</html>
