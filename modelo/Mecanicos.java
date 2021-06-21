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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author DAVID
 */
@Entity 
@Table(name="mecanicos") 
public class Mecanicos implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idMecanicos;
    
    @Column(name = "nif") 
    private String nif;
    
    @Column(name = "nombre") 
    private String nombre;
    
    @Column(name = "apellidos") 
    private String apellidos;
    
    @Column(name = "telefono") 
    private String telefono;
    
    @JoinColumn(name = "numUser") 
    @OneToOne
    private Usuarios usuario;

    public int getIdMecanicos() {
        return idMecanicos;
    }

    public void setIdMecanicos(int idMecanicos) {
        this.idMecanicos = idMecanicos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idMecanicos;
        hash = 47 * hash + Objects.hashCode(this.nif);
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.apellidos);
        hash = 47 * hash + Objects.hashCode(this.telefono);
        hash = 47 * hash + Objects.hashCode(this.usuario);
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
        final Mecanicos other = (Mecanicos) obj;
        if (this.idMecanicos != other.idMecanicos) {
            return false;
        }
        if (!Objects.equals(this.nif, other.nif)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }

    @Override
    public String toString() {
        return "Mecanicos{" + "idMecanicos=" + idMecanicos + ", nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", usuario=" + usuario + '}';
    }

    
    
}
