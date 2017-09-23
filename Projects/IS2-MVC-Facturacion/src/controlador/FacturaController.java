/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.FacturaModel;
import modelo.entidades.Cliente;
import vista.factura.FacturaView;

/**
 *
 * @author rober
 */
public interface FacturaController {
    //Metodo para enlazar la vista y el modelo
    void setup(FacturaModel model, List<FacturaView> view);
    //Metodo para lanzar la aplicación MVC
    void start();

    void addView(FacturaView view);
    void removeView(FacturaView view);

    FacturaModel getModel();
    void setModel(FacturaModel model);

    //Métodos a los que la vista llamará. Por ahora permitimos crear nuevos contactos
    void nuevaFacturaGesture(String id, Cliente cliente, String importe);
    void borraFacturaGesture(String id);
    void actualizaFacturaGesture(String id, Cliente cliente, String importe);

    //Métodos que el modelo puede llamar
    void fireDataModelChanged();

    
}
