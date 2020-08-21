package pe.edu.autonoma.tienda.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ValidSession {
    public static void valid(HttpServletRequest request, HttpServletResponse response) {
        boolean error = false;
        HttpSession session = request.getSession();
        if (session != null ) {
            String key = (String) session.getAttribute("key");
            String username = (String) session.getAttribute("username");

            if (key != null && username != null) {
                if (!key.equals("dsjhf.FDS!543|5G*DFgfdrhd%#454GDfgDb" + username)) {
                    error = true;
                }
            } else {
                error = true;
            }
        }
        if (error) {
            // En el caso de que no exista la sesión o la sesion es incorrecta
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");

            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
