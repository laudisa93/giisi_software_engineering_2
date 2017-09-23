/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

/**
 *
 * @author Norberto Diaz-Diaz
 */
public interface Piloto extends Entidad{

    String getDNI();

    String getNombre();

    void setDNI(String DNI);

    void setNombre(String nombre);

    String toString();
    
}
