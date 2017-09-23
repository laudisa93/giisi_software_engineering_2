package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.ClienteModel;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import vista.cliente.ClienteView;

public class ClienteControllerImpl implements ClienteController {

    ClienteModel model;
    List<ClienteView> views;

    public ClienteControllerImpl() {
        this.views = new ArrayList<ClienteView>();
    }

    @Override
    public void setup(ClienteModel model, List<ClienteView> views) {
        this.model = model;
        model.setController(this);
        this.addViews(views);
    }

    @Override
    public void start() {
        for (ClienteView v : this.views) {
            v.display();
        }
    }

    private void addViews(List<ClienteView> views) {
        for (ClienteView c : views) {
            views.add(c);
        }
    }

    @Override
    public ClienteModel getModel() {
        return this.model;
    }

    @Override
    public void setModel(ClienteModel model) {
        this.model = model;
    }

    @Override
    public void addView(ClienteView view) {
        view.setController(this);
        view.setModel(this.model);
        this.views.add(view);

    }

    @Override
    public void removeView(ClienteView view) {
        this.views.remove(view);
    }

    @Override
    public void nuevoClienteGesture(String dni, String nombre, String direccion) {
        Cliente c = new ClienteImpl(dni, nombre, direccion);
        this.model.nuevoCliente(c);
    }

    @Override
    public void eliminarClienteGesture(String dni) {
        Cliente c = new ClienteImpl(dni);
        this.model.eliminarCliente(c);
    }

    @Override
    public void actualizaClienteGesture(String dni, String nombre, String direccion) {
        Cliente c = new ClienteImpl(dni, nombre, direccion);
        this.model.actualizarCliente(c);
    }

    @Override
    public void fireDataModelChanged() {
        for(ClienteView v: views){
            v.display();
        }
    }
}
