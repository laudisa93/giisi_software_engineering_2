
package modelo.persistencia;

import java.util.List;
import modelo.entidades.Factura;

public interface FacturaDAO {
    Factura read(String pk);
    void create(Factura factura);
    void update(Factura factura);
    void delete(Factura factura);
    List <Factura> list();
    List<Factura> listByCliente(String dni);    
}
