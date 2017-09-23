
package modelo;

import controlador.ClienteController;
import java.util.List;
import modelo.entidades.Cliente;

public interface ClienteModel {
    ClienteController getController();
    void setController (ClienteController controller);
    
    void nuevoCliente(Cliente cliente);
    Cliente obtenerCliente(String nombre);
    void eliminarCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    
    List obtenerClientes();            
}
