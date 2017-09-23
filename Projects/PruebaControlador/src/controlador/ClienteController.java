
package controlador;

import java.util.List;
import modelo.ClienteModel;
import vista.cliente.ClienteView;



public interface ClienteController {
    void setup(ClienteModel model, List <ClienteView> views );
    void start();
    
    ClienteModel getModel();
    void setModel(ClienteModel model);
    
    void addView(ClienteView view);
    void removeView(ClienteView view);

    void nuevoClienteGesture(String dni, String nombre, String direccion);
    void eliminarClienteGesture(String dni);
    void actualizaClienteGesture(String dni, String nombre, String direccion);
    
    //Olvidado
    void fireDataModelChanged();
}
