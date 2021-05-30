/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ClienteFacadeLocal;
import EJB.VehiculosFacadeLocal;
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
import modelo.Vehiculos;

/**
 *
 * @author DAVID
 */
@Named
@ViewScoped
public class VehiculoController implements Serializable{
    private Vehiculos veh;
    private Cliente cli;
    
    @EJB
    private VehiculosFacadeLocal vehEJB;
    
    @EJB
    private ClienteFacadeLocal cliEJB;
    
    @PostConstruct
    public void init(){
        veh= new Vehiculos();
        cli=new Cliente();
    }

    public Vehiculos getVeh() {
        return veh;
    }

    public void setVeh(Vehiculos veh) {
        this.veh = veh;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }
    public VehiculosFacadeLocal getVehEJB() {
        return vehEJB;
    }

    public void setVehEJB(VehiculosFacadeLocal vehEJB) {
        this.vehEJB = vehEJB;
    }

    public ClienteFacadeLocal getCliEJB() {
        return cliEJB;
    }

    public void setCliEJB(ClienteFacadeLocal cliEJB) {
        this.cliEJB = cliEJB;
    }
    
    public void insertarVehiculo(){
        cli = cliEJB.getCliente(cli.getNif());
        veh.setCliente(cli);
        vehEJB.create(veh);
        cliEJB.remove(cliEJB.getCliente(cli.getNif()));
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarVehiculo(){
        List<Vehiculos> lista = vehEJB.findAll();
        Vehiculos aux = null;
        for (Vehiculos lista1 : lista) {
            if(lista1.getMatricula().equals(veh.getMatricula())){
                aux=lista1;
                break;
            }
        }
        vehEJB.remove(aux);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(ProveedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
