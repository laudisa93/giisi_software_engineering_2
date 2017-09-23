/*
 * JPanelContacto.java
 *
 * Created on 27 de octubre de 2008, 14:25
 */
package vista.factura;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import modelo.entidades.Cliente;
import modelo.entidades.Factura;

/**
 *
 * @author  Norberto Díaz-Díaz
 */
public class FacturaViewImplInternal extends javax.swing.JPanel {

    private FacturaViewImpl view;

    /** Creates new form JPanelContacto */
    public FacturaViewImplInternal(FacturaViewImpl view) {
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
        jTextFieldIdentificador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldImporte = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jComboCliente = new javax.swing.JComboBox();

        jLabel2.setText("Identificador:");

        jLabel3.setText("Cliente:");

        jLabel4.setText("Importe:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Factura");

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

        jComboCliente.setModel(((FacturaViewImpl)view).getComboModel());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(37, 37, 37)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jLabel3)
                            .add(jLabel4))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jTextFieldIdentificador, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .add(jTextFieldImporte, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .add(jComboCliente, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(35, 35, 35)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jButtonAdd, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .add(jButtonRemove, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jButtonUpdate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(23, 23, 23)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jTextFieldIdentificador, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButtonAdd))
                .add(17, 17, 17)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jButtonUpdate)
                    .add(jComboCliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(17, 17, 17)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jTextFieldImporte, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButtonRemove))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
// TODO add your handling code here:
    try {
        view.fireNuevaFacturaGesture(this.jTextFieldIdentificador.getText(), (Cliente)this.jComboCliente.getSelectedItem(), this.jTextFieldImporte.getText());
    } catch (RuntimeException e) {
        javax.swing.JOptionPane.showMessageDialog(new JInternalFrame(), e, "Warning", JOptionPane.WARNING_MESSAGE);
    }


}//GEN-LAST:event_jButtonAddActionPerformed

private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
// TODO add your handling code here:
    try {
        view.fireActualizaFacturaGesture(this.jTextFieldIdentificador.getText(), (Cliente)this.jComboCliente.getSelectedItem(), this.jTextFieldImporte.getText());
    } catch (RuntimeException e) {
        javax.swing.JOptionPane.showMessageDialog(new JInternalFrame(), e, "Warning", JOptionPane.WARNING_MESSAGE);
    }


}//GEN-LAST:event_jButtonUpdateActionPerformed

private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
// TODO add your handling code here:
    try {
        view.fireBorraFacturaGesture(this.jTextFieldIdentificador.getText());
    } catch (RuntimeException e) {
        javax.swing.JOptionPane.showMessageDialog(new JInternalFrame(), e, "Warning", JOptionPane.WARNING_MESSAGE);
    }

}//GEN-LAST:event_jButtonRemoveActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox jComboCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldIdentificador;
    private javax.swing.JTextField jTextFieldImporte;
    // End of variables declaration//GEN-END:variables

    public void setFactura(Factura factura) {
        this.jTextFieldIdentificador.setText(factura.getIdentificador());
        this.jComboCliente.setSelectedItem(factura.getCliente());
        this.jTextFieldImporte.setText(factura.getImporte().toString());
    }
}