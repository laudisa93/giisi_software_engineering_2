package modelo;

import controlador.ClienteController;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.persistencia.ClienteDAO;
import modelo.persistencia.JDBC.ClienteDAOJDBC;

public class ClienteModelImpl implements ClienteModel {

    ClienteController controller;

    @Override
    public ClienteController getController() {
        return this.controller;
    }

    @Override
    public void setController(ClienteController controller) {
        this.controller = controller;
    }

    @Override
    public void nuevoCliente(Cliente cliente) {
        ClienteDAO dao = obtenerImplementacionClienteDAO();
        dao.create(cliente);
        this.controller.fireDataModelChanged();
    }

    @Override
    public Cliente obtenerCliente(String nombre) {
        ClienteDAO dao = obtenerImplementacionClienteDAO();
        return dao.read(nombre);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        ClienteDAO dao = obtenerImplementacionClienteDAO();
        dao.delete(cliente);
        this.controller.fireDataModelChanged();
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        ClienteDAO dao = obtenerImplementacionClienteDAO();
        dao.update(cliente);
        this.controller.fireDataModelChanged();
    }

    @Override
    public List obtenerClientes() {
        ClienteDAO dao = obtenerImplementacionClienteDAO();
        return dao.list();
    }

    private ClienteDAO obtenerImplementacionClienteDAO() {
        ClienteDAO dao = new ClienteDAOJDBC();
        return dao;
    }
}
