package pe.edu.autonoma.tienda.dao;

import pe.edu.autonoma.tienda.conexion.Conexion;
import pe.edu.autonoma.tienda.entity.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDao {
    private Connection conn;
    private PreparedStatement ps;

    public ClienteDao() {
        conn = Conexion.openConnection();
    }

    public void insert( Cliente Cliente ) {

        try {
            String sql = "INSERT INTO clientes (apellidos_nombres,tipo_documento,numero_documento,direccion) " +
                    "VALUES (?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, Cliente.getApellidoNombre());
            ps.setString(2, Cliente.getTipoDocumento());
            ps.setString(3, Cliente.getNumeroDocumento());
            ps.setString(4, Cliente.getDireccion());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Cliente> list() {
        List<Cliente> clientetb = new ArrayList<>();
        try {
            String sql = "SELECT * FROM  clientes";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Cliente cliente=new Cliente(rs.getInt("id"),rs.getString("apellidos_nombres"),rs.getString("tipo_documento") ,rs.getString("numero_documento") ,rs.getString("direccion")
                );
                clientetb.add(cliente);
            }

            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return clientetb;
    }

    public Optional<Cliente> findId(Integer ID) {
        Optional<Cliente> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  clientes WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ) {
                Cliente clientetb = new Cliente(rs.getInt("id"),rs.getString("apellidos_nombres"),rs.getString("tipo_documento") ,rs.getString("numero_documento") ,rs.getString("direccion")
                );
                optional = Optional.of(clientetb);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }

    public void update( Cliente cliente ) {
        try {
            String sql = "UPDATE clientes SET apellidos_nombres = ?, tipo_documento = ?, numero_documento = ?, direccion = ? " +
                    "WHERE id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getApellidoNombre());
            ps.setString(2, cliente.getTipoDocumento());
            ps.setString(3, cliente.getNumeroDocumento());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getId());

            ps.executeUpdate();
            ps.close();
            System.out.println("se actualizo");
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

    public void deleteId( Integer ID ) {
        try {
            String sql = "DELETE FROM clientes WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

















}
