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
import modelo.Pedidos;

/**
 *
 * @author DAVID
 */
@Stateless
public class PedidosFacade extends AbstractFacade<Pedidos> implements PedidosFacadeLocal {

    @PersistenceContext(unitName = "taller_TallerMKII_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidosFacade() {
        super(Pedidos.class);
    }

    @Override
    public Pedidos getPedido(String contenido) {
        Pedidos pro = null;
        String consultaTSQL;
        consultaTSQL = "FROM Pedidos p Where p.contenido=:param1";
        Query query = em.createQuery(consultaTSQL);
        query.setParameter("param1",contenido);
        List<Pedidos> listaPro = query.getResultList();
        if(listaPro.isEmpty()==false){
            pro= listaPro.get(0);
        }
        return pro;
    }
    
}
