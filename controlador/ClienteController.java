/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ClienteFacadeLocal;
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
import modelo.Cliente;
/**
 *
 * @author DAVID
 */
@Named
@ViewScoped
public class ClienteController implements Serializable{
    private Cliente cli;
    @EJB
    private ClienteFacadeLocal cliEJB;
    
    @PostConstruct
    public void init(){
        cli= new Cliente();
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public ClienteFacadeLocal getCliEJB() {
        return cliEJB;
    }

    public void setCliEJB(ClienteFacadeLocal cliEJB) {
        this.cliEJB = cliEJB;
    }
    
    public void insertarCliente(){
        cliEJB.create(cli);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarCliente(){
        List<Cliente> lista = cliEJB.findAll();
        Cliente aux = null;
        for (Cliente lista1 : lista) {
            if(lista1.getNif().equals(cli.getNif())){
                aux=lista1;
                break;
            }
        }
        cliEJB.remove(aux);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}