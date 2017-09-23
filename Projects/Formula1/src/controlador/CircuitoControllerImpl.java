/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import modelo.CircuitoModel;
import modelo.entidades.CircuitoImpl;
import modelo.entidades.Entidad;
import modelo.entidades.Piloto;
import vista.circuito.CircuitoView;

/**
 *
 * @author Norberto Diaz-Diaz
 */
public class CircuitoControllerImpl extends AbstractControllerImpl<CircuitoModel, CircuitoView, Serializable> implements CircuitoController{

    @Override
    Entidad generaEntidad(List<Serializable> datos) {
        String nombre=(String)datos.get(0);
        String ubicacion=(String)datos.get(1);
        Piloto primero=(Piloto)datos.get(2), segundo=(Piloto)datos.get(3), tercero=(Piloto)datos.get(4);
        return new CircuitoImpl(nombre, ubicacion, primero, segundo, tercero);
    }

    @Override
    Entidad generaEntidad(Serializable pk) {
        return new CircuitoImpl((String)pk);
    }
    
}
