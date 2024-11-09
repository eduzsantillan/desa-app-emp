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

@WebServlet("/edit")
public class PersonaEditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPersona = Integer.parseInt(req.getParameter("id"));
        PersonaRepository repository = new PersonaDao();
        Persona personaToEdit = repository.findById(idPersona);
        req.setAttribute("personaEdit", personaToEdit);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPersona = Integer.parseInt(req.getParameter("id"));
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String nacionalidad = req.getParameter("nacionalidad");
        String estado = req.getParameter("estado");
        String correo = req.getParameter("correo");
        Persona persona = new Persona();
        persona.setId(idPersona);
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setNacionalidad(nacionalidad);
        persona.setEstado(estado);
        persona.setCorreo(correo);
        PersonaRepository repository = new PersonaDao();
        repository.update(persona);
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
