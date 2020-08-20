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
import java.util.Optional;

@WebServlet(name = "SaveVentaServlet",urlPatterns = "/saveventa")
public class SaveVentaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clienteId = request.getParameter("clienteId");
        String productoId = request.getParameter("productoId");
        Integer monto = Integer.parseInt(request.getParameter("monto"));
        Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String fecha = request.getParameter("fecha");

        ClienteDao clienteDao=new ClienteDao();
        ProductoDao productoDao=new ProductoDao();

        int idCliente = Integer.parseInt(clienteId);
        Optional<Cliente> optionalCliente = clienteDao.findId( idCliente );
        int idProducto = Integer.parseInt(productoId);
        Optional<Producto> optionalProducto= productoDao.findId( idProducto );

        Venta venta = new Venta(optionalCliente.get(),optionalProducto.get(),monto, cantidad,
                fecha);
        try {
            VentaDao dao = new VentaDao();
            dao.insert(venta);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showventas");
        requestDispatcher.forward(request, response);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
