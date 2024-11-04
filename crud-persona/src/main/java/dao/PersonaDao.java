package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Persona;
import repository.PersonaRepository;

import java.util.List;

public class PersonaDao implements PersonaRepository {

    private final EntityManager entityManager;

    public PersonaDao(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("devUnit");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Persona> getAll(){
        TypedQuery<Persona> query = entityManager.createQuery("SELECT p FROM Persona p", Persona.class);
        return query.getResultList();
    }

    public void save(Persona persona){
        entityManager.getTransaction().begin();
        entityManager.persist(persona);
        entityManager.getTransaction().commit();
    }
}
