/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.util.List;
import modelo.entidades.Factura;

/**
 *
 * @author rober
 */
public interface FacturaDAO {
    Factura read(String pk);
    void create(Factura factura);
    void update(Factura factura);
    void delete(Factura factura);
    List <Factura> list();
    List<Factura> listByCliente(String dni);    
}
