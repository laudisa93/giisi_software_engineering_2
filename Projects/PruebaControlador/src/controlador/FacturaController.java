
package controlador;

import java.util.List;
import modelo.FacturaModel;
import modelo.entidades.Cliente;
import vista.factura.FacturaView;

public interface FacturaController {
  //conecta MVC 
   void setup(FacturaModel model, List <FacturaView> views);
   void start();
   
   //para la vista:
   void addView(FacturaView view);
   void removeView(FacturaView view);
   
   //para el modelo
   FacturaModel getModel();
   void setModel(FacturaModel model);
   
   //vista-modelo
   
   void nuevaFacturaGesture(String id, Cliente c, double importe);
   void eliminarFacturaGesture(String id);
   void actualizaFacturaGesture(String id, Cliente c, double importe);
   
   //actualizar
   void fireDataModelChanged();
}
