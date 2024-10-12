package service;

import configuration.MySqlConexion;
import dao.UsuarioDao;
import dao.UsuarioDaoSp;
import dao.UsuarioRepository;
import model.Usuario;

import java.sql.SQLException;

public class LoginServiceImpl implements ILogin{

    @Override
    public Usuario login(String usuario, String clave) throws SQLException, ClassNotFoundException {
//        UsuarioDao dao = new UsuarioDao(new MySqlConexion());
        UsuarioRepository dao = new UsuarioDaoSp(new MySqlConexion());
        return dao.obtenerUsuario(usuario,clave);
    }
}
