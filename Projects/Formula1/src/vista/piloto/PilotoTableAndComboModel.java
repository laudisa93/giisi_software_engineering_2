/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.piloto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.entidades.Piloto;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class PilotoTableAndComboModel implements TableModel, ComboBoxModel {


    private List<Piloto> pilotos = new ArrayList<Piloto>();
    private List<TableModelListener> tableListeners = new ArrayList<TableModelListener>();
    private List<ListDataListener> dataListeners = new ArrayList<ListDataListener>();

    private static List<PilotoTableAndComboModel> submodelos=new ArrayList<PilotoTableAndComboModel>();


    private PilotoTableAndComboModel(){}

    public static PilotoTableAndComboModel create(){
        //if(model==null)
            PilotoTableAndComboModel model=new PilotoTableAndComboModel();
            submodelos.add(model);
        return model;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }
    
    public void setPilotos(List<Piloto> pilotos) {
        for(PilotoTableAndComboModel submodelo:submodelos)
            submodelo.setPilotosAux(pilotos);
    }

    private void setPilotosAux(List<Piloto> pilotos) {
        this.pilotos = pilotos;
        fireContentsChanged();
    }

    protected void fireContentsChanged() {
        fireContentsChangedTableModel();
        fireContentsChangedListData();
    }
    //--------------- MÉTODOS PROPIOS DE TableModel -------------------------

    public Piloto getRow(int indexRow) {
        return pilotos.get(indexRow);
    }

    public int getRowCount() {
        return pilotos.size();
    }

    public int getColumnCount() {
        return 2; //ya que tendremos tres valores a mostrar por contacto
    }

    public String getColumnName(int columnIndex) {
        String name = null;
        switch (columnIndex) {
            case 0:
                name = "DNI";
                break;
            case 1:
                name = "Nombre";
                break;
        }
        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class; //Todos los valores de contacto son un String
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //No permito editar celdas
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Piloto piloto = pilotos.get(rowIndex);
        String value = null;
        switch (columnIndex) {
            case 0:
                value = piloto.getDNI();
                break;
            case 1:
                value = piloto.getNombre();
                break;
        }
        return value;

    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addTableModelListener(TableModelListener l) {
        tableListeners.add(l);
    }

    public void removeTableModelListener(TableModelListener l) {
        tableListeners.remove(l);
    }

    protected void fireContentsChangedTableModel() {
        //TableModelEvent event = new TableModelEvent(this,0,getRowCount());
        TableModelEvent event = new TableModelEvent(this, 0, this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        for (TableModelListener listener : tableListeners) {
            listener.tableChanged(event);
        }
    }
    //--------------- MÉTODOS PROPIOS DE ComboBoxModel -------------------------
    private Piloto clienteSelected = null;

    public void setSelectedItem(Object anItem) {
        if (anItem != null) {
            clienteSelected = (Piloto) anItem;
            fireContentsChangedListData();
        }
    }

    public Object getSelectedItem() {
        return clienteSelected;
    }

    public int getSize() {
        return pilotos.size();
    }

    public Object getElementAt(int index) {
        return pilotos.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        dataListeners.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        dataListeners.remove(l);
    }

    protected void fireContentsChangedListData() {
        ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, pilotos.size());
        for (ListDataListener l : dataListeners) {
            l.contentsChanged(e);
        }
    }
}
