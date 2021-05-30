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
import modelo.Mecanicos;

/**
 *
 * @author DAVID
 */
@Stateless
public class MecanicosFacade extends AbstractFacade<Mecanicos> implements MecanicosFacadeLocal {

    @PersistenceContext(unitName = "taller_TallerMKII_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MecanicosFacade() {
        super(Mecanicos.class);
    }

    @Override
    public Mecanicos getMecanico(String nif) {
        Mecanicos pro = null;
        String consultaTSQL;
        consultaTSQL = "FROM Mecanicos m Where m.nif=:param1";
        Query query = em.createQuery(consultaTSQL);
        query.setParameter("param1",nif);
        List<Mecanicos> listaPro = query.getResultList();
        if(listaPro.isEmpty()==false){
            pro= listaPro.get(0);
        }
        return pro;
    }
}
