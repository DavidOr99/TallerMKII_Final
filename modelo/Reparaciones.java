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
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 *
 * @author DAVID
 */
@Entity 
@Table(name="reparaciones") 
public class Reparaciones implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idReparaciones;
    
    @JoinColumn(name = "categoria") 
    @OneToOne(cascade=CascadeType.PERSIST)
    private Categoria_Reparacion categoria;
    
    @Column(name = "fecha") 
    private String fecha;
    
    @Column(name = "precio") 
    private String precio;
    
    @JoinColumn(name = "mecanico") 
    @ManyToOne
    private Mecanicos mecanico;
    
    @JoinColumn(name = "coche") 
    @ManyToOne
    private Vehiculos coche;
    
    @JoinColumn(name = "cliente") 
    @ManyToOne
    private Cliente cliente;
    
    @Column(name = "descripcion") 
    private String descripcion;

    public int getIdReparaciones() {
        return idReparaciones;
    }

    public void setIdReparaciones(int idReparaciones) {
        this.idReparaciones = idReparaciones;
    }

    public Categoria_Reparacion getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria_Reparacion categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Mecanicos getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanicos mecanico) {
        this.mecanico = mecanico;
    }

    public Vehiculos getCoche() {
        return coche;
    }

    public void setCoche(Vehiculos coche) {
        this.coche = coche;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idReparaciones;
        hash = 83 * hash + Objects.hashCode(this.categoria);
        hash = 83 * hash + Objects.hashCode(this.fecha);
        hash = 83 * hash + Objects.hashCode(this.precio);
        hash = 83 * hash + Objects.hashCode(this.mecanico);
        hash = 83 * hash + Objects.hashCode(this.coche);
        hash = 83 * hash + Objects.hashCode(this.cliente);
        hash = 83 * hash + Objects.hashCode(this.descripcion);
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
        final Reparaciones other = (Reparaciones) obj;
        if (this.idReparaciones != other.idReparaciones) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.mecanico, other.mecanico)) {
            return false;
        }
        if (!Objects.equals(this.coche, other.coche)) {
            return false;
        }
        return Objects.equals(this.cliente, other.cliente);
    }

    @Override
    public String toString() {
        return "Reparaciones{" + "idReparaciones=" + idReparaciones + ", categoria=" + categoria + ", fecha=" + fecha + ", precio=" + precio + ", mecanico=" + mecanico + ", coche=" + coche + ", cliente=" + cliente + ", descripcion=" + descripcion + '}';
    }
    
}