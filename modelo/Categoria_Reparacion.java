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
import javax.persistence.Table;

/**
 *
 * @author DAVID
 */

@Entity 
@Table(name="categoria_reparacion") 
public class Categoria_Reparacion implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idCategoria_Reparacion;
    
    @Column(name = "nombre") 
    private String nombre;

    public int getIdCategoria_Reparacion() {
        return idCategoria_Reparacion;
    }

    public void setIdCategoria_Reparacion(int idCategoria_Reparacion) {
        this.idCategoria_Reparacion = idCategoria_Reparacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idCategoria_Reparacion;
        hash = 67 * hash + Objects.hashCode(this.nombre);
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
        final Categoria_Reparacion other = (Categoria_Reparacion) obj;
        if (this.idCategoria_Reparacion != other.idCategoria_Reparacion) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Categoria_Reparacion{" + "idCategoria_Reparacion=" + idCategoria_Reparacion + ", nombre=" + nombre + '}';
    }   
}