package pe.edu.autonoma.tienda.controller;

import pe.edu.autonoma.tienda.dao.ClienteDao;
import pe.edu.autonoma.tienda.entity.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveEditClienteServlet",urlPatterns = "/saveclienteedit")
public class SaveEditClienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ValidSession.valid(request, response);

        Integer id = Integer.parseInt( request.getParameter("id") );
        String apellidoNombre = request.getParameter("apellidoNombre");
        String tipoDocumento = request.getParameter("tipoDocumento");
        String numeroDocumento = request.getParameter("numeroDocumento");
        String direccion = request.getParameter("direccion");

        Cliente cliente=new Cliente(id,apellidoNombre,tipoDocumento,numeroDocumento,direccion);
        try {
            ClienteDao dao = new ClienteDao();
            dao.update(cliente);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showclientes");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
