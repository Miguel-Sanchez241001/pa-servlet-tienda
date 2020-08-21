package pe.edu.autonoma.tienda.controller;

import pe.edu.autonoma.tienda.dao.VentaDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteVentaServlet",urlPatterns = "/deleteventa")
public class DeleteVentaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ValidSession.valid(request, response);

        Integer id = Integer.parseInt( request.getParameter("id") );
        RequestDispatcher requestDispatcher = null;
        try {
            VentaDao dao = new VentaDao();
            dao.deleteId(id);
            requestDispatcher = request.getRequestDispatcher("/showventas");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        requestDispatcher.forward(request, response);
    }
}
