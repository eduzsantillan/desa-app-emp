package service;

import model.Usuario;

import java.sql.SQLException;

public interface ILogin {
    Usuario login (String usuario, String clave) throws SQLException, ClassNotFoundException;
}
