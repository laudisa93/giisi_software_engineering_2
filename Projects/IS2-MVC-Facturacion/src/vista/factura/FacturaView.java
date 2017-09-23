/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.factura;

import controlador.FacturaController;
import modelo.FacturaModel;


/**
 *
 * @author Norberto Díaz-Díaz
 */
public interface FacturaView {
    FacturaModel getModel();
    void setModel(FacturaModel fm);
    
    FacturaController getController();
    void setController(FacturaController fc);
    
    void dataModelChanged();
    void display();
}
