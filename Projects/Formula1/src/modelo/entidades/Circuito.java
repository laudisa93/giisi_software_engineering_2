/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

/**
 *
 * @author Norberto Diaz-Diaz
 */
public interface Circuito extends Entidad{

    String getNombre();

    Piloto getPrimero();

    Piloto getSegundo();

    Piloto getTercero();

    String getUbicacion();

    void setNombre(String nombre);

    void setPrimero(Piloto primero);

    void setSegundo(Piloto segundo);

    void setTercero(Piloto tercero);

    void setUbicacion(String ubicacion);
    
}
