/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ClienteController;
import modelo.ClienteModel;

/**
 *
 * @author rober
 */
public interface ClienteView {
    ClienteModel getModel();
    void setModel(ClienteModel cm);
    
    ClienteController getController();
    void setController(ClienteController cc);
    
    void dataModelChanged();
    void display();
}
