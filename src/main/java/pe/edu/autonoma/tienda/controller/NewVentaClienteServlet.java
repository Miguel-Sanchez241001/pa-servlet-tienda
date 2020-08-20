package pe.edu.autonoma.tienda.controller;

import pe.edu.autonoma.tienda.dao.ClienteDao;
import pe.edu.autonoma.tienda.dao.ProductoDao;
import pe.edu.autonoma.tienda.entity.Cliente;
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

@WebServlet(name = "NewVentaClienteServlet", urlPatterns = "/newventacliente")
public class NewVentaClienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = new ArrayList<>();

        try {
            ClienteDao dao = new ClienteDao();
            clientes = dao.list();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        List<Producto> productos = new ArrayList<>();

        try {
            ProductoDao dao = new ProductoDao();
            productos = dao.list();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        request.setAttribute("productos1", productos);
        request.setAttribute("clientes1", clientes);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("new-venta.jsp");
        requestDispatcher.forward(request, response);
    }
}
