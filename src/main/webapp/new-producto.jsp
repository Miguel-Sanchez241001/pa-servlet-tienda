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
            <form action="saveproducto" method="post" >
                <fieldset >
                    <legend> Nuevo Producto</legend>
                    <label for="descripcion">Descripcion: </label>
                    <input type="text" name="descripcion"id="descripcion" ><br>
                    <label for="stock">Stock: </label>
                    <input type="number" name="stock"id="stock" ><br>
                    <label for="marca">Marca: </label>
                    <input type="text" name="marca"id="marca" ><br>
                    <label for="categoria">Categoria: </label>
                    <input type="text" name="categoria"id="categoria" ><br>

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
