/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import Datos.Usuario;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class PrincipalAdministrador extends javax.swing.JFrame {
    
    Usuario usuarioSistema;

    /**
     * Creates new form PrincipalEncargado
     */
    public PrincipalAdministrador() {
        initComponents();
        setLocationRelativeTo(null);
        usuarioSistema = new Usuario();
        
    }
    
    public Usuario getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(Usuario usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonNuevoUsuario = new javax.swing.JButton();
        jButtonInformes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jButtonCerrarSesion = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuUsuarios = new javax.swing.JMenu();
        jMenuItemGestionUsuario = new javax.swing.JMenuItem();
        jMenuComidas = new javax.swing.JMenu();
        jMenuItemInformeActividades = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemInformacion = new javax.swing.JMenuItem();
        jMenuItemManual = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FastFoodSystem - Administrador");
        setBackground(new java.awt.Color(153, 204, 255));
        setMaximumSize(new java.awt.Dimension(740, 520));
        setMinimumSize(new java.awt.Dimension(740, 520));
        setResizable(false);

        jButtonNuevoUsuario.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/icono-usuario.png"))); // NOI18N
        jButtonNuevoUsuario.setText("Nuevo Usuario");
        jButtonNuevoUsuario.setMaximumSize(new java.awt.Dimension(210, 80));
        jButtonNuevoUsuario.setMinimumSize(new java.awt.Dimension(210, 80));
        jButtonNuevoUsuario.setPreferredSize(new java.awt.Dimension(210, 80));
        jButtonNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoUsuarioActionPerformed(evt);
            }
        });

        jButtonInformes.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonInformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/icono-informes.png"))); // NOI18N
        jButtonInformes.setText("Informe de Act.");
        jButtonInformes.setMaximumSize(new java.awt.Dimension(210, 80));
        jButtonInformes.setMinimumSize(new java.awt.Dimension(210, 80));
        jButtonInformes.setPreferredSize(new java.awt.Dimension(210, 80));
        jButtonInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInformesActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal.png"))); // NOI18N

        jButtonSalir.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/icono-salir-programa.png"))); // NOI18N
        jButtonSalir.setText("Salir del Programa");
        jButtonSalir.setMaximumSize(new java.awt.Dimension(210, 80));
        jButtonSalir.setMinimumSize(new java.awt.Dimension(210, 80));
        jButtonSalir.setPreferredSize(new java.awt.Dimension(210, 80));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonCerrarSesion.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Botones/icono-cerrar-sesion.png"))); // NOI18N
        jButtonCerrarSesion.setText("Cerrar Sesion");
        jButtonCerrarSesion.setMaximumSize(new java.awt.Dimension(210, 80));
        jButtonCerrarSesion.setMinimumSize(new java.awt.Dimension(210, 80));
        jButtonCerrarSesion.setPreferredSize(new java.awt.Dimension(210, 80));
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });

        jMenuUsuarios.setText("Usuarios");

        jMenuItemGestionUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemGestionUsuario.setText("Gestion Usuarios");
        jMenuItemGestionUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionUsuarioActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItemGestionUsuario);

        jMenuBar1.add(jMenuUsuarios);

        jMenuComidas.setText("Informes");

        jMenuItemInformeActividades.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemInformeActividades.setText("Informe de Actividades");
        jMenuItemInformeActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInformeActividadesActionPerformed(evt);
            }
        });
        jMenuComidas.add(jMenuItemInformeActividades);

        jMenuBar1.add(jMenuComidas);

        jMenuAyuda.setText("Ayuda");

        jMenuItemInformacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemInformacion.setText("Informacion");
        jMenuItemInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInformacionActionPerformed(evt);
            }
        });
        jMenuAyuda.add(jMenuItemInformacion);

        jMenuItemManual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemManual.setText("Manual de Usuario");
        jMenuItemManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemManualActionPerformed(evt);
            }
        });
        jMenuAyuda.add(jMenuItemManual);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(292, 292, 292)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(252, 252, 252)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonInformes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInformacionActionPerformed
        // TODO add your handling code here:
        VentanaInformacion f = new VentanaInformacion();
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItemInformacionActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this, "¿Esta Seguro que Desea Salir del Programa?", "FastFoodSystem - ATENCION", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.OK_OPTION == resp) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        int resp = JOptionPane.showConfirmDialog(this, "¿Esta Seguro que Desea Cerrar Sesion?", "FastFoodSystem - ATENCION", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.OK_OPTION == resp) {
            this.dispose();
            Login L = new Login();
            L.setVisible(true);
        }
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

    private void jMenuItemManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemManualActionPerformed
        // TODO add your handling code here:
        File f = new File("Manuales\\ManualUsuario.pdf"); // Creamos un objeto file
        //System.out.println("RUTA" + f.getAbsolutePath()); // Llamamos al método que devuelve la ruta absoluta
        //JOptionPane.showMessageDialog(this, "RUTA" + f.getAbsolutePath(), "FastFoodSystem", JOptionPane.ERROR_MESSAGE);
        abrirManual(f.getAbsolutePath());
    }//GEN-LAST:event_jMenuItemManualActionPerformed

    private void jMenuItemInformeActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInformeActividadesActionPerformed
        // TODO add your handling code here:
        VentanaInformeActividades IA = new VentanaInformeActividades();
        IA.setVisible(true);
    }//GEN-LAST:event_jMenuItemInformeActividadesActionPerformed

    private void jButtonInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInformesActionPerformed
        // TODO add your handling code here:
        VentanaInformeActividades IA = new VentanaInformeActividades();
        IA.setVisible(true);
    }//GEN-LAST:event_jButtonInformesActionPerformed

    private void jMenuItemGestionUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionUsuarioActionPerformed
        GestionarUsuario GU = new GestionarUsuario();
        GU.setUsuarioSistema(usuarioSistema);
        System.out.println(usuarioSistema.getIdUsuario());
        GU.setVisible(true);
    }//GEN-LAST:event_jMenuItemGestionUsuarioActionPerformed

    private void jButtonNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoUsuarioActionPerformed
        GestionarUsuario GU = new GestionarUsuario();
        GU.setUsuarioSistema(usuarioSistema);
        System.out.println(usuarioSistema.getIdUsuario());
        GU.setVisible(true);
    }//GEN-LAST:event_jButtonNuevoUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonInformes;
    private javax.swing.JButton jButtonNuevoUsuario;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuComidas;
    private javax.swing.JMenuItem jMenuItemGestionUsuario;
    private javax.swing.JMenuItem jMenuItemInformacion;
    private javax.swing.JMenuItem jMenuItemInformeActividades;
    private javax.swing.JMenuItem jMenuItemManual;
    private javax.swing.JMenu jMenuUsuarios;
    // End of variables declaration//GEN-END:variables
}
