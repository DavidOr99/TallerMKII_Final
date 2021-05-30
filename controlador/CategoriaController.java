/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.Categoria_ReparacionFacadeLocal;
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
import modelo.Categoria_Reparacion;
/**
 *
 * @author DAVID
 */
@Named
@ViewScoped
public class CategoriaController implements Serializable{
    private Categoria_Reparacion cat;
    @EJB
    private Categoria_ReparacionFacadeLocal catEJB;
    
    @PostConstruct
    public void init(){
        cat= new Categoria_Reparacion();
    }

    public Categoria_Reparacion getCat() {
        return cat;
    }

    public void setCat(Categoria_Reparacion cat) {
        this.cat = cat;
    }

    public Categoria_ReparacionFacadeLocal getCatEJB() {
        return catEJB;
    }

    public void setCatEJB(Categoria_ReparacionFacadeLocal catEJB) {
        this.catEJB = catEJB;
    }
    
    public void insertarCategoria_Reparacion(){
        catEJB.create(cat);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarCategoria_Reparacion(){
        List<Categoria_Reparacion> lista = catEJB.findAll();
        Categoria_Reparacion aux = null;
        for (Categoria_Reparacion lista1 : lista) {
            if(lista1.getNombre().equals(cat.getNombre())){
                aux=lista1;
                break;
            }
        }
        catEJB.remove(aux);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
