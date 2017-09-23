/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.cliente;

import controlador.ClienteController;
import modelo.ClienteModel;


/**
 *
 * @author Norberto Díaz-Díaz
 */
public interface ClienteView {
    ClienteModel getModel();
    void setModel(ClienteModel cm);
    
    ClienteController getController();
    void setController(ClienteController cc);
    
    void dataModelChanged();
    void display();
}
