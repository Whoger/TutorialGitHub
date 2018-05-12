/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
    
    public boolean loginUsuario(String nombreusuario, String password) throws QuidditchException {
        EntityManager em = emf.createEntityManager();
        
        Empleado aux = em.find(Empleado.class, nombreusuario);
        
        if (aux != null && aux.getPassword().equalsIgnoreCase(password)) {
            em.close();
            return true;
        } else {
            em.close();
            throw new QuidditchException("Nombre de usuario o password incorrectos");
        }
    }

}
