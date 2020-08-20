package pe.edu.autonoma.tienda.controller;

import pe.edu.autonoma.tienda.dao.ProductoDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteProductoServlet",urlPatterns = "/deleteproducto")
public class DeleteProductoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt( request.getParameter("id") );
        RequestDispatcher requestDispatcher = null;
        try {
            ProductoDao dao = new ProductoDao();
            dao.deleteId(id);
            requestDispatcher = request.getRequestDispatcher("/showproductos");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        requestDispatcher.forward(request, response);
    }
}
