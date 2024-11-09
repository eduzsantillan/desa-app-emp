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

@WebServlet("/details")
public class PersonaDetailsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPersona = Integer.parseInt(req.getParameter("id"));
        PersonaRepository repository = new PersonaDao();
        Persona persona = repository.findById(idPersona);
        req.setAttribute("persona", persona);
        req.getRequestDispatcher("/details.jsp").forward(req, resp);
    }
}
