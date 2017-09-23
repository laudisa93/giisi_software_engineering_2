/*
 * JPanelContacto.java
 *
 * Created on 27 de octubre de 2008, 14:25
 */
package vista.circuito;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import modelo.entidades.Circuito;
import modelo.entidades.Piloto;


/**
 *
 * @author  Norberto Díaz-Díaz
 */
public class CircuitoViewImplInternal extends javax.swing.JPanel {

    private CircuitoViewImpl view;

    /** Creates new form JPanelContacto */
    public CircuitoViewImplInternal(CircuitoViewImpl view) {
        this.view=view;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldUbicacion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jComboPrimero = new javax.swing.JComboBox();
        jComboSegundo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboTercero = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setText("Nombre");

        jLabel3.setText("Primero");

        jLabel4.setText("Ubicacion");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Circuito");

        jButtonAdd.setText("Añadir");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Actualizar");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonRemove.setText("Borrar");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jComboPrimero.setModel(((vista.circuito.CircuitoViewImpl)view).getComboModelPiloto1());

        jComboSegundo.setModel(((vista.circuito.CircuitoViewImpl)view).getComboModelPiloto2());

        jLabel5.setText("Segundo");

        jComboTercero.setModel(((vista.circuito.CircuitoViewImpl)view).getComboModelPiloto3());

        jLabel6.setText("Tercero");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(37, 37, 37)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(jLabel6)
                                .add(33, 33, 33)
                                .add(jComboTercero, 0, 154, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel2)
                                    .add(jLabel4))
                                .add(28, 28, 28)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jTextFieldUbicacion)
                                    .add(jTextFieldNombre, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                .add(0, 0, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel5)
                                    .add(jLabel3))
                                .add(26, 26, 26)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jComboSegundo, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jComboPrimero, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .add(35, 35, 35)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jButtonAdd, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .add(jButtonRemove, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jButtonUpdate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                    .add(jLabel1))
                .addContainerGap(23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1)
                        .add(23, 23, 23)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(jTextFieldNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel4)
                            .add(jTextFieldUbicacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(30, 30, 30)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel3)
                            .add(jComboPrimero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(jComboSegundo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(60, 60, 60)
                        .add(jButtonAdd)
                        .add(27, 27, 27)
                        .add(jButtonUpdate)
                        .add(31, 31, 31)
                        .add(jButtonRemove)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 8, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(jComboTercero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
// TODO add your handling code here:
    try {
        view.fireNuevaFacturaGesture(this.jTextFieldNombre.getText(), this.jTextFieldUbicacion.getText(), (Piloto)this.jComboPrimero.getSelectedItem(), (Piloto)this.jComboSegundo.getSelectedItem(),(Piloto)this.jComboTercero.getSelectedItem());
    } catch (RuntimeException e) {
        javax.swing.JOptionPane.showMessageDialog(new JInternalFrame(), e, "Warning", JOptionPane.WARNING_MESSAGE);
    }


}//GEN-LAST:event_jButtonAddActionPerformed

private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
// TODO add your handling code here:
    try {
        view.fireActualizaFacturaGesture(this.jTextFieldNombre.getText(), this.jTextFieldUbicacion.getText(), (Piloto)this.jComboPrimero.getSelectedItem(), (Piloto)this.jComboSegundo.getSelectedItem(),(Piloto)this.jComboTercero.getSelectedItem());
    } catch (RuntimeException e) {
        javax.swing.JOptionPane.showMessageDialog(new JInternalFrame(), e, "Warning", JOptionPane.WARNING_MESSAGE);
    }


}//GEN-LAST:event_jButtonUpdateActionPerformed

private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
// TODO add your handling code here:
    try {
        view.fireBorraFacturaGesture(this.jTextFieldNombre.getText());
    } catch (RuntimeException e) {
        javax.swing.JOptionPane.showMessageDialog(new JInternalFrame(), e, "Warning", JOptionPane.WARNING_MESSAGE);
    }

}//GEN-LAST:event_jButtonRemoveActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox jComboPrimero;
    private javax.swing.JComboBox jComboSegundo;
    private javax.swing.JComboBox jComboTercero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldUbicacion;
    // End of variables declaration//GEN-END:variables

    public void setCircuito(Circuito circuito) {
        this.jTextFieldNombre.setText(circuito.getNombre());
        this.jTextFieldUbicacion.setText(circuito.getUbicacion());
        this.jComboPrimero.getModel().setSelectedItem(circuito.getPrimero());
        this.jComboSegundo.getModel().setSelectedItem(circuito.getSegundo());
        this.jComboTercero.getModel().setSelectedItem(circuito.getTercero());
        //this.jComboTercero.setSelectedItem(circuito.getTercero());
    }
}
