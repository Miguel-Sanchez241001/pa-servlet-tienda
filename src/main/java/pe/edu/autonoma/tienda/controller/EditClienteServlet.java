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
import java.util.Optional;

@WebServlet(name = "EditClienteServlet",urlPatterns = "/editcliente")
public class EditClienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt( request.getParameter("id") );
        RequestDispatcher requestDispatcher = null;

        try {
            ClienteDao dao = new ClienteDao();
            Optional<Cliente> optional = dao.findId(id);

            if( optional.isPresent() ) {
                request.setAttribute("cliente", optional.get());
                requestDispatcher = request.getRequestDispatcher("edit-cliente.jsp");
            } else {
                requestDispatcher = request.getRequestDispatcher("/showcliente");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        requestDispatcher.forward(request, response);
    }
}
