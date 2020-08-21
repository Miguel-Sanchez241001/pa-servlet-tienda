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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowClientesServlet", urlPatterns = "/showclientes")
public class ShowClientesServlet extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ValidSession.valid(request, response);

        List<Cliente> clientes = new ArrayList<>();
        try{
            ClienteDao dao = new ClienteDao();
            clientes = dao.list();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        request.setAttribute("clientes", clientes);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-clientes.jsp");
        requestDispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }
}
