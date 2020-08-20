package pe.edu.autonoma.tienda.dao;

import pe.edu.autonoma.tienda.conexion.Conexion;
import pe.edu.autonoma.tienda.entity.Cliente;
import pe.edu.autonoma.tienda.entity.Producto;
import pe.edu.autonoma.tienda.entity.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VentaDao {
    private Connection conn;
    private PreparedStatement ps;
    private ClienteDao clienteDao;
    private ProductoDao productoDao;
    public VentaDao() {
        conn = Conexion.openConnection();
        clienteDao = new ClienteDao();
        productoDao = new ProductoDao();
    }

    public void insert( Venta venta ) {

        try {
            String sql = "INSERT INTO ventas (cliente_id,producto_id,monto,cantidad, " +
                    "fecha) " +
                    "VALUES (?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, venta.getClienteId().getId());
            ps.setInt(2, venta.getProductoId().getId());
            ps.setInt(3, venta.getMonto());
            ps.setInt(4, venta.getCantidad());
            ps.setString(5, venta.getFecha());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }

    public List<Venta> list() {
        List<Venta> ventaList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM  ventas";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                int idCliente = rs.getInt("cliente_id");
                int idProducto = rs.getInt("producto_id");
                Optional<Cliente> optionalClientes = clienteDao.findId( idCliente );
                Optional<Producto> optionalProductos = productoDao.findId( idProducto );

                Venta venta1 = new Venta( rs.getInt("id"),optionalClientes.get(),
                        optionalProductos.get(), rs.getInt("monto"), rs.getInt("cantidad"),
                        rs.getString("fecha")
                       );
                ventaList.add(venta1);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return ventaList;
    }

    public Optional<Venta> findId(Integer id) {

        Optional<Venta> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  ventas WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ) {
                int idCliente = rs.getInt("cliente_id");
                int idProducto = rs.getInt("producto_id");
                Optional<Cliente> optionalClientes = clienteDao.findId( idCliente );
                Optional<Producto> optionalProductos = productoDao.findId( idProducto );
                Venta venta1 = new Venta( rs.getInt("id"),optionalClientes.get(),
                        optionalProductos.get(), rs.getInt("monto"), rs.getInt("cantidad"),
                        rs.getString("fecha")
                );

                optional = Optional.of(venta1);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }

    public void update( Venta venta ) {
        try {
            String sql = "UPDATE ventas SET cliente_id = ?, producto_id = ?,monto = ?,cantidad = ?, " +
                    "fecha= ?  " +
                    "WHERE id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, venta.getClienteId().getId());
            ps.setInt(2, venta.getProductoId().getId());
            ps.setInt(3, venta.getMonto());
            ps.setInt(4, venta.getCantidad());
            ps.setString(5, venta.getFecha());
            ps.setInt(6, venta.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

    public void deleteId( Integer ID ) {
        try {
            String sql = "DELETE FROM ventas WHERED id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }
































}
