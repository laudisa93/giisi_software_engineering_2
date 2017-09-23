
package modelo.persistencia;

import java.util.List;
import modelo.entidades.Cliente;

public interface ClienteDAO {
    Cliente read(String pk);
    void create(Cliente contacto);
    void update(Cliente contacto);
    void delete(Cliente contacto);
    List <Cliente> list();
}
