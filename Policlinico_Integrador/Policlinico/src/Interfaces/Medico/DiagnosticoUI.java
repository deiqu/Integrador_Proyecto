package Interfaces.Medico;

import Databases.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DiagnosticoUI extends javax.swing.JFrame {

    private final StringBuilder diagnosticoTemporal;

    public DiagnosticoUI() {
        initComponents();
        diagnosticoTemporal = new StringBuilder();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_dni_paciente = new javax.swing.JTextField();
        txt_nombre_paciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_apellido_paciente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_fecha_nacimiento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_id_historia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_antecedentes = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_diagnostico_de_visita = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_plan_actual_tratamiento = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_enfermedad = new javax.swing.JTextArea();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel1.setText("Creación de diagnóstico");

        jLabel2.setText("Nombres");

        txt_nombre_paciente.setEditable(false);

        jLabel3.setText("Apellidos");

        txt_apellido_paciente.setEditable(false);

        jLabel4.setText("Fecha de nacimiento");

        txt_fecha_nacimiento.setEditable(false);

        jLabel5.setText("Dni");

        txt_id_historia.setEditable(false);

        jLabel6.setText("Antecedentes:");

        txt_antecedentes.setColumns(20);
        txt_antecedentes.setRows(5);
        jScrollPane1.setViewportView(txt_antecedentes);

        jLabel7.setText("Diagnóstico de visita");

        txt_diagnostico_de_visita.setColumns(20);
        txt_diagnostico_de_visita.setRows(5);
        jScrollPane2.setViewportView(txt_diagnostico_de_visita);

        jLabel8.setText("Plan de tratamiento actual");

        txt_plan_actual_tratamiento.setColumns(20);
        txt_plan_actual_tratamiento.setRows(5);
        jScrollPane3.setViewportView(txt_plan_actual_tratamiento);

        jLabel9.setText("Enfermedad");

        btnCrear.setText("Crear diagnóstico");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel10.setText("Historia:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txt_enfermedad.setColumns(20);
        txt_enfermedad.setRows(5);
        jScrollPane4.setViewportView(txt_enfermedad);

        btnActualizar.setText("Actualizar PACIENTES");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_nombre_paciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                .addComponent(txt_dni_paciente, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_apellido_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id_historia, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(btnCrear)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVolver)
                    .addComponent(jLabel5))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dni_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_apellido_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id_historia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 112, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrear)
                            .addComponent(btnActualizar))
                        .addGap(18, 18, 18))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        Medico_PrincipalUI principal = new Medico_PrincipalUI();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String dniPacienteStr = txt_dni_paciente.getText().trim();

        if (!dniPacienteStr.isEmpty()) {
            try {
                int dniPaciente = Integer.parseInt(dniPacienteStr);
                buscarPacientePorDNI(dniPaciente);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingresa un número de DNI válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingresa el número de DNI del paciente que deseas buscar.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
    private void buscarPacientePorDNI(int dniPaciente) {
        try (Connection conn = Conexion.obtenerConexion()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT nombres_paciente, apellidos_paciente, fecha_de_nacimiento_paciente, id_historia, antecedentes_paciente, enfermedades_paciente, visitas_paciente, tratamiento_paciente FROM pacientes WHERE dni_paciente = ?");
            stmt.setInt(1, dniPaciente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Mostrar los datos del paciente encontrado en los campos correspondientes
                    txt_nombre_paciente.setText(rs.getString("nombres_paciente"));
                    txt_apellido_paciente.setText(rs.getString("apellidos_paciente"));
                    txt_fecha_nacimiento.setText(rs.getString("fecha_de_nacimiento_paciente"));
                    txt_id_historia.setText(String.valueOf(rs.getInt("id_historia")));
                    txt_antecedentes.setText(rs.getString("antecedentes_paciente"));
                    txt_diagnostico_de_visita.setText(rs.getString("visitas_paciente"));
                    txt_plan_actual_tratamiento.setText(rs.getString("tratamiento_paciente"));
                    txt_enfermedad.setText(rs.getString("enfermedades_paciente"));
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún paciente con el DNI especificado.", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
                    // Limpiar los campos si no se encontró ningún paciente
                    txt_nombre_paciente.setText("");
                    txt_apellido_paciente.setText("");
                    txt_fecha_nacimiento.setText("");
                    txt_id_historia.setText("");
                    txt_antecedentes.setText("");
                    txt_diagnostico_de_visita.setText("");
                    txt_plan_actual_tratamiento.setText("");
                    txt_enfermedad.setText("");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        String diagnosticoVisita = txt_diagnostico_de_visita.getText();
        String planTratamiento = txt_plan_actual_tratamiento.getText();
        String enfermedad = txt_enfermedad.getText();
        String nombresPaciente = txt_nombre_paciente.getText();
        String apellidosPaciente = txt_apellido_paciente.getText();
        String fechaNacimientoPaciente = txt_fecha_nacimiento.getText();
        int idHistoria = Integer.parseInt(txt_id_historia.getText());
        String antecedentesPaciente = txt_antecedentes.getText();
        String visitasPaciente = txt_diagnostico_de_visita.getText();
        String tratamientoPaciente = txt_plan_actual_tratamiento.getText();

        if (!diagnosticoVisita.isEmpty() && !planTratamiento.isEmpty() && !enfermedad.isEmpty()
                && !nombresPaciente.isEmpty() && !apellidosPaciente.isEmpty() && !fechaNacimientoPaciente.isEmpty()
                && !antecedentesPaciente.isEmpty() && !visitasPaciente.isEmpty() && !tratamientoPaciente.isEmpty()) {

            String dniPacienteStr = txt_dni_paciente.getText().trim();

            if (!dniPacienteStr.isEmpty()) {
                try {
                    int dniPaciente = Integer.parseInt(dniPacienteStr);
                    crearDiagnostico(dniPaciente, diagnosticoVisita, planTratamiento, enfermedad,
                            nombresPaciente, apellidosPaciente, fechaNacimientoPaciente,
                            idHistoria, antecedentesPaciente, visitasPaciente, tratamientoPaciente);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingresa un número de DNI válido.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el diagnóstico en archivo temporal.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingresa el número de DNI del paciente antes de crear el diagnóstico.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingresa todos los campos requeridos para crear el diagnóstico.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnCrearActionPerformed
    private void crearDiagnostico(int dniPaciente, String diagnosticoVisita, String planTratamiento, String enfermedad, String nombresPaciente, String apellidosPaciente, String fechaNacimientoPaciente, int idHistoria, String antecedentesPaciente, String visitasPaciente, String tratamientoPaciente) throws IOException {
        try (Connection conn = Conexion.obtenerConexion()) {
            String sql = "INSERT INTO diagnosticos (dni_paciente, fecha_diagnostico, diagnostico_visita, plan_tratamiento, enfermedad, nombres_paciente, apellidos_paciente, fecha_de_nacimiento_paciente, id_historia, antecedentes_paciente, visitas_paciente, tratamiento_paciente) VALUES (?, CURRENT_DATE(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, dniPaciente);
                stmt.setString(2, diagnosticoVisita);
                stmt.setString(3, planTratamiento);
                stmt.setString(4, enfermedad);
                stmt.setString(5, nombresPaciente);
                stmt.setString(6, apellidosPaciente);
                stmt.setString(7, fechaNacimientoPaciente);
                stmt.setInt(8, idHistoria);
                stmt.setString(9, antecedentesPaciente);
                stmt.setString(10, visitasPaciente);
                stmt.setString(11, tratamientoPaciente);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Diagnóstico creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();

                    // Llamar al método para enviar el diagnóstico por WhatsApp
                    enviarDiagnosticoPorWhatsapp(dniPaciente, diagnosticoVisita, planTratamiento, enfermedad,
                            nombresPaciente, apellidosPaciente, fechaNacimientoPaciente,
                            idHistoria, antecedentesPaciente, visitasPaciente, tratamientoPaciente);

                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo crear el diagnóstico.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String obtenerTelefonoPaciente(int dniPaciente) {
        String telefonoPaciente = null;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_policlinico", "root", "")) {
            PreparedStatement stmt = conn.prepareStatement("SELECT telefono_paciente FROM pacientes WHERE dni_paciente = ?");
            stmt.setInt(1, dniPaciente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                telefonoPaciente = rs.getString("telefono_paciente");
            }
        } catch (SQLException ex) {
        }
        return telefonoPaciente;
    }
    private void enviarDiagnosticoPorWhatsapp(int dniPaciente, String diagnosticoVisita, String planTratamiento, String enfermedad, String nombresPaciente, String apellidosPaciente, String fechaNacimientoPaciente, int idHistoria, String antecedentesPaciente, String visitasPaciente, String tratamientoPaciente) {
        try {
            // Construir el mensaje de texto a enviar
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Nombres y Apellidos: ").append(nombresPaciente).append(" ").append(apellidosPaciente).append("\n")
                    .append("Fecha de diagnóstico: ").append(java.time.LocalDate.now()).append("\n")
                    .append("Número de historia: ").append(idHistoria).append("\n")
                    .append("Diagnóstico de visita: ").append(diagnosticoVisita).append("\n")
                    .append("Plan de tratamiento actual: ").append(planTratamiento);

            // Obtener el número de teléfono del paciente a partir del DNI
            String telefonoPaciente = obtenerTelefonoPaciente(dniPaciente);
            if (telefonoPaciente != null && !telefonoPaciente.isEmpty()) {
                // Construir el enlace de WhatsApp Web
                String url = "https://wa.me/51" + telefonoPaciente + "?text=" + java.net.URLEncoder.encode(mensaje.toString(), "UTF-8");

                // Abrir el enlace en el navegador
                try {
                    java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
                } catch (java.io.IOException | java.net.URISyntaxException ex) {
                    JOptionPane.showMessageDialog(this, "No se pudo abrir WhatsApp Web.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                JOptionPane.showMessageDialog(this, "Diagnóstico listo para enviar. Presiona OK para enviarlo por WhatsApp.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el número de teléfono del paciente asociado al DNI especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException | java.io.UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(this, "Error al enviar el diagnóstico.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        // Obtener los valores actualizados de los campos de texto
        String antecedentesPaciente = txt_antecedentes.getText();
        String enfermedadesPaciente = txt_enfermedad.getText();
        String visitasPaciente = txt_diagnostico_de_visita.getText();
        String tratamientoPaciente = txt_plan_actual_tratamiento.getText();

        // Obtener el DNI del paciente
        String dniPacienteStr = txt_dni_paciente.getText().trim();
        if (dniPacienteStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa el número de DNI del paciente antes de actualizar.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int dniPaciente = Integer.parseInt(dniPacienteStr);

            // Actualizar los campos en la tabla de pacientes
            try (Connection conn = Conexion.obtenerConexion()) {
                String sql = "UPDATE pacientes SET antecedentes_paciente=?, enfermedades_paciente=?, visitas_paciente=?, tratamiento_paciente=? WHERE dni_paciente=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, antecedentesPaciente);
                    stmt.setString(2, enfermedadesPaciente);
                    stmt.setString(3, visitasPaciente);
                    stmt.setString(4, tratamientoPaciente);
                    stmt.setInt(5, dniPaciente);
                    int rowsAffected = stmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo actualizar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresa un número de DNI válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void limpiarCampos() {
        // Limpiar los campos de texto
        txt_dni_paciente.setText("");
        txt_nombre_paciente.setText("");
        txt_apellido_paciente.setText("");
        txt_fecha_nacimiento.setText("");
        txt_id_historia.setText("");
        txt_antecedentes.setText("");
        txt_diagnostico_de_visita.setText("");
        txt_plan_actual_tratamiento.setText("");
        txt_enfermedad.setText("");
    }


    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DiagnosticoUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea txt_antecedentes;
    private javax.swing.JTextField txt_apellido_paciente;
    private javax.swing.JTextArea txt_diagnostico_de_visita;
    private javax.swing.JTextField txt_dni_paciente;
    private javax.swing.JTextArea txt_enfermedad;
    private javax.swing.JTextField txt_fecha_nacimiento;
    private javax.swing.JTextField txt_id_historia;
    private javax.swing.JTextField txt_nombre_paciente;
    private javax.swing.JTextArea txt_plan_actual_tratamiento;
    // End of variables declaration//GEN-END:variables
}
