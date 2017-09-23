package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.FacturaModel;
import modelo.entidades.Cliente;
import modelo.entidades.Factura;
import modelo.entidades.FacturaImpl;
import vista.factura.FacturaView;

public class FacturaControllerImpl implements FacturaController {

    private FacturaModel model;
    private List<FacturaView> views;

    public FacturaControllerImpl() {
        this.views = new ArrayList<FacturaView>();
    }

    @Override
    public void setup(FacturaModel model, List<FacturaView> views) {
        this.model = model;
        model.setController(this);
        this.addViews(views);
    }

    private void addViews(List<FacturaView> views) {
        for (FacturaView v : views) {
            this.addView(v);
        }
    }

    @Override
    public void start() {
        for (FacturaView f : this.views) {
            f.display();
        }
    }

    @Override
    public void addView(FacturaView view) {
        view.setController(this);
        view.setModel(model);
        this.views.add(view);
    }

    @Override
    public void removeView(FacturaView view) {
        this.views.remove(view);
    }

    @Override
    public FacturaModel getModel() {
        return this.model;
    }

    @Override
    public void setModel(FacturaModel model) {
        this.model = model;
    }

    @Override
    public void nuevaFacturaGesture(String id, Cliente c, double importe) {
        Factura f = new FacturaImpl(id, c, importe);
        this.model.nuevaFactura(f);
    }

    @Override
    public void eliminarFacturaGesture(String id) {
        Factura f = new FacturaImpl(id);
        this.model.eliminarFactura(f);
    }

    @Override
    public void actualizaFacturaGesture(String id, Cliente c, double importe) {
        Factura f = new FacturaImpl(id, c, importe);
        this.model.actualizarFactura(f);
    }

    @Override
    public void fireDataModelChanged() {
        for(FacturaView fv: this.views){
            fv.display();
        }
    }
}
