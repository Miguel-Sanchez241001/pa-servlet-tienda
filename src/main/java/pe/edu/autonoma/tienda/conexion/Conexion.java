package pe.edu.autonoma.tienda.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static Connection conn;
    public static Connection openConnection() {
        if ( conn != null )
            return conn;

        try {
            String usuario = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/dbtienda?useSSL=false&serverTimezone=UTC";

            // Establecer el Driver de conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);

            System.out.println("Conectamos");

        } catch (Exception e) {
            System.out.println( e.getMessage() );
            System.out.println("Algo salio mal :( ");
        }
        return conn;
    }
    public static void closeConnection() {
        try {
            if( conn != null ) {
                conn.close();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

}

