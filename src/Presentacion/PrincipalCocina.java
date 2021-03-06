/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.Cliente;
import Datos.Conexion;
import Datos.Usuario;
import Logica.OperacionesTransacciones;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTable;

/**
 *
 * @author Leandro
 */
public class PrincipalCocina extends javax.swing.JFrame {

    private Statement sentencia;
    private ResultSet rsDatos;
    private String estadoPedido;
    Usuario usuarioSistema;
    int codigoPedido;

    /**
     * Creates new form PrincipalEncargado
     *
     * @throws java.lang.ClassNotFoundException
     */
    public PrincipalCocina() throws ClassNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
        cargarTablaPedidos();
        usuarioSistema = new Usuario();

    }

    public Usuario getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(Usuario usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogDetallePedido = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTablaDetallesPedido = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jRadioButtonTerminarPedido = new javax.swing.JRadioButton();
        jRadioButtonIniciarElaboracion = new javax.swing.JRadioButton();
        jLabelPedido = new javax.swing.JLabel();
        jLabelNumPedido = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jButtonSalirDetallePedido = new javax.swing.JButton();
        buttonGroupGrupoDeEstados = new javax.swing.ButtonGroup();
        jButtonActualizarLista = new javax.swing.JButton();
        jButtonVerDetalle = new javax.swing.JButton();
        jButtonAyuda = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTablaPedidos = new javax.swing.JTable();
        jButtonCerrarSesion = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        jDialogDetallePedido.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogDetallePedido.setTitle("Detalle Del Pedido");
        jDialogDetallePedido.setMinimumSize(new java.awt.Dimension(650, 572));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle del Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 18))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(615, 550));
        jPanel1.setMinimumSize(new java.awt.Dimension(615, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(615, 500));

        jTableTablaDetallesPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo de Comida", "Descripción", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTablaDetallesPedido.setMaximumSize(new java.awt.Dimension(500, 240));
        jTableTablaDetallesPedido.setMinimumSize(new java.awt.Dimension(500, 240));
        jTableTablaDetallesPedido.setPreferredSize(new java.awt.Dimension(500, 240));
        jScrollPane1.setViewportView(jTableTablaDetallesPedido);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cambiar Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        jPanel2.setMaximumSize(new java.awt.Dimension(60, 526));
        jPanel2.setMinimumSize(new java.awt.Dimension(60, 526));

        buttonGroupGrupoDeEstados.add(jRadioButtonTerminarPedido);
        jRadioButtonTerminarPedido.setText("Terminar Pedido");
        jRadioButtonTerminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTerminarPedidoActionPerformed(evt);
            }
        });

        buttonGroupGrupoDeEstados.add(jRadioButtonIniciarElaboracion);
        jRadioButtonIniciarElaboracion.setText("Iniciar Elaboración");
        jRadioButtonIniciarElaboracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonIniciarElaboracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jRadioButtonIniciarElaboracion)
                .addGap(76, 76, 76)
                .addComponent(jRadioButtonTerminarPedido)
                .addGap(100, 100, 100))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonIniciarElaboracion)
                    .addComponent(jRadioButtonTerminarPedido))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabelPedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPedido.setText("Pedido Numero: ");

        jLabelNumPedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumPedido.setText("Num");

        jButtonAceptar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/actualizar-l.png"))); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.setMaximumSize(new java.awt.Dimension(300, 40));
        jButtonAceptar.setMinimumSize(new java.awt.Dimension(300, 40));
        jButtonAceptar.setPreferredSize(new java.awt.Dimension(260, 40));
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonSalirDetallePedido.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonSalirDetallePedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/icono-cancelar.png"))); // NOI18N
        jButtonSalirDetallePedido.setText("Salir");
        jButtonSalirDetallePedido.setMaximumSize(new java.awt.Dimension(260, 40));
        jButtonSalirDetallePedido.setMinimumSize(new java.awt.Dimension(300, 40));
        jButtonSalirDetallePedido.setPreferredSize(new java.awt.Dimension(260, 40));
        jButtonSalirDetallePedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirDetallePedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNumPedido))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonSalirDetallePedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(37, 37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPedido)
                    .addComponent(jLabelNumPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalirDetallePedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout jDialogDetallePedidoLayout = new javax.swing.GroupLayout(jDialogDetallePedido.getContentPane());
        jDialogDetallePedido.getContentPane().setLayout(jDialogDetallePedidoLayout);
        jDialogDetallePedidoLayout.setHorizontalGroup(
            jDialogDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogDetallePedidoLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDialogDetallePedidoLayout.setVerticalGroup(
            jDialogDetallePedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogDetallePedidoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FastFoodSystem - Principal Cocina");
        setBackground(new java.awt.Color(153, 204, 255));
        setMinimumSize(new java.awt.Dimension(670, 590));
        setResizable(false);

        jButtonActualizarLista.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonActualizarLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/icono-actualizar.png"))); // NOI18N
        jButtonActualizarLista.setText("Actualizar Lista");
        jButtonActualizarLista.setMaximumSize(new java.awt.Dimension(300, 80));
        jButtonActualizarLista.setMinimumSize(new java.awt.Dimension(300, 80));
        jButtonActualizarLista.setPreferredSize(new java.awt.Dimension(300, 80));
        jButtonActualizarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarListaActionPerformed(evt);
            }
        });

        jButtonVerDetalle.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonVerDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/icono-detalle.png"))); // NOI18N
        jButtonVerDetalle.setText("Ver Detalle Pedido");
        jButtonVerDetalle.setMaximumSize(new java.awt.Dimension(300, 80));
        jButtonVerDetalle.setMinimumSize(new java.awt.Dimension(300, 80));
        jButtonVerDetalle.setPreferredSize(new java.awt.Dimension(300, 80));
        jButtonVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerDetalleActionPerformed(evt);
            }
        });

        jButtonAyuda.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/icono-ayuda.png"))); // NOI18N
        jButtonAyuda.setText("Ayuda");
        jButtonAyuda.setMaximumSize(new java.awt.Dimension(180, 40));
        jButtonAyuda.setMinimumSize(new java.awt.Dimension(180, 40));
        jButtonAyuda.setPreferredSize(new java.awt.Dimension(180, 40));
        jButtonAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAyudaActionPerformed(evt);
            }
        });

        jTableTablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Num de Pedido", "Estado", "Fecha", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTablaPedidos.setMaximumSize(new java.awt.Dimension(660, 400));
        jTableTablaPedidos.setMinimumSize(new java.awt.Dimension(660, 400));
        jTableTablaPedidos.setPreferredSize(new java.awt.Dimension(660, 400));
        jScrollPane2.setViewportView(jTableTablaPedidos);

        jButtonCerrarSesion.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/icono-cerrar-sesion.png"))); // NOI18N
        jButtonCerrarSesion.setText("Cerrar Sesion");
        jButtonCerrarSesion.setMaximumSize(new java.awt.Dimension(210, 40));
        jButtonCerrarSesion.setMinimumSize(new java.awt.Dimension(210, 40));
        jButtonCerrarSesion.setPreferredSize(new java.awt.Dimension(210, 40));
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });

        jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/icono-salir-programa.png"))); // NOI18N
        jButtonSalir.setText("Salir del Programa");
        jButtonSalir.setMaximumSize(new java.awt.Dimension(210, 40));
        jButtonSalir.setMinimumSize(new java.awt.Dimension(210, 40));
        jButtonSalir.setPreferredSize(new java.awt.Dimension(210, 40));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonActualizarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonActualizarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVerDetalle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerDetalleActionPerformed
        // TODO add your handling code here:

        DefaultTableModel modelo = (DefaultTableModel) jTableTablaPedidos.getModel();
        int fila = jTableTablaPedidos.getSelectedRow();
        if (fila >= 0) {
            int filasselec = jTableTablaPedidos.getSelectedRow();
            codigoPedido = Integer.parseInt(String.valueOf(modelo.getValueAt(filasselec, 0)));
            try {
                cargarTablaDetallesPedido(codigoPedido);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PrincipalCocina.class.getName()).log(Level.SEVERE, null, ex);
            }
            estadoPedido = String.valueOf(modelo.getValueAt(filasselec, 1));
            System.out.println("ESTADO: " + estadoPedido);
            if (estadoPedido.equalsIgnoreCase("Enviado a cocina")) {
                jRadioButtonIniciarElaboracion.setEnabled(true);
                jRadioButtonIniciarElaboracion.setSelected(true);
                jRadioButtonTerminarPedido.setEnabled(false);
            }
            if (estadoPedido.equalsIgnoreCase("En elaboracion")) {
                jRadioButtonTerminarPedido.setEnabled(true);
                jRadioButtonIniciarElaboracion.setEnabled(false);
                jRadioButtonTerminarPedido.setSelected(true);
            }
            jLabelNumPedido.setText(String.valueOf(codigoPedido));
            jDialogDetallePedido.setSize(670, 592);
            jDialogDetallePedido.setLocationRelativeTo(null);
            jDialogDetallePedido.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No Selecciono Ninguna Fila", "Fast Food System", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonVerDetalleActionPerformed

    public void actualizarEstado(int codigoPedido, String estado) {

        int estadoPedidoInt = 0;
        if (estado.equalsIgnoreCase("enviado a cocina")) {
            estadoPedidoInt = 2;
        }
        if (estado.equalsIgnoreCase("en elaboracion")) {
            estadoPedidoInt = 3;
        }
        try {
            Connection conex = Conexion.Cadena();
            String ConsultaSQL = "UPDATE pedido SET estado = '" + estadoPedidoInt + "' WHERE idPedido = '" + codigoPedido + "' ";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(ConsultaSQL);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrincipalCocina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalCocina.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void abrirManual(String archivo) {

        System.out.println(archivo);
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);

        } catch (IOException ex) {

            System.out.println(ex);

        }

    }
    
    
    private void jButtonActualizarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActualizarListaActionPerformed

    private void jRadioButtonIniciarElaboracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonIniciarElaboracionActionPerformed

    }//GEN-LAST:event_jRadioButtonIniciarElaboracionActionPerformed

    private void jButtonAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAyudaActionPerformed
        // TODO add your handling code here:
        File f = new File("Manuales\\ManualUsuario.pdf"); // Creamos un objeto file
        System.out.println("RUTA" + f.getAbsolutePath()); // Llamamos al método que devuelve la ruta absoluta
        //JOptionPane.showMessageDialog(this, "RUTA" + f.getAbsolutePath(), "FastFoodSystem", JOptionPane.ERROR_MESSAGE);
        abrirManual(f.getAbsolutePath()); 
    }//GEN-LAST:event_jButtonAyudaActionPerformed

    private void jRadioButtonTerminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTerminarPedidoActionPerformed

    }//GEN-LAST:event_jRadioButtonTerminarPedidoActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
