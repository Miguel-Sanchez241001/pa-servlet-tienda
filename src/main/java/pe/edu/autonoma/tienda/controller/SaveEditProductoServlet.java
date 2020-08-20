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

@WebServlet(name = "SaveEditProductoServlet",urlPatterns = "/saveproductoedit")
public class SaveEditProductoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt( request.getParameter("id") );
        String descripcion = request.getParameter("descripcion");
        Integer stock = Integer.parseInt(request.getParameter("stock"));
        String marca = request.getParameter("marca");
        String categoria = request.getParameter("categoria");

        Producto producto=new Producto(id,descripcion,stock,marca,categoria);
        try {
            ProductoDao dao = new ProductoDao();
            dao.update(producto);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showproductos");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
