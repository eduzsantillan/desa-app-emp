package controller;

import exceptions.UsuarioNoEncontradoException;
import model.Usuario;
import service.ILogin;
import service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ingreso")
public class LoginServlet extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String usuario = req.getParameter("usuario");
        String clave = req.getParameter("clave");

        ILogin login = new LoginServiceImpl();
        Usuario obj = null;
        try {
            obj = login.login(usuario,clave);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UsuarioNoEncontradoException e){
            resp.sendRedirect("error.jsp");
        }
        if(obj!=null){
            HttpSession session = req.getSession();
            session.setAttribute("user",usuario);
            resp.sendRedirect("bienvenido.jsp");
        }
    }
}
