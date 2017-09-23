
package modelo.entidades;

import java.io.Serializable;

public interface Factura extends Serializable{
    
    String getIdentificador();
    Cliente getCliente();
    Double getImporte();
    
    void setIdentificador(String id);
    //void setCliente(Cliente cl);
    //void setImporte(Double im);
}
