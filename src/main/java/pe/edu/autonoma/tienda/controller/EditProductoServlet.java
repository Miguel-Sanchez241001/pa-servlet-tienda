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
import java.util.Optional;

@WebServlet(name = "EditProductoServlet",urlPatterns = "/editproducto")
public class EditProductoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ValidSession.valid(request, response);

        Integer id = Integer.parseInt( request.getParameter("id") );


        RequestDispatcher requestDispatcher = null;

        try {
            ProductoDao dao = new ProductoDao();
            Optional<Producto> optional = dao.findId(id);

            if( optional.isPresent() ) {
                request.setAttribute("producto", optional.get());
                requestDispatcher = request.getRequestDispatcher("edit-producto.jsp");
            } else {
                requestDispatcher = request.getRequestDispatcher("/showproductos");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        requestDispatcher.forward(request, response);
    }
}
