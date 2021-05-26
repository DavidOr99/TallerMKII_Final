/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Vehiculos;

/**
 *
 * @author DAVID
 */
@Stateless
public class VehiculosFacade extends AbstractFacade<Vehiculos> implements VehiculosFacadeLocal {

    @PersistenceContext(unitName = "taller_TallerMKII_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculosFacade() {
        super(Vehiculos.class);
    }
    
}
