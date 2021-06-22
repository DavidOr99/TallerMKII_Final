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
@Table(name="almacen") 
public class Almacen implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idAlmacen;
    
    @Column(name = "nombre") 
    private String nombre;
    
    @Column(name = "estado") 
    private String estado;
    
    @JoinColumn(name = "proveedor") 
    @ManyToOne
    private Proveedores proveedor;
    
    @Column(name = "cantidad") 
    private int cantidad;
    
    @JoinColumn(name = "pedido") 
    @ManyToOne
    private Pedidos pedido;
    
    @Column(name = "observacion") 
    private String observacion;

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idAlmacen;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.estado);
        hash = 97 * hash + Objects.hashCode(this.proveedor);
        hash = 97 * hash + this.cantidad;
        hash = 97 * hash + Objects.hashCode(this.pedido);
        hash = 97 * hash + Objects.hashCode(this.observacion);
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
        final Almacen other = (Almacen) obj;
        if (this.idAlmacen != other.idAlmacen) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.observacion, other.observacion)) {
            return false;
        }
        if (!Objects.equals(this.proveedor, other.proveedor)) {
            return false;
        }
        return Objects.equals(this.pedido, other.pedido);
    }

    @Override
    public String toString() {
        return "Almacen{" + "idAlmacen=" + idAlmacen + ", nombre=" + nombre + ", estado=" + estado + ", proveedor=" + proveedor + ", cantidad=" + cantidad + ", pedido=" + pedido + ", observacion=" + observacion + '}';
    }

}