/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Coaches;
import entities.Players;
import entities.Schools;
import entities.Teams;
import exceptions.QuidditchException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author JOSEP Mª
 */
@Stateless
public class QuidditchEJB {

    @PersistenceUnit
    EntityManagerFactory emf;

    // ----------------------------------- Insert Users ----------------------------------------
    public void insertJugador(Players p) throws QuidditchException {
        EntityManager em = emf.createEntityManager();
        Players aux = em.find(Players.class, p.getUsername());
        if (aux != null) {
            em.close();
            throw new QuidditchException("El Jugador ya esta registrado en la base de datos");
        }
        em.persist(p);
        em.close();
    }

    public void insertEntrenador(Coaches e) throws QuidditchException {
        EntityManager em = emf.createEntityManager();
        Coaches aux = em.find(Coaches.class, e.getUsername());
        if (aux != null) {
            em.close();
            throw new QuidditchException("La Escuela ya esta registrado en la base de datos");
        }
        em.persist(e);
        em.close();
    }

    public void insertEscuela(Schools s) throws QuidditchException {
        EntityManager em = emf.createEntityManager();
        Schools aux = em.find(Schools.class, s.getUsername());
        if (aux != null) {
            em.close();
            throw new QuidditchException("La Escuela ya esta registrado en la base de datos");
        }
        em.persist(s);
        em.close();
    }

    public void crearPartido() {
        EntityManager em = emf.createEntityManager();

    }

// -----------------------------------Logins----------------------------------------
    public boolean loginSchool(String username, String password) throws QuidditchException {
        EntityManager em = emf.createEntityManager();

        Schools aux = em.find(Schools.class, username);
        if (aux != null && aux.getPassword().equalsIgnoreCase(password)) {
            em.close();
            return true;
        } else {
            em.close();
            throw new QuidditchException("Nombre de usuario o password incorrectos");
        }
    }

    public boolean loginPlayer(String username, String password) throws QuidditchException {
        EntityManager em = emf.createEntityManager();

        Players aux = em.find(Players.class, username);
        if (aux != null && aux.getPassword().equalsIgnoreCase(password)) {
            em.close();
            return true;
        } else {
            em.close();
            throw new QuidditchException("Nombre de usuario o password incorrectos");
        }
    }

    public boolean loginCoach(String username, String password) throws QuidditchException {
        EntityManager em = emf.createEntityManager();

        Coaches aux = em.find(Coaches.class, username);
        if (aux != null && aux.getPassword().equalsIgnoreCase(password)) {
            em.close();
            return true;
        } else {
            em.close();
            throw new QuidditchException("Nombre de usuario o password incorrectos");
        }
    }
// ---------------------------------------------------------------------------------

// -----------------------------------Select Users----------------------------------------
    public List<String> selectAllCoaches() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select c.username from Coaches c");
        List<String> coaches = q.getResultList();
        em.close();
        return coaches;
    }

    public List<String> selectAllPlayers() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select p.username from Players p");
        List<String> coaches = q.getResultList();
        em.close();
        return coaches;
    }

    public List<String> selectAllTeams() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select t.fullName from Teams t");
        List<String> teams = q.getResultList();
        em.close();
        return teams;
    }

    public List<String> selectAllSchools() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select s.username from Schools s");
        List<String> schools = q.getResultList();
        em.close();
        return schools;
    }
// ---------------------------------------------------------------------------------------

// -----------------------------------Select Users----------------------------------------
    public void modificarPerfilCoaches(String fullName, String password, String nombre) throws QuidditchException {
        EntityManager em = emf.createEntityManager();

        Coaches aux = em.find(Coaches.class, nombre);

        if (aux != null) {
            aux.setFullName(fullName);
            aux.setPassword(password);
        } else {
            em.close();
            throw new QuidditchException("Empleado no registrado");
        }
    }

    public void modificarPerfilPlayers(String fullName, String password, String nombre) throws QuidditchException {
        EntityManager em = emf.createEntityManager();

        Players aux = em.find(Players.class, nombre);

        if (aux != null) {
            aux.setFullName(fullName);
            aux.setPassword(password);
        } else {
            em.close();
            throw new QuidditchException("Empleado no registrado");
        }
    }

    public void modificarPerfilSchools(String fullName, String password, String nombre) throws QuidditchException {
        EntityManager em = emf.createEntityManager();

        Schools aux = em.find(Schools.class, nombre);

        if (aux != null) {
            aux.setFullName(fullName);
            aux.setPassword(password);
        } else {
            em.close();
            throw new QuidditchException("Empleado no registrado");
        }
    }

// ---------------------------------------------------------------------------------------
// -----------------------------------Delete Users----------------------------------------
    public void borrarPlayers(String players) throws QuidditchException {
        EntityManager em = emf.createEntityManager();
        Players aux = em.find(Players.class, players);
        if (aux != null) {
            em.remove(aux);
            em.close();
        } else {
            em.close();
            throw new QuidditchException("No existe ese usuario");

        }
    }

    public void borrarTeams(String teams) throws QuidditchException {
        EntityManager em = emf.createEntityManager();
        Teams aux = em.find(Teams.class, teams);
        if (aux != null) {
            em.remove(aux);
            em.close();
        } else {
            em.close();
            throw new QuidditchException("No existe ese usuario");

        }
    }

    public void borrarCoaches(String coaches) throws QuidditchException {
        EntityManager em = emf.createEntityManager();
        Coaches aux = em.find(Coaches.class, coaches);
        if (aux != null) {
            em.remove(aux);
            em.close();
        } else {
            em.close();
            throw new QuidditchException("No existe ese usuario");

        }
    }

// ---------------------------------------------------------------------------------------
    
// -----------------------------------Listados----------------------------------------
    public List<Schools> getListadoEscuelas() {
        return emf.createEntityManager().createNamedQuery("Schools.findAll").getResultList();
    }

    public List<Teams> getListadoEquipos() {
        return emf.createEntityManager().createNamedQuery("Teams.findAll").getResultList();
    }

    public List<Players> getListadoJugadores() {
        return emf.createEntityManager().createNamedQuery("Players.findAll").getResultList();
    }

    public List<Coaches> getListadoEntrenadores() {
        return emf.createEntityManager().createNamedQuery("Coaches.findAll").getResultList();
    }
// ---------------------------------------------------------------------------------------

}
