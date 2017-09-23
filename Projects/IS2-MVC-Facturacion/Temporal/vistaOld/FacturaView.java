/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.FacturaController;
import modelo.FacturaModel;

/**
 *
 * @author rober
 */
public interface FacturaView {
    FacturaModel getModel();
    void setModel(FacturaModel fm);
    
    FacturaController getController();
    void setController(FacturaController fc);
    
    void dataModelChanged();
    void display();
}
