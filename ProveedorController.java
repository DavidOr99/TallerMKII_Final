/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ProveedoresFacadeLocal;
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
import modelo.Proveedores;

/**
 *
 * @author DAVID
 */
@Named(value="proveedorController")
@ViewScoped
public class ProveedorController implements Serializable{
    private Proveedores pro;
    @EJB
    private ProveedoresFacadeLocal provEJB;
    
    @PostConstruct
    public void init(){
        pro= new Proveedores();
    }

    public Proveedores getPro() {
        return pro;
    }

    public void setPro(Proveedores pro) {
        this.pro = pro;
    }

    public ProveedoresFacadeLocal getProvEJB() {
        return provEJB;
    }

    public void setProvEJB(ProveedoresFacadeLocal provEJB) {
        this.provEJB = provEJB;
    }
    
    public void insertarProveedor(){
        provEJB.create(pro);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarProveedor(){
        List<Proveedores> lista = provEJB.findAll();
        Proveedores aux = null;
        for (Proveedores lista1 : lista) {
            if(lista1.getNombre().equals(pro.getNombre())){
                aux=lista1;
                break;
            }
        }
        provEJB.remove(aux);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
