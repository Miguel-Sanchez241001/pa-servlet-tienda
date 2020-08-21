package pe.edu.autonoma.tienda.controller;

import pe.edu.autonoma.tienda.dao.VentaDao;
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

@WebServlet(name = "ShowVentasServlet", urlPatterns = "/showventas")
public class ShowVentasServlet extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ValidSession.valid(request, response);

        List<Venta> ventas = new ArrayList<>();
        try{
            VentaDao dao = new VentaDao();
            ventas = dao.list();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        request.setAttribute("ventas", ventas);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-ventas.jsp");
        requestDispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }
}
