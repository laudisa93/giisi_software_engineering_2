
package modelo;

import controlador.FacturaController;
import java.util.List;
import modelo.entidades.Factura;

public interface FacturaModel {
   //Controlador
    FacturaController getController();
    void setController (FacturaController controller);
    
    //para dao
    void nuevaFactura(Factura factura);
    Factura obtenerFactura(String id);
    void eliminarFactura(Factura factura);
    void actualizarFactura(Factura factura);
    
    List obtenerFacturas();
    List listarPorClientes(String dni);
            
}
