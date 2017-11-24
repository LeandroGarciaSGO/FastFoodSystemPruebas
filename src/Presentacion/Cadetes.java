/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.Cadete;
import Logica.AMBCadete;
import Datos.Cliente;
import Datos.Conexion;
import Datos.Usuario;
//import Logica.ABMCliente;
import Logica.ABMComida;
import Logica.OperacionesTransacciones;
import java.sql.Connection;
import java.sql.ResultSet;
//import Datos.Comida;
//import Logica.ABMComida;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableRowSorter;

/**
 *
 * @author Luji
 */
public class Cadetes extends javax.swing.JFrame {

    private Cadete datosCadete;
    private int condatos_vacio;
    private Statement sentencia;
    private ResultSet rsDatos;
    public int docant;
    private int numDocumento;
    private Usuario usuarioSistema;

    public Usuario getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(Usuario usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }
    
    /**
     * Creates new form DatosCadetes
     */
    public Cadetes() {
        initComponents();
        setLocationRelativeTo(null);

    }

    public Cadete getDatosCadete() {
        return datosCadete;
    }

    public void setDatosCadete(Cadete datosCadete) {
        this.datosCadete = datosCadete;
    }

    public int getCondatos_vacio() {
        return condatos_vacio;
    }

    public void setCondatos_vacio(int condatos_vacio) {
        this.condatos_vacio = condatos_vacio;
    }
    public int getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }

    void LlenarCampos() throws SQLException {
       
        if (condatos_vacio == 1) {
            jLabelCodigoCadete.setText(String.valueOf(datosCadete.getIdCadete()));
            jTextFieldNombre.setText(datosCadete.getNombre());
            jTextFieldApellido.setText(datosCadete.getApellido());
            jTextFieldDocumento.setText(String.valueOf(datosCadete.getNumDocumento()));
            jComboBoxTipoDoc.setSelectedItem(String.valueOf(datosCadete.getTipoDocumento()));
            jTextFieldDomicilio.setText(datosCadete.getDomicilio());
            jTextFieldTelefono.setText(String.valueOf(datosCadete.getTelefono()));
            docant= Integer.parseInt(String.valueOf(datosCadete.getNumDocumento()));
//            docanterior.setText(String.valueOf(datosCadete.getNumDocumento()));
//            docanterior.setVisible(false);
//            

        } else {
            Cadete C = new Cadete();
            try {
                jLabelCodigoCadete.setText(String.valueOf(C.obtenerSiguienteId()));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cadetes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //jTextFieldDocumento.setText(String.valueOf(getNumDocumento()));
            
            //jLabelCodigoCadete.setText(String.valueOf(AMBCadete.obtenerSiguienteId()));
            //jLabelCodigoCadete.setText(String.valueOf(AMBCadete.obtenerSiguienteId()));
            
            //jTextFieldDocumento.setText(String.valueOf(getNumDocumento()));
            
            //jLabelCodigoCadete.setText(String.valueOf(AMBCadete.obtenerSiguienteId()));
            //jLabelCodigoCadete.setText(String.valueOf(AMBCadete.obtenerSiguienteId()));
        }
    }

    
    
    
    private boolean validarCampos() {
        try {
            //Long.parseLong(jTextFieldTelefono.getText());
            if (jTextFieldNombre.getText().length() <= 0) {
                JOptionPane.showMessageDialog(this, " ERROR: El Nombre No Debe Ser Vacio", "FastFoodSystem", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (jTextFieldApellido.getText().length() <= 0) {
                JOptionPane.showMessageDialog(this, " ERROR: El Apellido No Debe Ser Vacio", "FastFoodSystem", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (Integer.parseInt(jTextFieldDocumento.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, " ERROR: El Documento No Debe Ser Vacio", "FastFoodSystem", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            //VER ESTO NO FUNCIONA
            if ((jComboBoxTipoDoc.getSelectedIndex()) == 0) {
                JOptionPane.showMessageDialog(this, " ERROR: Debe Seleccionar Una Opcion De Tipo Documento", "FastFoodSystem", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (jTextFieldDomicilio.getText().length() <= 0) {
                JOptionPane.showMessageDialog(this, " ERROR: El Domicilio No Debe Ser Vacio", "FastFoodSystem", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (jTextFieldTelefono.getText().length() <= 0) {
                JOptionPane.showMessageDialog(this, " ERROR: El Telefono No Debe Ser Vacio", "FastFoodSystem", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "-. ERROR: El Documento No debe ser vacio", "FastFoodSystem", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldDocumento = new javax.swing.JTextField();
        jTextFieldDomicilio = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jComboBoxTipoDoc = new javax.swing.JComboBox();
        jLabelCodigoCadete = new javax.swing.JLabel();
        jButtonGuardar = new javax.swing.JButton();
        jLabelError = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FastFoodSystem - Cadetes");
        setMinimumSize(new java.awt.Dimension(600, 380));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cadete", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14))); // NOI18N
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Codigo: ");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Documento:");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Tipo Documento:");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Domicilio: ");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Telefono:");

        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyTyped(evt);
            }
        });

        jTextFieldApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoKeyTyped(evt);
            }
        });

        jTextFieldDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDocumentoActionPerformed(evt);
            }
        });
        jTextFieldDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDocumentoKeyTyped(evt);
            }
        });

        jTextFieldTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoKeyTyped(evt);
            }
        });

        jComboBoxTipoDoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione el Tipo de Documento...", "DNI", "PASAPORTE" }));
        jComboBoxTipoDoc.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTelefono)
                            .addComponent(jTextFieldDomicilio)
                            .addComponent(jComboBoxTipoDoc, 0, 248, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombre)
                            .addComponent(jTextFieldApellido)
                            .addComponent(jTextFieldDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(jLabelCodigoCadete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabelCodigoCadete, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonGuardar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/icono-guardar.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setMaximumSize(new java.awt.Dimension(180, 50));
        jButtonGuardar.setMinimumSize(new java.awt.Dimension(180, 50));
        jButtonGuardar.setPreferredSize(new java.awt.Dimension(180, 50));
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(204, 0, 0));
        jLabel8.setForeground(new java.awt.Color(51, 255, 51));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/man2.png"))); // NOI18N
        jLabel8.setMaximumSize(new java.awt.Dimension(664, 593));
        jLabel8.setMinimumSize(new java.awt.Dimension(664, 593));

        jButtonCancelar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/icono-cancelar.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setMaximumSize(new java.awt.Dimension(180, 50));
        jButtonCancelar.setMinimumSize(new java.awt.Dimension(180, 50));
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(180, 50));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(486, 486, 486)
                                .addComponent(jLabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(82, 82, 82))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDocumentoActionPerformed


    
    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed

