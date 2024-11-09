package controller;

import dao.PersonaDao;
import model.Persona;
import repository.PersonaRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class PersonaDeleteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPersona = Integer.parseInt(req.getParameter("id"));
        PersonaRepository repository = new PersonaDao();
        Persona personaToDelete = repository.findById(idPersona);
        req.setAttribute("personaDelete", personaToDelete);
        req.getRequestDispatcher("/delete.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPersona = Integer.parseInt(req.getParameter("id"));
        PersonaRepository repository = new PersonaDao();
        repository.delete(idPersona);
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
