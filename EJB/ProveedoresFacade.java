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
import modelo.Proveedores;

/**
 *
 * @author DAVID
 */
@Stateless
public class ProveedoresFacade extends AbstractFacade<Proveedores> implements ProveedoresFacadeLocal {

    @PersistenceContext(unitName = "taller_TallerMKII_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedoresFacade() {
        super(Proveedores.class);
    }

    @Override
    public Proveedores getProveedor(String nombre) {
        Proveedores pro = null;
        String consultaTSQL;
        consultaTSQL = "FROM Proveedores p Where p.nombre=:param1";
        Query query = em.createQuery(consultaTSQL);
        query.setParameter("param1",nombre);
        List<Proveedores> listaPro = query.getResultList();
        if(listaPro.isEmpty()==false){
            pro= listaPro.get(0);
        }
        return pro;
    }
    
}
