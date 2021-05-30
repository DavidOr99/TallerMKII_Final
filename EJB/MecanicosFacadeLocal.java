/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Mecanicos;

/**
 *
 * @author DAVID
 */
@Local
public interface MecanicosFacadeLocal {

    void create(Mecanicos mecanicos);

    void edit(Mecanicos mecanicos);

    void remove(Mecanicos mecanicos);

    Mecanicos find(Object id);

    List<Mecanicos> findAll();

    List<Mecanicos> findRange(int[] range);

    int count();

    public Mecanicos getMecanico(String nif);
    
}
