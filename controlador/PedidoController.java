/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
import modelo.Pedidos;
import modelo.Proveedores;
/**
 *
 * @author DAVID
 */
@Named
@ViewScoped
public class PedidoController implements Serializable{
    private Pedidos ped;
    private Proveedores pro;
    
    @EJB
    private PedidosFacadeLocal pedEJB;
    
    @EJB
    private ProveedoresFacadeLocal proEJB;
    
    @PostConstruct
    public void init(){
        ped= new Pedidos();
        pro=new Proveedores();
    }

    public Pedidos getPed() {
        return ped;
    }

    public void setPed(Pedidos ped) {
        this.ped = ped;
    }

        public Proveedores getPro() {
        return pro;
    }

    public void setPro(Proveedores pro) {
        this.pro = pro;
    }
    public PedidosFacadeLocal getPedEJB() {
        return pedEJB;
    }

    public void setPedEJB(PedidosFacadeLocal pedEJB) {
        this.pedEJB = pedEJB;
    }

    public ProveedoresFacadeLocal getProEJB() {
        return proEJB;
    }

    public void setProEJB(ProveedoresFacadeLocal proEJB) {
        this.proEJB = proEJB;
    }
    
    public void insertarPedido(){
        pro = proEJB.getProveedor(pro.getNombre());
        ped.setProveedor(pro);
        pedEJB.create(ped);
        proEJB.remove(proEJB.getProveedor(pro.getNombre()));
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarPedido(){
        List<Pedidos> lista = pedEJB.findAll();
        Pedidos aux = null;
        for (Pedidos lista1 : lista) {
            if(lista1.getContenido().equals(ped.getContenido())){
                aux=lista1;
                break;
            }
        }
        pedEJB.remove(aux);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}