
package modelo.entidades;

import java.io.Serializable;

public interface Cliente extends Serializable {
    
    String getDNI();
    String getNombre();
    String getDireccion();
    
    void setDNI(String dni);
    void setNombre(String nombre);
    void setDireccion(String direccion);
}
