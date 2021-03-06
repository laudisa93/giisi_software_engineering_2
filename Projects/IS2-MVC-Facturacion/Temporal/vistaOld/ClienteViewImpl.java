/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ClienteController;
import modelo.entidades.Cliente;
import modelo.ClienteModel;

/**
 *
 * @author rober
 */
public class ClienteViewImpl extends javax.swing.JFrame implements ClienteView {
    //Atributos del MVC
    private ClienteModel model;
    
    private ClienteController controller;
    
    //Atributos propios de Swing
    private ClienteTableAndComboModel tableModel;
    private JPanelCliente panelCliente;
    
    /**
     * Creates new form ClienteViewImpl
     */
    public ClienteViewImpl() {
        tableModel = ClienteTableAndComboModel.create();
        initComponents();
        
        this.panelCliente = new JPanelCliente(this);
        this.jPanelDown.add(this.panelCliente);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDown = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelDown.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelDown.setMaximumSize(new java.awt.Dimension(4, 4));
        jPanelDown.setMinimumSize(new java.awt.Dimension(4, 4));
        jPanelDown.setPreferredSize(new java.awt.Dimension(4, 4));
        jPanelDown.setLayout(new javax.swing.BoxLayout(jPanelDown, javax.swing.BoxLayout.LINE_AXIS));

        jTableClientes.setModel(tableModel);
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
            .add(jPanelDown, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanelDown, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 280, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        ClienteTableAndComboModel ctm = (ClienteTableAndComboModel) this.jTableClientes.getModel();
        Cliente cliente = ctm.getRow(this.jTableClientes.getSelectedRow());
        panelCliente.setCliente(cliente);
    }//GEN-LAST:event_jTableClientesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteViewImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteViewImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteViewImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteViewImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ClienteViewImpl().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelDown;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    // End of variables declaration//GEN-END:variables

    @Override
    public ClienteModel getModel() {
        return this.model;
    }

    @Override
    public void setModel(ClienteModel cm) {
        this.model = cm;
    }

    @Override
    public ClienteController getController() {
        return this.controller;
    }

    @Override
    public void setController(ClienteController cc) {
        this.controller = cc;
    }

    @Override
    public void dataModelChanged() {
        refresh();
    }

    @Override
    public void display() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                setVisible(true);
                refresh();
            }
        });
    }
    
    protected void refresh() {
        tableModel.setClientes(getModel().obtenerClientes());//cambia el modelo de JTable(TableModel) por medio de una clase que hemos creado (ContactosTableModel)
    }

    protected void fireNuevoClienteGesture(String dni, String nombre, String direccion) {
        getController().nuevoClienteGesture(dni, nombre, direccion);
    }

    protected void fireActualizaClienteGesture(String dni, String nombre, String direccion) {
        getController().actualizaClienteGesture(dni, nombre, direccion);
    }

    protected void fireBorraClienteGesture(String dni) {
        getController().borraClienteGesture(dni);
    }
}
