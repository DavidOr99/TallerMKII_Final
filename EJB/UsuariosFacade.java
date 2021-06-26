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
import modelo.Usuarios;

/**
 *
 * @author DAVID
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "taller_TallerMKII_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public Usuarios iniciarSesion(Usuarios usuario) {
        Usuarios us = null;
        String consultaTSQL;
            consultaTSQL  = "FROM Usuarios u WHERE u.usuario=:param1 and u.contrasenia=:param2"; 
            Query query = em.createQuery(consultaTSQL);
            query.setParameter("param1",usuario.getUsuario());
            query.setParameter("param2",usuario.getContrasenia());
            List<Usuarios> listaUsuariosEnCuestion = query.getResultList();
        if(listaUsuariosEnCuestion.isEmpty()==false){
            us= listaUsuariosEnCuestion.get(0);
        }
        return us;
    } 
}
