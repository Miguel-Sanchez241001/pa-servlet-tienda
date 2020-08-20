package pe.edu.autonoma.tienda.controller;

import pe.edu.autonoma.tienda.dao.ClienteDao;
import pe.edu.autonoma.tienda.dao.ProductoDao;
import pe.edu.autonoma.tienda.dao.VentaDao;
import pe.edu.autonoma.tienda.entity.Cliente;
import pe.edu.autonoma.tienda.entity.Producto;
import pe.edu.autonoma.tienda.entity.Venta;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "EditVentaServlet",urlPatterns = "/editventa")
public class EditVentaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt( request.getParameter("id") );

        RequestDispatcher requestDispatcher = null;
        List<Cliente> clientes = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();

        try {
            VentaDao dao = new VentaDao();
            Optional<Venta> optional = dao.findId(id);

            if( optional.isPresent() ) {
                ClienteDao clienteDao = new ClienteDao();
                clientes = clienteDao.list();
                request.setAttribute("clientes", clientes);

                ProductoDao productoDao = new ProductoDao();
                productos = productoDao.list();
                request.setAttribute("productos", productos);
                request.setAttribute("venta", optional.get());
                requestDispatcher = request.getRequestDispatcher("edit-venta.jsp");
            } else {
                requestDispatcher = request.getRequestDispatcher("/showventas");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        requestDispatcher.forward(request, response);
    }
}
