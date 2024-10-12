package dao;

import model.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository {
    Usuario obtenerUsuario(String usuario, String clave) throws SQLException, ClassNotFoundException;
}
