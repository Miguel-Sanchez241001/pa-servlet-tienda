package pe.edu.autonoma.tienda.dao;

import pe.edu.autonoma.tienda.conexion.Conexion;
import pe.edu.autonoma.tienda.entity.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDao {
    private Connection conn;
    private PreparedStatement ps;

    public UsuarioDao() {
        conn = Conexion.openConnection();
    }
    // Métodos CRUD
    // id, username, password, enable, name
    // Create
    public void insert( Usuario usuario ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "INSERT INTO usuario (username, password, enable, name ) " +
                    "VALUES (?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            int tempEnable = (usuario.isEnable() ? 1 : 0 );
            ps.setInt(3, tempEnable);
            ps.setString(4, usuario.getName());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }
    // READ
    // findAll, listar, list, fetchAll, getAll
    public List<Usuario> list() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM  usuario";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                boolean tempEnable = (rs.getInt("enable") == 1 ? true : false );
                Usuario usuario = new Usuario( rs.getInt("id"), rs.getString("username"),
                        rs.getString("password"), tempEnable,
                        rs.getString("name"));

                usuarios.add(usuario);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return usuarios;
    }
    // findById, GetById, GetEntity, listarId, findId
    public Optional<Usuario> findId(Integer id) {
        Optional<Usuario> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  usuario WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if( rs.next() ) {
                boolean tempEnable = (rs.getInt("enable") == 1 ? true : false );
                Usuario usuario = new Usuario( rs.getInt("id"), rs.getString("username"),
                        rs.getString("password"), tempEnable,
                        rs.getString("name"));

                optional = Optional.of(usuario);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }
    // findBy____ : Buscar por un atributo, findByDni
    // fetchBy_____: Todos los demás queries, fetchByBornJanuary
    //
    public Optional<Usuario> findByUsername(String username) {
        Optional<Usuario> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM usuario WHERE username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if( rs.next() ) {
                boolean tempEnable = (rs.getInt("enable") == 1 ? true : false );
                Usuario usuario = new Usuario( rs.getInt("id"), rs.getString("username"),
                        rs.getString("password"), tempEnable,
                        rs.getString("name"));

                optional = Optional.of(usuario);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }

    //UPDATE
    // actualizar, update,
    public void update( Usuario usuario ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {  // id, username, password, enable, name
            int tempEnable = (usuario.isEnable() ? 1 : 0 );
            String sql = "UPDATE usuario SET username = ?, password = ?, enable = ?, name = ? " +
                    "WHERE id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            ps.setInt(3, tempEnable);
            ps.setString(4, usuario.getName());
            ps.setInt(5, usuario.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

    //DELETE
    // borrarID, deleteId, deleteById,
    public void deleteId( Integer id ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "DELETE FROM usuario WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

}
