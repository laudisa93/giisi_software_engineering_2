/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.PilotoModel;
import modelo.entidades.Entidad;
import modelo.entidades.PilotoImpl;
import vista.piloto.PilotoView;

/**
 *
 * @author Norberto Diaz-Diaz
 */
public class PilotoControllerImpl extends AbstractControllerImpl<PilotoModel, PilotoView, String> implements PilotoController{

    @Override
    Entidad generaEntidad(List<String> datos) {
        String dni=datos.get(0);
        String nombre=datos.get(1);
        return new PilotoImpl(dni, nombre);
    }

    @Override
    Entidad generaEntidad(String pk) {
        return new PilotoImpl(pk);
    }
    
}
