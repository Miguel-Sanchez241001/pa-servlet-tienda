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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowProductosServlet", urlPatterns = "/showproductos")
public class ShowProductosServlet extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Producto> productos = new ArrayList<>();
        try{
            ProductoDao dao = new ProductoDao();
            productos = dao.list();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        request.setAttribute("productos", productos);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-productos.jsp");
        requestDispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }
}
