package repository;

import model.Persona;

import java.util.List;

public interface PersonaRepository {
    List<Persona> getAll();
    void save(Persona persona);
    Persona findById(Integer id);
    void update(Persona persona);
    void delete(Integer id);
}
