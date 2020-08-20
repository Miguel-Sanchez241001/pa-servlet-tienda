package pe.edu.autonoma.tienda.dao;

import pe.edu.autonoma.tienda.conexion.Conexion;

import pe.edu.autonoma.tienda.entity.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoDao {
    private Connection conn;
    private PreparedStatement ps;

    public ProductoDao() {
        conn = Conexion.openConnection();
    }

    public void insert( Producto Producto ) {
        try {
            String sql = "INSERT INTO productos (descripcion,stock,marca,categoria) " +
                    "VALUES (?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, Producto.getDescripcion());
            ps.setInt(2, Producto.getStock());
            ps.setString(3, Producto.getMarca());
            ps.setString(4, Producto.getCategoria());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Producto> list() {
        List<Producto> productotb = new ArrayList<>();
        try {
            String sql = "SELECT * FROM  productos";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Producto producto=new Producto(rs.getInt("id"),
                        rs.getString("descripcion"),
                        rs.getInt("stock") ,
                        rs.getString("marca") ,
                        rs.getString("categoria")
                );
                productotb.add(producto);
            }

            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return productotb;
    }

    public Optional<Producto> findId(Integer ID) {
        Optional<Producto> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  productos WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ) {
                Producto productotb = new Producto(rs.getInt("id"),
                        rs.getString("descripcion"),
                        rs.getInt("stock") ,
                        rs.getString("marca") ,
                        rs.getString("categoria")
                );
                optional = Optional.of(productotb);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }

    public void update( Producto producto ) {
        try {
            String sql = "UPDATE productos SET descripcion = ?, stock = ?, marca = ?, categoria = ? " +
                    "WHERE id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getStock());
            ps.setString(3, producto.getMarca());
            ps.setString(4, producto.getCategoria());
            ps.setInt(5, producto.getId());

            ps.executeUpdate();
            ps.close();
            System.out.println("se actualizo");
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

    public void deleteId( Integer ID ) {
        try {
            String sql = "DELETE FROM productos WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }
















}
