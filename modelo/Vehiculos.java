/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author DAVID
 */
@Entity 
@Table(name="vehiculos") 
public class Vehiculos implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idVehiculos;
    
    @Column(name = "numBastidor") 
    private String numBastidor;
    
    @Column(name = "matricula") 
    private String matricula;
    
    @Column(name = "marca") 
    private String marca;
    
    @Column(name = "modelo") 
    private String modelo;
    
    @Column(name = "anioModelo") 
    private String anioModelo;
    
    @Column(name = "fechaMatriculacion") 
    private String fechaMatriculacion;
    
    @Column(name = "kmRecorridos") 
    private String kmRecorridos;
    
    @Column(name = "fechaUltimoMantenimiento") 
    private String fechaUltimoMantenimiento;
    
    @Column(name = "piezasEspeciales") 
    private int piezasEspeciales;
    
    @Column(name = "observaciones") 
    private String observaciones;
    
    @JoinColumn(name = "idCliente") 
    @ManyToOne
    private Cliente cliente;

    public int getIdVehiculos() {
        return idVehiculos;
    }

    public void setIdVehiculos(int idVehiculos) {
        this.idVehiculos = idVehiculos;
    }

    public String getNumBastidor() {
        return numBastidor;
    }

    public void setNumBastidor(String numBastidor) {
        this.numBastidor = numBastidor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnioModelo() {
        return anioModelo;
    }

    public void setAnioModelo(String anioModelo) {
        this.anioModelo = anioModelo;
    }

    public String getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(String fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String getKmRecorridos() {
        return kmRecorridos;
    }

    public void setKmRecorridos(String kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public String getFechaUltimoMantenimiento() {
        return fechaUltimoMantenimiento;
    }

    public void setFechaUltimoMantenimiento(String fechaUltimoMantenimiento) {
        this.fechaUltimoMantenimiento = fechaUltimoMantenimiento;
    }

    public int getPiezasEspeciales() {
        return piezasEspeciales;
    }

    public void setPiezasEspeciales(int piezasEspeciales) {
        this.piezasEspeciales = piezasEspeciales;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idVehiculos;
        hash = 47 * hash + Objects.hashCode(this.numBastidor);
        hash = 47 * hash + Objects.hashCode(this.matricula);
        hash = 47 * hash + Objects.hashCode(this.marca);
        hash = 47 * hash + Objects.hashCode(this.modelo);
        hash = 47 * hash + Objects.hashCode(this.anioModelo);
        hash = 47 * hash + Objects.hashCode(this.fechaMatriculacion);
        hash = 47 * hash + Objects.hashCode(this.kmRecorridos);
        hash = 47 * hash + Objects.hashCode(this.fechaUltimoMantenimiento);
        hash = 47 * hash + this.piezasEspeciales;
        hash = 47 * hash + Objects.hashCode(this.observaciones);
        hash = 47 * hash + Objects.hashCode(this.cliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculos other = (Vehiculos) obj;
        if (this.idVehiculos != other.idVehiculos) {
            return false;
        }
        if (this.piezasEspeciales != other.piezasEspeciales) {
            return false;
        }
        if (!Objects.equals(this.numBastidor, other.numBastidor)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.anioModelo, other.anioModelo)) {
            return false;
        }
        if (!Objects.equals(this.fechaMatriculacion, other.fechaMatriculacion)) {
            return false;
        }
        if (!Objects.equals(this.kmRecorridos, other.kmRecorridos)) {
            return false;
        }
        if (!Objects.equals(this.fechaUltimoMantenimiento, other.fechaUltimoMantenimiento)) {
            return false;
        }
        if (!Objects.equals(this.observaciones, other.observaciones)) {
            return false;
        }
        return Objects.equals(this.cliente, other.cliente);
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "idVehiculos=" + idVehiculos + ", numBastidor=" + numBastidor + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", anioModelo=" + anioModelo + ", fechaMatriculacion=" + fechaMatriculacion + ", kmRecorridos=" + kmRecorridos + ", fechaUltimoMantenimiento=" + fechaUltimoMantenimiento + ", piezasEspeciales=" + piezasEspeciales + ", observaciones=" + observaciones + ", cliente=" + cliente + '}';
    }
    
}
