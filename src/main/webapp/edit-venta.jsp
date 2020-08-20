<%@ page import="pe.edu.autonoma.tienda.entity.Cliente" %>
<%@ page import="pe.edu.autonoma.tienda.entity.Producto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pe.edu.autonoma.tienda.entity.Venta" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 15/08/2020
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    Venta venta;
    List<Cliente> clientes = new ArrayList<>();
    List<Producto> productos = new ArrayList<>();
%>
<%
    venta = (Venta) request.getAttribute("venta");
    productos = (List<Producto>) request.getAttribute("productos");
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
            <form action="saveventaedit" method="post" >
                <fieldset >
                    <legend> Editar Venta</legend>
                    <label for="id2">Id: </label>
                    <input type="hidden" name="id" id="id"
                           value="<%=venta.getId()%>">
                    <input type="text" name="id2" id="id2"
                           value="<%=venta.getId()%>" disabled><br>

                    <label for="clienteId">Cliente: </label>
                    <select name="clienteId"id="clienteId">
                        <%
                            for (Cliente cliente : clientes) {
                        %>
                        <option value="<%=cliente.getId()%>"
                                <%
                                    if (cliente.getId().equals(venta.getClienteId().getId())) {
                                %>
                                selected
                                <%
                                    }
                                %>
                        >
                            <%=cliente.getApellidoNombre()%></option>
                        <%
                            }
                        %>
                    </select><br>
                    <label for="productoId">Producto: </label>
                    <select name="productoId"id="productoId">
                        <%
                            for (Producto producto : productos) {
                        %>
                        <option value="<%=producto.getId()%>"
                                <%
                                    if (producto.getId().equals(venta.getProductoId().getId())) {
                                %>
                                selected
                                <%
                                    }
                                %>
                        >
                            <%=producto.getDescripcion()%></option>
                        <%
                            }
                        %>
                    </select><br>
                    <label for="monto">Monto: </label>
                    <input type="number" name="monto"id="monto"
                           value="<%=venta.getMonto()%>" ><br>
                    <label for="cantidad">Cantidad: </label>
                    <input type="number" name="cantidad"id="cantidad"
                           value="<%=venta.getCantidad()%>" ><br>
                    <label for="fecha">Fecha: </label>
                    <input type="text" name="fecha"id="fecha"
                           value="<%=venta.getFecha()%>" ><br>

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
