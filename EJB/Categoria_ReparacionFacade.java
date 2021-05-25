/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Categoria_Reparacion;

/**
 *
 * @author DAVID
 */
@Stateless
public class Categoria_ReparacionFacade extends AbstractFacade<Categoria_Reparacion> implements Categoria_ReparacionFacadeLocal {

    @PersistenceContext(unitName = "taller_TallerMKII_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Categoria_ReparacionFacade() {
        super(Categoria_Reparacion.class);
    }
    
}
