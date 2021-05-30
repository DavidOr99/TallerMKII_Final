/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.AlmacenFacadeLocal;
import EJB.PedidosFacadeLocal;
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
import modelo.Almacen;
import modelo.Pedidos;
import modelo.Proveedores;

/**
 *
 * @author DAVID
 */
@Named
@ViewScoped
public class AlmacenController implements Serializable{
    private Almacen alm;
    private Proveedores pro;
    private Pedidos ped;
    
    @EJB
    private AlmacenFacadeLocal almEJB;
    
    @EJB
    private ProveedoresFacadeLocal proEJB;
    
    @EJB
    private PedidosFacadeLocal pedEJB;
    
    @PostConstruct
    public void init(){
        alm= new Almacen();
        pro=new Proveedores();
        ped=new Pedidos();
    }

    public Almacen getAlm() {
        return alm;
    }

    public void setAlm(Almacen alm) {
        this.alm = alm;
    }

    public Proveedores getPro() {
        return pro;
    }

    public void setPro(Proveedores pro) {
        this.pro = pro;
    }
    
    public Pedidos getPed() {
        return ped;
    }

    public void setPed(Pedidos ped) {
        this.ped = ped;
    }

    public AlmacenFacadeLocal getAlmEJB() {
        return almEJB;
    }

    public void setAlmEJB(AlmacenFacadeLocal almEJB) {
        this.almEJB = almEJB;
    }

    public ProveedoresFacadeLocal getProEJB() {
        return proEJB;
    }

    public void setProEJB(ProveedoresFacadeLocal proEJB) {
        this.proEJB = proEJB;
    }

    public PedidosFacadeLocal getPedEJB() {
        return pedEJB;
    }

    public void setPedEJB(PedidosFacadeLocal pedEJB) {
        this.pedEJB = pedEJB;
    }
    
    public void insertarArticulo(){
        pro = proEJB.getProveedor(pro.getNombre());
        ped = pedEJB.find(ped.getIdPedido());
        alm.setProveedor(pro);
        alm.setPedido(ped);
        almEJB.create(alm);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarArticulo(){
        List<Almacen> lista = almEJB.findAll();
        Almacen aux = null;
        for (Almacen lista1 : lista) {
            if(lista1.getNombre().equals(alm.getNombre())){
                aux=lista1;
                break;
            }
        }
        almEJB.remove(aux);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
