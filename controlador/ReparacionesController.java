/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.Categoria_ReparacionFacadeLocal;
import EJB.VehiculosFacadeLocal;
import EJB.ClienteFacadeLocal;
import EJB.MecanicosFacadeLocal;
import EJB.ReparacionesFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Categoria_Reparacion;
import modelo.Cliente;
import modelo.Mecanicos;
import modelo.Reparaciones;
import modelo.Vehiculos;

/**
 *
 * @author DAVID
 */
@Named
@ViewScoped
public class ReparacionesController implements Serializable{
    private Reparaciones rep;
    private Mecanicos mec;
    private Vehiculos veh;
    private Cliente cli;
    private Categoria_Reparacion cat;
    
    @EJB
    private ReparacionesFacadeLocal repEJB;
    
    @EJB
    private VehiculosFacadeLocal vehEJB;
    
    @EJB
    private ClienteFacadeLocal cliEJB;
    
    @EJB
    private MecanicosFacadeLocal mecEJB;
    
    @EJB
    private Categoria_ReparacionFacadeLocal catEJB;
    
    @PostConstruct
    public void init(){
        rep = new Reparaciones();
        mec = new Mecanicos();
        veh = new Vehiculos();
        cli = new Cliente();
        cat = new Categoria_Reparacion();
    }

    public Reparaciones getRep() {
        return rep;
    }

    public void setRep(Reparaciones rep) {
        this.rep = rep;
    }

    public Mecanicos getMec() {
        return mec;
    }

    public void setMec(Mecanicos mec) {
        this.mec = mec;
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
    
     public Categoria_Reparacion getCat() {
        return cat;
    }

    public void setCat(Categoria_Reparacion cat) {
        this.cat = cat;
    }
    
    public ReparacionesFacadeLocal getRepEJB() {
        return repEJB;
    }

    public void setRepEJB(ReparacionesFacadeLocal repEJB) {
        this.repEJB = repEJB;
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

    public MecanicosFacadeLocal getMecEJB() {
        return mecEJB;
    }

    public void setMecEJB(MecanicosFacadeLocal mecEJB) {
        this.mecEJB = mecEJB;
    }

    public Categoria_ReparacionFacadeLocal getCatEJB() {
        return catEJB;
    }

    public void setCatEJB(Categoria_ReparacionFacadeLocal catEJB) {
        this.catEJB = catEJB;
    }
    
    public void crearFactura(){
        rep.setPrecio(Double.parseDouble(rep.getPrecio())*1.21+"");
        mec = mecEJB.getMecanico(mec.getNif());
        rep.setMecanico(mec);
        cli = cliEJB.getCliente(cli.getNif());
        rep.setCliente(cli);
        veh = vehEJB.getVehiculo(veh.getMatricula());
        rep.setCoche(veh);
        cat = catEJB.getCategoria(cat.getNombre());
        rep.setCategoria(cat);
        repEJB.create(rep);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES,cli.getNif()+"\nDebe pagar: "+rep.getPrecio()));
    }
}