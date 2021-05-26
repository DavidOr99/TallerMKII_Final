/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Reparaciones;

/**
 *
 * @author DAVID
 */
@Stateless
public class ReparacionesFacade extends AbstractFacade<Reparaciones> implements ReparacionesFacadeLocal {

    @PersistenceContext(unitName = "taller_TallerMKII_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReparacionesFacade() {
        super(Reparaciones.class);
    }
    
}
