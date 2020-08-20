package pe.edu.autonoma.tienda.controller;

import pe.edu.autonoma.tienda.dao.ProductoDao;
import pe.edu.autonoma.tienda.entity.Producto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveProductoServlet",urlPatterns = "/saveproducto")
public class SaveProductoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descripcion = request.getParameter("descripcion");
        Integer stock = Integer.parseInt(request.getParameter("stock"));
        String marca = request.getParameter("marca");
        String categoria = request.getParameter("categoria");

        Producto producto=new Producto(descripcion,stock,marca,categoria);
        try {
            ProductoDao dao = new ProductoDao();
            dao.insert(producto);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showproductos");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
