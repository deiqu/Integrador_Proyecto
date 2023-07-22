package Roles;

import Databases.Conexion;
import javax.swing.JOptionPane;

public class IngresoUI extends javax.swing.JFrame {

    /**
     * Creates new form IngresoUI
     */
    public IngresoUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_username_global = new javax.swing.JTextField();
        pswf_contrasenia_global = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        btnSoporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Login");

        txt_username_global.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_username_globalActionPerformed(evt);
            }
        });

        pswf_contrasenia_global.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswf_contrasenia_globalActionPerformed(evt);
            }
        });

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnSoporte.setText("Soporte");
        btnSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIngresar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_username_global)
                                .addComponent(pswf_contrasenia_global, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnSoporte)))
                .addContainerGap(401, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(txt_username_global, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pswf_contrasenia_global, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(btnSoporte)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String nombreUsuario = txt_username_global.getText();
        String password = new String(pswf_contrasenia_global.getPassword());

        // Verificar la autenticación del usuario en la base de datos
        Conexion conexion = new Conexion();
        Usuario usuario = conexion.autenticarUsuario(nombreUsuario, password);
        if (usuario != null) {
            // Autenticación exitosa
            System.out.println("Usuario autenticado correctamente.");
            Rol rolNombre = usuario.getRol();
            if ("Administrador".equals(rolNombre.getNombre())) {
                Interfaces.Administrador.PrincipalUI ventanaPrincipalAdmin = new Interfaces.Administrador.PrincipalUI();
                ventanaPrincipalAdmin.setVisible(true);
            } else if ("Medico".equals(rolNombre.getNombre())) {
                Interfaces.Medico.Medico_PrincipalUI ventanaPrincipalMedico = new Interfaces.Medico.Medico_PrincipalUI();
                ventanaPrincipalMedico.setVisible(true);
            }
            // Ocultar la ventana de inicio de sesión en lugar de cerrarla
            this.setVisible(false);
        } else {
            // Autenticación fallida
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSoporteActionPerformed

    private void txt_username_globalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_username_globalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_username_globalActionPerformed

    private void pswf_contrasenia_globalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswf_contrasenia_globalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pswf_contrasenia_globalActionPerformed

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
            java.util.logging.Logger.getLogger(IngresoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            IngresoUI ventanaInicioSesion = new IngresoUI();
            ventanaInicioSesion.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSoporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField pswf_contrasenia_global;
    private javax.swing.JTextField txt_username_global;
    // End of variables declaration//GEN-END:variables
}
