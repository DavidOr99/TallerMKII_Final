/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Override
    public Vehiculos getVehiculo(String matricula) {
        Vehiculos pro = null;
        String consultaTSQL;
        consultaTSQL = "FROM Vehiculos v Where v.matricula=:param1";
        Query query = em.createQuery(consultaTSQL);
        query.setParameter("param1",matricula);
        List<Vehiculos> listaPro = query.getResultList();
        if(listaPro.isEmpty()==false){
            pro= listaPro.get(0);
        }
        return pro;
    }
}
