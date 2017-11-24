/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.Facturacion;
import Datos.Usuario;
import Logica.OperacionesTransacciones;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class VentanaConfirmacion extends javax.swing.JFrame {

    /**
     * Creates new form VentanaConfirmacion
     */
    public VentanaConfirmacion() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private Facturacion factura;
    private Usuario datosUsuario;

    public Usuario getDatosUsuario() {
        return datosUsuario;
    }

    public void setDatosUsuario(Usuario datosUsuario) {
        this.datosUsuario = datosUsuario;
    }

    public Facturacion getFactura() {
        return factura;
    }

    public void setFactura(Facturacion factura) {
        this.factura = factura;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNroFactura = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jPanelDatosCliente = new javax.swing.JPanel();
        jLabelNomApeClienteFactura = new javax.swing.JLabel();
        jLabelDomicilioFactura = new javax.swing.JLabel();
        jLabelTelefonoFactura = new javax.swing.JLabel();
        jLabelZonaFactura = new javax.swing.JLabel();
        jLabelNumCliente = new javax.swing.JLabel();
        jLabelNomCliente = new javax.swing.JLabel();
        jLabelPedido = new javax.swing.JLabel();
        jLabelImporte = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jButtonAnular = new javax.swing.JButton();
        jLabelFactura = new javax.swing.JLabel();
        jLabelFec = new javax.swing.JLabel();
        jLabelHor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FastFoodSystem - Confirmar Anulacion");
        setMaximumSize(new java.awt.Dimension(640, 270));
        setMinimumSize(new java.awt.Dimension(640, 270));
        setPreferredSize(new java.awt.Dimension(640, 270));

        jLabelNroFactura.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelNroFactura.setText("Nro de Factura:");

        jLabelFecha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelFecha.setText("Fecha:");

        jPanelDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14))); // NOI18N
        jPanelDatosCliente.setMaximumSize(new java.awt.Dimension(700, 80));
        jPanelDatosCliente.setMinimumSize(new java.awt.Dimension(700, 80));

        jLabelNomApeClienteFactura.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelNomApeClienteFactura.setText("Cliente Nro:");

        jLabelDomicilioFactura.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelDomicilioFactura.setText("Cliente:");

        jLabelTelefonoFactura.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelTelefonoFactura.setText("Pedido Nro:");

        jLabelZonaFactura.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelZonaFactura.setText("Importe:");

        jLabelNumCliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        jLabelNomCliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        jLabelPedido.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        jLabelImporte.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanelDatosClienteLayout = new javax.swing.GroupLayout(jPanelDatosCliente);
        jPanelDatosCliente.setLayout(jPanelDatosClienteLayout);
        jPanelDatosClienteLayout.setHorizontalGroup(
            jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(jLabelNomApeClienteFactura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNumCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(jLabelDomicilioFactura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelZonaFactura)
                    .addComponent(jLabelTelefonoFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jLabelImporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDatosClienteLayout.setVerticalGroup(
            jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                        .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNomApeClienteFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNumCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTelefonoFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanelDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelDomicilioFactura)
                                    .addComponent(jLabelNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                                .addComponent(jLabelZonaFactura)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanelDatosClienteLayout.createSequentialGroup()
                        .addComponent(jLabelPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabelHora.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelHora.setText("Hora:");

        jButtonAnular.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButtonAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/icono-eliminar-detalle-pedido.png"))); // NOI18N
        jButtonAnular.setText("Anular");
        jButtonAnular.setMaximumSize(new java.awt.Dimension(210, 57));
        jButtonAnular.setMinimumSize(new java.awt.Dimension(210, 57));
        jButtonAnular.setPreferredSize(new java.awt.Dimension(210, 57));
        jButtonAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabelNroFactura)
                        .addGap(16, 16, 16)
                        .addComponent(jLabelFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelFec, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFecha)
                    .addComponent(jLabelHora)
                    .addComponent(jLabelNroFactura)
                    .addComponent(jLabelFactura)
                    .addComponent(jLabelFec)
                    .addComponent(jLabelHor))
                .addGap(18, 18, 18)
                .addComponent(jPanelDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnularActionPerformed
        Facturacion f = new Facturacion();
        try {        
            f.anular(factura.getNumFactura());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentanaConfirmacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaConfirmacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        OperacionesTransacciones OP = new OperacionesTransacciones();
        int accion = 18;
        int entidad = 6;
        try {
            OP.registrarTransaccion(accion, entidad, factura.getNumFactura(), datosUsuario);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentanaConfirmacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "La Factura Se Anulo Correctamente", "FastFoodSystem", JOptionPane.OK_OPTION);
        this.dispose();
    }//GEN-LAST:event_jButtonAnularActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaConfirmacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaConfirmacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaConfirmacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaConfirmacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaConfirmacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnular;
    private javax.swing.JLabel jLabelDomicilioFactura;
    private javax.swing.JLabel jLabelFactura;
    private javax.swing.JLabel jLabelFec;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelHor;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelImporte;
    private javax.swing.JLabel jLabelNomApeClienteFactura;
    private javax.swing.JLabel jLabelNomCliente;
    private javax.swing.JLabel jLabelNroFactura;
    private javax.swing.JLabel jLabelNumCliente;
    private javax.swing.JLabel jLabelPedido;
    private javax.swing.JLabel jLabelTelefonoFactura;
    private javax.swing.JLabel jLabelZonaFactura;
    private javax.swing.JPanel jPanelDatosCliente;
    // End of variables declaration//GEN-END:variables

    void cargarDatos() {
        jLabelFactura.setText(String.valueOf(factura.getNumFactura()));
        jLabelFec.setText(String.valueOf(factura.getDatospedido().getFecha()));
        jLabelHor.setText(String.valueOf(factura.getDatospedido().getHora()));
        jLabelNomCliente.setText(factura.getDatoscliente().getNombre());
        jLabelNumCliente.setText(String.valueOf(factura.getDatoscliente().getIdCliente()));
        jLabelPedido.setText(String.valueOf(factura.getDatospedido().getIdPedido()));
        jLabelImporte.setText(String.valueOf(0));
    }
}