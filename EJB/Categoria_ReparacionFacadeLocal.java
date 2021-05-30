/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Categoria_Reparacion;

/**
 *
 * @author DAVID
 */
@Local
public interface Categoria_ReparacionFacadeLocal {

    void create(Categoria_Reparacion categoria_Reparacion);

    void edit(Categoria_Reparacion categoria_Reparacion);

    void remove(Categoria_Reparacion categoria_Reparacion);

    Categoria_Reparacion find(Object id);

    List<Categoria_Reparacion> findAll();

    List<Categoria_Reparacion> findRange(int[] range);

    int count();

    public Categoria_Reparacion getCategoria(String nombre);
    
}
