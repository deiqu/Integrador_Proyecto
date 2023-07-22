package Interfaces.Administrador;

import Databases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CitaUI extends javax.swing.JFrame {

    public CitaUI() {
        initComponents();
        cargarEspecialidades();

        combobox_especialidades.addActionListener(this::combobox_especialidadesActionPerformed);

        actualizarTablaCitas();

        tabla_citas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = tabla_citas.getSelectedRow();
                if (filaSeleccionada != -1) { // Si hay una fila seleccionada
                    // Obtener los datos de la fila seleccionada
                    int idCita = (int) tabla_citas.getValueAt(filaSeleccionada, 0);
                    int dniPaciente = (int) tabla_citas.getValueAt(filaSeleccionada, 1);
                    String motivoVisita = (String) tabla_citas.getValueAt(filaSeleccionada, 2);
                    String fechaCita = (String) tabla_citas.getValueAt(filaSeleccionada, 3);
                    String nombresPaciente = (String) tabla_citas.getValueAt(filaSeleccionada, 4);
                    String apellidosPaciente = (String) tabla_citas.getValueAt(filaSeleccionada, 5);
                    String generoPaciente = (String) tabla_citas.getValueAt(filaSeleccionada, 6);
                    String fechaNacimientoPaciente = (String) tabla_citas.getValueAt(filaSeleccionada, 7);
                    int idHistorial = (int) tabla_citas.getValueAt(filaSeleccionada, 8);
                    String nombreMedico = (String) tabla_citas.getValueAt(filaSeleccionada, 9);
                    String especialidadMedico = (String) tabla_citas.getValueAt(filaSeleccionada, 10);

                    // Mostrar los datos en los campos correspondientes
                    txt_dni_paciente_cita.setText(String.valueOf(dniPaciente));
                    txt_motivo_cita.setText(motivoVisita);
                    txt_fecha_de_cita.setText(fechaCita);
                    txt_nombres_paciente_cita.setText(nombresPaciente);
                    txt_apellidos_paciente_cita.setText(apellidosPaciente);
                    txt_genero_paciente_cita.setText(generoPaciente);
                    txt_fecha_de_nacimiento_paciente_cita.setText(fechaNacimientoPaciente);
                    txt_numero_de_historia_paciente_cita.setText(String.valueOf(idHistorial));
                    combobox_especialidades.setSelectedItem(especialidadMedico);
                    cargarMedicosPorEspecialidad(especialidadMedico); // Cargar los médicos disponibles para la especialidad seleccionada
                    combobox_medicos_disponibles_cita.setSelectedItem(nombreMedico);
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_dni_paciente_cita = new javax.swing.JTextField();
        txt_nombres_paciente_cita = new javax.swing.JTextField();
        txt_apellidos_paciente_cita = new javax.swing.JTextField();
        txt_fecha_de_nacimiento_paciente_cita = new javax.swing.JTextField();
        txt_genero_paciente_cita = new javax.swing.JTextField();
        txt_numero_de_historia_paciente_cita = new javax.swing.JTextField();
        combobox_especialidades = new javax.swing.JComboBox<>();
        txt_fecha_de_cita = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_motivo_cita = new javax.swing.JTextArea();
        btnBuscar = new javax.swing.JButton();
        btnReservar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        combobox_medicos_disponibles_cita = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_citas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel1.setText("Gestión de Citas");

        jLabel3.setText("DNI:");

        jLabel4.setText("Nombres:");

        jLabel5.setText("Apellidos:");

        jLabel6.setText("Fecha de Nacimiento:");

        jLabel7.setText("Género:");

        jLabel8.setText("Número de Historia:");

        jLabel9.setText("Especialidad a Derivar:");

        jLabel10.setText("Fecha de Cita:");

        jLabel11.setText("Doctores Disponibles:");

        jLabel12.setText("Motivo de Cita:");

        txt_nombres_paciente_cita.setEditable(false);

        txt_apellidos_paciente_cita.setEditable(false);

        txt_fecha_de_nacimiento_paciente_cita.setEditable(false);

        txt_genero_paciente_cita.setEditable(false);

        txt_numero_de_historia_paciente_cita.setEditable(false);

        txt_motivo_cita.setColumns(20);
        txt_motivo_cita.setRows(5);
        jScrollPane1.setViewportView(txt_motivo_cita);

        btnBuscar.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnReservar.setBackground(new java.awt.Color(102, 102, 102));
        btnReservar.setForeground(new java.awt.Color(255, 255, 255));
        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(102, 102, 102));
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tabla_citas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabla_citas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_dni_paciente_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(txt_genero_paciente_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(177, 177, 177)
                                        .addComponent(txt_fecha_de_nacimiento_paciente_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel8)
                                                .addGap(51, 51, 51)
                                                .addComponent(jLabel6))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnBuscar)
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(txt_nombres_paciente_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(txt_apellidos_paciente_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnVolver))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combobox_especialidades, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combobox_medicos_disponibles_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_fecha_de_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReservar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(txt_numero_de_historia_paciente_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(btnVolver)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(8, 8, 8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addGap(6, 6, 6)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_dni_paciente_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscar)
                                    .addComponent(txt_apellidos_paciente_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nombres_paciente_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_genero_paciente_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_numero_de_historia_paciente_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fecha_de_nacimiento_paciente_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox_especialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox_medicos_disponibles_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fecha_de_cita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(btnReservar)))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // Realizar la búsqueda del paciente por DNI
        String dniPacienteStr = txt_dni_paciente_cita.getText().trim();

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

        try (Connection conn = Conexion.obtenerConexion();
                PreparedStatement stmt = conn.prepareStatement("SELECT dni_paciente, nombres_paciente, apellidos_paciente, fecha_de_nacimiento_paciente, genero_paciente, id_historia FROM pacientes WHERE dni_paciente = ?")) {
            stmt.setInt(1, dniPaciente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Mostrar los datos del paciente encontrado en los campos correspondientes
                    txt_nombres_paciente_cita.setText(rs.getString("nombres_paciente"));
                    txt_apellidos_paciente_cita.setText(rs.getString("apellidos_paciente"));
                    txt_fecha_de_nacimiento_paciente_cita.setText(rs.getString("fecha_de_nacimiento_paciente"));
                    txt_genero_paciente_cita.setText(rs.getString("genero_paciente"));
                    txt_numero_de_historia_paciente_cita.setText(rs.getString("id_historia"));
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró ningún paciente con el DNI especificado.", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
                    // Limpiar los campos si no se encontró ningún paciente
                    txt_nombres_paciente_cita.setText("");
                    txt_apellidos_paciente_cita.setText("");
                    txt_fecha_de_nacimiento_paciente_cita.setText("");
                    txt_genero_paciente_cita.setText("");
                    txt_numero_de_historia_paciente_cita.setText("");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        // Obtener los datos de la interfaz
        String dniPacienteStr = txt_dni_paciente_cita.getText().trim();
        String motivoVisita = txt_motivo_cita.getText();
        String fechaCita = txt_fecha_de_cita.getText();
        String nombresPaciente = txt_nombres_paciente_cita.getText();
        String apellidosPaciente = txt_apellidos_paciente_cita.getText();
        String generoPaciente = txt_genero_paciente_cita.getText();
        String fechaNacimientoPaciente = txt_fecha_de_nacimiento_paciente_cita.getText();
        String idHistorialStr = txt_numero_de_historia_paciente_cita.getText();
        String nombreMedico = combobox_medicos_disponibles_cita.getSelectedItem().toString();
        String especialidadMedico = combobox_especialidades.getSelectedItem().toString();

        // Realizar la reserva y guardar los datos en la base de datos
        try (Connection conn = Conexion.obtenerConexion();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO citas (id_citas, dni_paciente, motivo_visita, fecha_cita, nombres_paciente, apellidos_pacientes, genero_paciente, fecha_de_nacimiento_paciente, id_historial, nombre_medico, especialidad_medico) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            int idCita = Integer.parseInt(dniPacienteStr); // dni_paciente actúa como id de la cita
            int dniPaciente = Integer.parseInt(dniPacienteStr);
            int idHistorial = Integer.parseInt(idHistorialStr);

            stmt.setInt(1, idCita);
            stmt.setInt(2, dniPaciente);
            stmt.setString(3, motivoVisita);
            stmt.setString(4, fechaCita);
            stmt.setString(5, nombresPaciente);
            stmt.setString(6, apellidosPaciente);
            stmt.setString(7, generoPaciente);
            stmt.setString(8, fechaNacimientoPaciente);
            stmt.setInt(9, idHistorial);
            stmt.setString(10, nombreMedico);
            stmt.setString(11, especialidadMedico);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Cita reservada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Limpiar los campos después de la reserva
                txt_dni_paciente_cita.setText("");
                txt_motivo_cita.setText("");
                txt_fecha_de_cita.setText("");
                txt_nombres_paciente_cita.setText("");
                txt_apellidos_paciente_cita.setText("");
                txt_genero_paciente_cita.setText("");
                txt_fecha_de_nacimiento_paciente_cita.setText("");
                txt_numero_de_historia_paciente_cita.setText("");
                combobox_medicos_disponibles_cita.removeAllItems();

                // Actualizar la tabla de citas después de la reserva
                actualizarTablaCitas();
            } else {
                JOptionPane.showMessageDialog(this, "Error al reservar la cita.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnReservarActionPerformed
    private void actualizarTablaCitas() {
        try (Connection conn = Conexion.obtenerConexion();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM citas");
                ResultSet rs = stmt.executeQuery()) {

            // Crear un modelo de tabla para la tabla_citas
            DefaultTableModel model = new DefaultTableModel();
            tabla_citas.setModel(model);

            // Agregar las columnas al modelo
            model.addColumn("ID Cita");
            model.addColumn("DNI Paciente");
            model.addColumn("Motivo Visita");
            model.addColumn("Fecha Cita");
            model.addColumn("Nombres Paciente");
            model.addColumn("Apellidos Paciente");
            model.addColumn("Género Paciente");
            model.addColumn("Fecha de Nacimiento Paciente");
            model.addColumn("ID Historial");
            model.addColumn("Nombre Médico");
            model.addColumn("Especialidad Médico");

            // Agregar filas al modelo con los datos de la tabla
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_citas"),
                    rs.getInt("dni_paciente"),
                    rs.getString("motivo_visita"),
                    rs.getString("fecha_cita"),
                    rs.getString("nombres_paciente"),
                    rs.getString("apellidos_pacientes"),
                    rs.getString("genero_paciente"),
                    rs.getString("fecha_de_nacimiento_paciente"),
                    rs.getInt("id_historial"),
                    rs.getString("nombre_medico"),
                    rs.getString("especialidad_medico")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        PrincipalUI principal = new PrincipalUI();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cargarEspecialidades() {
        for (String especialidad : ESPECIALIDADES) {
            combobox_especialidades.addItem(especialidad);
        }
        try {
            Connection conn = Conexion.obtenerConexion();
            String sql = "SELECT DISTINCT especialidad_medico FROM medicos";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        combobox_especialidades.addItem(rs.getString("especialidad_medico"));
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarMedicosPorEspecialidad(String especialidad) {

        try (Connection conn = Conexion.obtenerConexion();
                PreparedStatement stmt = conn.prepareStatement("SELECT CONCAT(nombre_medico, ' ', apellido_medico) AS nombre_completo FROM medicos WHERE especialidad_medico = ?")) {

            stmt.setString(1, especialidad);
            try (ResultSet rs = stmt.executeQuery()) {
                // Resto del código...
                combobox_medicos_disponibles_cita.removeAllItems(); // Limpiar el JComboBox
                while (rs.next()) {
                    combobox_medicos_disponibles_cita.addItem(rs.getString("nombre_completo"));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void combobox_especialidadesActionPerformed(java.awt.event.ActionEvent evt) {
        String especialidadSeleccionada = combobox_especialidades.getSelectedItem().toString();
        cargarMedicosPorEspecialidad(especialidadSeleccionada);
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CitaUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CitaUI().setVisible(true);
        });
    }

    private static final String[] ESPECIALIDADES = {
        "Medicina General",
        "Pediatria",
        "Cardiologia",
        "Neumologia",
        "Gastroenterologia",
        "Oftalmologia"
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> combobox_especialidades;
    private javax.swing.JComboBox<String> combobox_medicos_disponibles_cita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_citas;
    private javax.swing.JTextField txt_apellidos_paciente_cita;
    private javax.swing.JTextField txt_dni_paciente_cita;
    private javax.swing.JTextField txt_fecha_de_cita;
    private javax.swing.JTextField txt_fecha_de_nacimiento_paciente_cita;
    private javax.swing.JTextField txt_genero_paciente_cita;
    private javax.swing.JTextArea txt_motivo_cita;
    private javax.swing.JTextField txt_nombres_paciente_cita;
    private javax.swing.JTextField txt_numero_de_historia_paciente_cita;
    // End of variables declaration//GEN-END:variables
}
