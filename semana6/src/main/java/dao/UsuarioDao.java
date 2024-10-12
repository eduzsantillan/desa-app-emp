package dao;

import configuration.ConexionBd;
import configuration.MySqlConexion;
import exceptions.UsuarioNoEncontradoException;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao implements UsuarioRepository{

    ConexionBd connection;


    public UsuarioDao(MySqlConexion mySqlConexion){
        connection = mySqlConexion;
    }

    @Override
    public Usuario obtenerUsuario(String usuario, String clave) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM usuario where user= ? and password =?";
        PreparedStatement pstmt = connection.getConnection()
                .prepareStatement(sql);
        pstmt.setString(1, usuario);
        pstmt.setString(2, clave);

        ResultSet resultSet = pstmt.executeQuery();
        Usuario result = null;
        while(resultSet.next()) {
            result = usuarioMapper(resultSet);
        }
        if(result == null){
            throw new UsuarioNoEncontradoException("Usuario no existe");
        }
        return result;
    }

    private Usuario usuarioMapper(ResultSet resultSet) throws SQLException {
        return new Usuario(resultSet.getString("nombres_completos"),
                resultSet.getString("user"),
                resultSet.getString("password"));
    }
}
