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

    @Override
    public Categoria_Reparacion getCategoria(String nombre) {
        Categoria_Reparacion pro = null;
        String consultaTSQL;
        consultaTSQL = "FROM Categoria_Reparacion r Where r.nombre=:param1";
        Query query = em.createQuery(consultaTSQL);
        query.setParameter("param1",nombre);
        List<Categoria_Reparacion> listaPro = query.getResultList();
        if(listaPro.isEmpty()==false){
            pro= listaPro.get(0);
        }
        return pro;
    } 
}
