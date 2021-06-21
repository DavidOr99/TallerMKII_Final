/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name="pedidos") 
public class Pedidos implements Serializable{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idPedido;
    
    @Column(name = "contenido") 
    private String contenido;
    
    @JoinColumn(name = "idProveedor") 
    @ManyToOne
    private Proveedores proveedor;
    
    @Column(name = "fechaPedido") 
    private String fechaPedido;
       
    @Column(name = "observaciones") 
    private String observaciones;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getObservacion() {
        return observaciones;
    }

    public void setObservacion(String observacion) {
        this.observaciones = observacion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idPedido;
        hash = 67 * hash + Objects.hashCode(this.contenido);
        hash = 67 * hash + Objects.hashCode(this.proveedor);
        hash = 67 * hash + Objects.hashCode(this.fechaPedido);
        hash = 67 * hash + Objects.hashCode(this.observaciones);
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
        final Pedidos other = (Pedidos) obj;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        if (!Objects.equals(this.fechaPedido, other.fechaPedido)) {
            return false;
        }
        if (!Objects.equals(this.observaciones, other.observaciones)) {
            return false;
        }
        return Objects.equals(this.proveedor, other.proveedor);
    }

    @Override
    public String toString() {
        return "Pedidos{" + "idPedido=" + idPedido + ", contenido=" + contenido + ", proveedor=" + proveedor + ", fechaPedido=" + fechaPedido + ", observaciones=" + observaciones + '}';
    }
    
}