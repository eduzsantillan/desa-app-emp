package dao;

import configuration.ConexionBd;
import configuration.MySqlConexion;
import exceptions.UsuarioNoEncontradoException;
import model.Usuario;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class UsuarioDaoSp implements UsuarioRepository{

    ConexionBd connection;

    public UsuarioDaoSp(MySqlConexion conexion){
        connection = conexion;
    }

    @Override
    public Usuario obtenerUsuario(String usuario, String clave) throws SQLException, ClassNotFoundException {
        String sql = "{CALL sp_login(?,?,?)}";
        CallableStatement callableStatement = connection.getConnection().prepareCall(sql);
        callableStatement.setString(1, usuario);
        callableStatement.setString(2, clave);

        callableStatement.registerOutParameter(3, Types.BOOLEAN);


        Boolean resultado = callableStatement.execute();

        if(resultado){
            ResultSet resultSet = callableStatement.getResultSet();
            Usuario usuarioEncontrado= null;
            while(resultSet.next()){
                usuarioEncontrado = usuarioMapper(resultSet);
            }
            return usuarioEncontrado;
        }else{
            throw new UsuarioNoEncontradoException("Usuario no existe");
        }
    }


    private Usuario usuarioMapper(ResultSet resultSet) throws SQLException {
        return new Usuario(resultSet.getString("nombres_completos"),
                resultSet.getString("user"),
                resultSet.getString("password"));
    }
}
