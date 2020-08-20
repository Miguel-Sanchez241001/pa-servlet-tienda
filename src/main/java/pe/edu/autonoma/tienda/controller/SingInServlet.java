package pe.edu.autonoma.tienda.controller;

import pe.edu.autonoma.tienda.dao.UsuarioDao;
import pe.edu.autonoma.tienda.entity.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "SingInServlet",urlPatterns = "/singin")
public class SingInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        UsuarioDao usuarioDao = new UsuarioDao();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Optional<Usuario> optionalUsuario = usuarioDao.findByUsername( username );

        if(optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            if( usuario.getPassword().equals(password) ) {


                requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
                requestDispatcher.forward(request, response);
            }
        }
        request.setAttribute("username", username);
        request.setAttribute("message", "El usuario y/o contraseña son incorrectos");
        requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
