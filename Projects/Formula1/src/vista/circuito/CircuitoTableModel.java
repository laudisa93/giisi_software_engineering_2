/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.circuito;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.entidades.Circuito;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class CircuitoTableModel implements TableModel{

    private List<Circuito> circuitos = new ArrayList<Circuito>();
    private List<TableModelListener> tableListeners = new ArrayList<TableModelListener>();

    public List<Circuito> getCircuitos() {
        return circuitos;
    }

    public void setCircuitos(List<Circuito> circuitos) {
        this.circuitos = circuitos;
        fireContentsChanged();
    }

    protected void fireContentsChanged() {
        fireContentsChangedTableModel();
    }
    //--------------- MÉTODOS PROPIOS DE TableModel -------------------------

    public Circuito getRow(int indexRow) {
        return circuitos.get(indexRow);
    }

    public int getRowCount() {
        return circuitos.size();
    }

    public int getColumnCount() {
        return 5;
    }

    public String getColumnName(int columnIndex) {
        String name = null;
        switch (columnIndex) {
            case 0:
                name = "Nombre";
                break;
            case 1:
                name = "Ubicacion";
                break;
            case 2:
                name = "Primero";
                break;
            case 3:
                name = "Segundo";
                break;
            case 4:
                name = "Tercero";
                break;
        }
        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //No permito editar celdas
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Circuito circuito = circuitos.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = circuito.getNombre();
                break;
            case 1:
                value = circuito.getUbicacion();
                break;
            case 2:
                value = circuito.getPrimero().getDNI();
                break;
            case 3:
                value = circuito.getSegundo().getDNI();
                break;
            case 4:
                value = circuito.getTercero().getDNI();
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
        
        TableModelEvent event = new TableModelEvent(this, 0, this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        for (TableModelListener listener : tableListeners) {
            listener.tableChanged(event);
        }
    }
    
}
