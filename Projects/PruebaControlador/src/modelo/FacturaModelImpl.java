package modelo;

import controlador.FacturaController;
import java.util.List;
import modelo.entidades.Factura;
import modelo.persistencia.FacturaDAO;
import modelo.persistencia.JDBC.FacturaDAOJDBC;

public class FacturaModelImpl implements FacturaModel {

    FacturaController controller;

    @Override
    public FacturaController getController() {
        return this.controller;
    }

    @Override
    public void setController(FacturaController controller) {
        this.controller = controller;
    }

    @Override
    public void nuevaFactura(Factura factura) {
        FacturaDAO dao = obtenerImplementacionFacturaDAO();
        dao.create(factura);
        this.controller.fireDataModelChanged();
    }

    @Override
    public Factura obtenerFactura(String id) {
        FacturaDAO dao = obtenerImplementacionFacturaDAO();
        return dao.read(id);
    }

    @Override
    public void eliminarFactura(Factura factura) {
        FacturaDAO dao = obtenerImplementacionFacturaDAO();
        dao.delete(factura);
        this.controller.fireDataModelChanged();
    }

    @Override
    public void actualizarFactura(Factura factura) {
        FacturaDAO dao = obtenerImplementacionFacturaDAO();
        dao.update(factura);
        this.controller.fireDataModelChanged();
    }

    @Override
    public List obtenerFacturas() {
        FacturaDAO dao = obtenerImplementacionFacturaDAO();
        return dao.list();
    }

    @Override
    public List listarPorClientes(String dni) {
        FacturaDAO dao = obtenerImplementacionFacturaDAO();
        return dao.listByCliente(dni);
    }

    private FacturaDAO obtenerImplementacionFacturaDAO() {
        return new FacturaDAOJDBC();
    }
}
