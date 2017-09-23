/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.CircuitoController;
import java.util.List;
import modelo.entidades.Circuito;
import modelo.entidades.Piloto;

/**
 *
 * @author Norberto Diaz-Diaz
 */
public interface CircuitoModel extends Model<CircuitoController, Circuito, String> {
    /**
     * Lista aquellos circuitos en los que el piloto ha puntuado.
     */
    List<Circuito> listarPorPuntuados(Piloto piloto);
    
}