//int docant;
//docant =(Integer.parseInt(docanterior.getText()));


//docanterior.setEditable(false);
//JOptionPane.showMessageDialog(null,docant);
        if (validarCampos()) {
  
            Cadete C = new Cadete();
            //C.setIdCadete(Integer.parseInt(jLabelCodigoCadete.getText()));
            C.setNombre(jTextFieldNombre.getText());
            C.setApellido(jTextFieldApellido.getText());
            C.setNumDocumento(Integer.parseInt(jTextFieldDocumento.getText()));
            C.setTipoDocumento(String.valueOf(jComboBoxTipoDoc.getSelectedItem()));
            C.setDomicilio(jTextFieldDomicilio.getText());
            C.setTelefono(Long.parseLong(jTextFieldTelefono.getText()));
            AMBCadete ABMC = new AMBCadete();
            if (condatos_vacio != 1) {
                try {
                    try {
                        if (ABMC.nuevaCadet(C) == 1) {
                            JOptionPane.showMessageDialog(this, "-. ERROR: El cadete ya existe", "FastFoodSystem", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "El cadete se registro correctamente", "FastFoodSystem", JOptionPane.INFORMATION_MESSAGE);
                            OperacionesTransacciones OT = new OperacionesTransacciones();
                            int accion = 8;
                            int entidad = 4;
                            OT.registrarTransaccion(accion, entidad, Integer.parseInt(jLabelCodigoCadete.getText()), usuarioSistema);
                            GestionarCadete volverGestionarCadete= new GestionarCadete();
                            volverGestionarCadete.setUsuarioSistema(usuarioSistema);
                            volverGestionarCadete.setVisible(true);
                            this.dispose();
                            //setVisible(false);
                        }
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Cadetes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Cadetes.class.getName()).log(Level.SEVERE, null, ex);
           
                }
            } else {
//               
                try { 
                   
                   int docac;
                   docac= (Integer.parseInt(jTextFieldDocumento.getText()));
                   
                    try {
                        if (ABMC.esNueva(C) != 1){
                            C.setIdCadete(datosCadete.getIdCadete());
                            
                            C.cargar();
                            OperacionesTransacciones OT = new OperacionesTransacciones();
                            int accion = 9;
                            int entidad = 4;
                            OT.registrarTransaccion(accion, entidad, Integer.parseInt(jLabelCodigoCadete.getText()), usuarioSistema);
                            JOptionPane.showMessageDialog(this, "El cadete se modifico exitosamente", "FastFoodSystem", JOptionPane.INFORMATION_MESSAGE);
                            GestionarCadete volverGestionarCadete= new GestionarCadete();
                            volverGestionarCadete.setUsuarioSistema(usuarioSistema);
                            volverGestionarCadete.setVisible(true);
                            //setVisible(false);
                            this.dispose();
                            
                        }else{
                            
                            if(docac== docant){
                                C.setIdCadete(datosCadete.getIdCadete());
                                
                                C.cargar();
                                JOptionPane.showMessageDialog(this, "El cadete se modifico exitosamente", "FastFoodSystem" ,JOptionPane.INFORMATION_MESSAGE);
//                                GestionarCadete volverGestionarCadete= new GestionarCadete();
//                                volverGestionarCadete.setVisible(true);
//                                setVisible(false);
                            OperacionesTransacciones OT = new OperacionesTransacciones();
                            int accion = 9;
                            int entidad = 4;
                            OT.registrarTransaccion(accion, entidad, Integer.parseInt(jLabelCodigoCadete.getText()), usuarioSistema);
                            JOptionPane.showMessageDialog(this, "El cadete se modifico exitosamente", "FastFoodSystem", JOptionPane.INFORMATION_MESSAGE);
                            GestionarCadete volverGestionarCadete= new GestionarCadete();
                            volverGestionarCadete.setUsuarioSistema(usuarioSistema);
                            volverGestionarCadete.setVisible(true);
                            //setVisible(false);
                            this.dispose();
                                
                            }else {
                                JOptionPane.showMessageDialog(this, "-. ERROR: El Cadete Ya Existe", "FastFoodSystem", JOptionPane.ERROR_MESSAGE);
                                //GestionarCadete volverGestionarCadete= new GestionarCadete();
                            //volverGestionarCadete.setVisible(true);
                            //setVisible(false);
                            }}
                    } catch (SQLException ex) {
                        Logger.getLogger(Cadetes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Cadetes.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            
        
}  

    }//GEN-LAST:event_jButtonGuardarActionPerformed
    
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        //GestionarCadete G = new GestionarCadete();
        GestionarCadete volverGestionarCadete= new GestionarCadete();
        volverGestionarCadete.setVisible(true);
        setVisible(false);
       //this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyTyped
        // TODO add your handling code here:
        
       char c =evt.getKeyChar();
       if((c < 'a'|| c> 'z'  )&& (c < 'A'|| c> 'Z' ) )
           evt.consume();
      
       // evt.consume();
    }//GEN-LAST:event_jTextFieldNombreKeyTyped

    private void jTextFieldDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDocumentoKeyTyped
        char c =evt.getKeyChar();
        if(c < '0'|| c> '9') evt.consume();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDocumentoKeyTyped

    private void jTextFieldTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoKeyTyped
         char c =evt.getKeyChar();
        if(c < '0'|| c> '9') evt.consume();
// TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefonoKeyTyped

    private void jTextFieldApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoKeyTyped
        // TODO add your handling code here:
        char c =evt.getKeyChar();
       if((c < 'a'|| c> 'z'  )&& (c < 'A'|| c> 'Z' ) ) evt.consume();
    }//GEN-LAST:event_jTextFieldApellidoKeyTyped

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
            java.util.logging.Logger.getLogger(Cadetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadetes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadetes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox jComboBoxTipoDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCodigoCadete;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldDocumento;
    private javax.swing.JTextField jTextFieldDomicilio;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
