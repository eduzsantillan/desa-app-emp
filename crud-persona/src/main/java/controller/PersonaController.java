package controller;

import dao.PersonaDao;
import model.Persona;
import repository.PersonaRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class PersonaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonaRepository personaRepository = new PersonaDao();
        List<Persona> personas = personaRepository.getAll();


        List<Persona> personasFiltradas = personas.stream()
                .filter(p -> p.getEstado().equalsIgnoreCase("activo"))
                .toList();


        req.setAttribute("personas", personas);
        req.setAttribute("title", "Personas");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String nacionalidad = req.getParameter("nacionalidad");
        String estado = req.getParameter("estado");
        String correo = req.getParameter("correo");
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setNacionalidad(nacionalidad);
        persona.setEstado(estado);
        persona.setCorreo(correo);
        PersonaRepository personaRepository = new PersonaDao();
        personaRepository.save(persona);
        resp.sendRedirect(req.getContextPath() + "/");
    }

}
