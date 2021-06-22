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
@Table(name="usuarios") 
public class Usuarios implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int numUser;
    
    @Column(name = "usuario") 
    private String usuario;
    
    @Column(name = "contrasenia") 
    private String contrasenia;

    public int getNumUser() {
        return numUser;
    }

    public void setNumUser(int numUser) {
        this.numUser = numUser;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.numUser;
        hash = 17 * hash + Objects.hashCode(this.usuario);
        hash = 17 * hash + Objects.hashCode(this.contrasenia);
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
        final Usuarios other = (Usuarios) obj;
        if (this.numUser != other.numUser) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.contrasenia, other.contrasenia);
    }

    @Override
    public String toString() {
        return "Usuarios{" + "numUser=" + numUser + ", usuario=" + usuario + ", contrasenia=" + contrasenia + '}';
    }
}
