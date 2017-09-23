/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;

/**
 *
 * @author rober
 */
public interface Factura extends Serializable{
    
    String getIdentificador();
    Cliente getCliente();
    Double getImporte();
    
    void setIdentificador(String id);
    //void setCliente(Cliente cl);
    //void setImporte(Double im);
}
