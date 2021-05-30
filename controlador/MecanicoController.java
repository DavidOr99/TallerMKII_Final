/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import EJB.MecanicosFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Mecanicos;
/**
 *
 * @author DAVID
 */
@Named
@ViewScoped
public class MecanicoController implements Serializable{
    private Mecanicos mec;
    @EJB
    private MecanicosFacadeLocal mecEJB;
    
    @PostConstruct
    public void init(){
        mec= new Mecanicos();
    }

    public Mecanicos getMec() {
        return mec;
    }

    public void setMec(Mecanicos mec) {
        this.mec = mec;
    }

    public MecanicosFacadeLocal getMecEJB() {
        return mecEJB;
    }

    public void setmecEJB(MecanicosFacadeLocal mecEJB) {
        this.mecEJB = mecEJB;
    }
    
    public void insertarMecanico(){
        mecEJB.create(mec);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarMecanico(){
        List<Mecanicos> lista = mecEJB.findAll();
        Mecanicos aux = null;
        for (Mecanicos lista1 : lista) {
            if(lista1.getNif().equals(mec.getNif())){
                aux=lista1;
                break;
            }
        }
        mecEJB.remove(aux);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