// TODO add your handling code he
        OperacionesTransacciones OT = new OperacionesTransacciones();
        int numPedido = Integer.parseInt(jLabelNumPedido.getText());
        actualizarEstado(numPedido, estadoPedido);
        int entidad = 3;
        try {
            cargarTablaPedidos();
            if(jRadioButtonIniciarElaboracion.isSelected()){
            int accion = 19;
            OT.registrarTransaccion(accion, entidad, codigoPedido, usuarioSistema);
        }
           else{
            int accion = 20;
            OT.registrarTransaccion(accion, entidad, codigoPedido, usuarioSistema);
        } 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrincipalCocina.class.getName()).log(Level.SEVERE, null, ex);
        }
       jDialogDetallePedido.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonSalirDetallePedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirDetallePedidoActionPerformed
        // TODO add your handling code here:
        jDialogDetallePedido.dispose();
    }//GEN-LAST:event_jButtonSalirDetallePedidoActionPerformed

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        int resp = JOptionPane.showConfirmDialog(this, "¿Esta Seguro que Desea Cerrar Sesion?", "FastFoodSystem - ATENCION", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.OK_OPTION == resp) {
            this.dispose();
            Login L = new Login();
            L.setVisible(true);
        }
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this, "¿Esta Seguro que Desea Salir del Programa?", "FastFoodSystem - ATENCION", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.OK_OPTION == resp) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButtonSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public void cargarTablaPedidos() throws ClassNotFoundException {
        //jTableTablaPedidos = new JTable();
        String datos[] = new String[4];
        DefaultTableModel dtm = (DefaultTableModel) jTableTablaPedidos.getModel();
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        try {
            Connection conex = Conexion.Cadena();
            String ConsultaSQL = "SELECT * FROM pedido where estado!=0 and estado!=3 and estado!=4";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);
            while (rsDatos.next()) {
                datos[0] = rsDatos.getString(1);
                //String estado = ABMPedido.buscarEstadoPedido(datos[1]= rsDatos.getString(3));
                datos[1] = rsDatos.getString(3);
                int estado = Integer.parseInt(String.valueOf(rsDatos.getString(3)));
                switch (estado) {
                    //case 0: datos[1] = "Cancelado"; break;
                    case 1:
                        datos[1] = "Enviado a cocina";
                        break;
                    case 2:
                        datos[1] = "En elaboracion";
                        break;
                    case 3:
                        datos[1] = "Listo para enviar";
                        break;
                    //case 4: datos[1] = "Enviado al cliente"; break;
                }
                datos[2] = rsDatos.getString(4);
                datos[3] = rsDatos.getString(5);
                dtm.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarTablaDetallesPedido(int codigoPedido) throws ClassNotFoundException {
        String datos[] = new String[3];
        DefaultTableModel dtm = (DefaultTableModel) jTableTablaDetallesPedido.getModel();
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        try {
            Connection conex = Conexion.Cadena();
            String ConsultaSQL = "SELECT * FROM detallepedido WHERE idPedido = '" + codigoPedido + "' ";
            sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsDatos = sentencia.executeQuery(ConsultaSQL);

            while (rsDatos.next()) {
                datos[0] = rsDatos.getString(1); // CODIGO COMIDA
                datos[2] = rsDatos.getString(3); // CANTIDAD
                String ConsultaSQL2 = "SELECT descripcion FROM comida WHERE idComida = '" + datos[0] + "' ";
                sentencia = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rsDatos = sentencia.executeQuery(ConsultaSQL2);
                while (rsDatos.next()) {
                    datos[1] = rsDatos.getString(1);
                }
                dtm.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupGrupoDeEstados;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonActualizarLista;
    private javax.swing.JButton jButtonAyuda;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSalirDetallePedido;
    private javax.swing.JButton jButtonVerDetalle;
    private javax.swing.JDialog jDialogDetallePedido;
    private javax.swing.JLabel jLabelNumPedido;
    private javax.swing.JLabel jLabelPedido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonIniciarElaboracion;
    private javax.swing.JRadioButton jRadioButtonTerminarPedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableTablaDetallesPedido;
    private javax.swing.JTable jTableTablaPedidos;
    // End of variables declaration//GEN-END:variables
}
