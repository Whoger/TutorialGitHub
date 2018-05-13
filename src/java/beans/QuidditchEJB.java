/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Coaches;
import entities.Players;
import entities.Schools;
import exceptions.QuidditchException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author JOSEP Mª
 */
@Stateless
public class QuidditchEJB {

    @PersistenceUnit
    EntityManagerFactory emf;

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

}
