/* Diego */
package Interfaces.Administrador;

import Databases.Conexion;
import Logica.Pacientes_Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class PacienteUI extends javax.swing.JFrame {

    private final DefaultTableModel modeloTabla;
    private final List<Pacientes_Controller> pacientes;
    private int filaSeleccionada = -1;
    private Pacientes_Controller pacienteSeleccionado = null;
    private int dniSeleccionado = -1;

    public PacienteUI() {
        initComponents();

        txt_dni_paciente.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarNumeroHistoria();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarNumeroHistoria();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarNumeroHistoria();
            }
        });

        pacientes = new ArrayList<>();

        modeloTabla = new DefaultTableModel(
                new String[]{"DNI", "Nombres", "Apellidos", "Género", "Fecha de Nacimiento", "Teléfono", "Contacto de Emergencia", "ID Historia", "Antecedentes", "Enfermedades", "Visitas", "Tratamiento"},
                0 // Inicialmente sin datos
        );

        // Asignar el modelo de tabla a la tabla_pacientes
        tabla_pacientes.setModel(modeloTabla);

        // Agregar un listener para capturar la selección de fila en la tabla
        tabla_pacientes.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                filaSeleccionada = tabla_pacientes.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    pacienteSeleccionado = pacientes.get(filaSeleccionada);
                    dniSeleccionado = pacienteSeleccionado.getDni_paciente();
                    llenarFormulario(pacienteSeleccionado);
                } else {
                    pacienteSeleccionado = null;
                    dniSeleccionado = -1;
                }
            }
        });

        // Cargar datos desde la base de datos y actualizar la tabla
        cargarDatosDesdeBaseDeDatos();
        actualizarTabla();
    }

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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_dni_paciente = new javax.swing.JTextField();
        txt_nombres_paciente = new javax.swing.JTextField();
        txt_apellidos_paciente = new javax.swing.JTextField();
        combobox_genero_paciente = new javax.swing.JComboBox<>();
        txt_telefono_paciente = new javax.swing.JTextField();
        txt_fecha_nacimiento_paciente = new javax.swing.JTextField();
        txt_contacto_emergencia_paciente = new javax.swing.JTextField();
        txt_numero_historia_paciente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_antecedentes_paciente = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_historial_enfermedades_paciente = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_visitas_anteriores_pacientes = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_tratamiento_actual = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla_pacientes = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel1.setText("Creación de Paciente");

        jLabel2.setText("DNI:");

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellidos");

        jLabel5.setText("Genero:");

        jLabel6.setText("Fecha de Nacimiento:");

        jLabel7.setText("Telefono:");

        jLabel8.setText("Contacto de Emergencia:");

        jLabel9.setText("Numero de Historia Asociado:");

        jLabel10.setText("Antecedentes:");

        jLabel11.setText("Historial de Enfermedades:");

        jLabel12.setText("Visitas Anteriores:");

        jLabel13.setText("Tratamiento Actual:");

        combobox_genero_paciente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        combobox_genero_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_genero_pacienteActionPerformed(evt);
            }
        });

        txt_numero_historia_paciente.setEditable(false);
        txt_numero_historia_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numero_historia_pacienteActionPerformed(evt);
            }
        });

        txt_antecedentes_paciente.setColumns(20);
        txt_antecedentes_paciente.setRows(5);
        jScrollPane1.setViewportView(txt_antecedentes_paciente);

        txt_historial_enfermedades_paciente.setColumns(20);
        txt_historial_enfermedades_paciente.setRows(5);
        jScrollPane2.setViewportView(txt_historial_enfermedades_paciente);

        txt_visitas_anteriores_pacientes.setColumns(20);
        txt_visitas_anteriores_pacientes.setRows(5);
        jScrollPane3.setViewportView(txt_visitas_anteriores_pacientes);

        txt_tratamiento_actual.setColumns(20);
        txt_tratamiento_actual.setRows(5);
        jScrollPane4.setViewportView(txt_tratamiento_actual);

        tabla_pacientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tabla_pacientes);

        btnRegistrar.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(102, 102, 102));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(102, 102, 102));
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addGap(30, 30, 30)
                        .addComponent(btnEditar)
                        .addGap(29, 29, 29)
                        .addComponent(btnEliminar)
                        .addGap(28, 28, 28)
                        .addComponent(btnLimpiar)
                        .addGap(27, 27, 27)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_telefono_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_contacto_emergencia_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txt_numero_historia_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_dni_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombres_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_apellidos_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combobox_genero_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txt_fecha_nacimiento_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnVolver))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnRegistrar)
                                .addComponent(btnEditar)
                                .addComponent(btnEliminar)
                                .addComponent(btnLimpiar)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_dni_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nombres_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_apellidos_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combobox_genero_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_fecha_nacimiento_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_telefono_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_contacto_emergencia_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_numero_historia_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10))
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarDatosDesdeBaseDeDatos() {
        try (Connection conexion = Conexion.obtenerConexion()) {
            String query = "SELECT * FROM pacientes";
            try (PreparedStatement pstmt = conexion.prepareStatement(query);
                    ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Pacientes_Controller paciente = new Pacientes_Controller();
                    paciente.setDni_paciente(rs.getInt("dni_paciente"));
                    paciente.setNombres_paciente(rs.getString("nombres_paciente"));
                    paciente.setApellidos_paciente(rs.getString("apellidos_paciente"));
                    paciente.setGenero_paciente(rs.getString("genero_paciente"));
                    paciente.setFecha_de_nacimiento_paciente(rs.getDate("fecha_de_nacimiento_paciente"));
                    paciente.setTelefono_paciente(rs.getInt("telefono_paciente"));
                    paciente.setContacto_de_emergencia_paciente(rs.getInt("contacto_de_emergencia_paciente"));
                    paciente.setId_historia(rs.getInt("id_historia"));
                    paciente.setAntecedentes_paciente(rs.getString("antecedentes_paciente"));
                    paciente.setEnfermedades_paciente(rs.getString("enfermedades_paciente"));
                    paciente.setVisitas_paciente(rs.getString("visitas_paciente"));
                    paciente.setTratamiento_paciente(rs.getString("tratamiento_paciente"));

                    pacientes.add(paciente);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos desde la base de datos: " + ex.getMessage());
        }
    }
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // Validar que ningún campo quede en blanco
        if (camposCompletos()) {
            // Obtener los datos ingresados por el usuario desde los componentes de la interfaz
            try {
                int dni = Integer.parseInt(txt_dni_paciente.getText());
                String nombres = txt_nombres_paciente.getText();
                String apellidos = txt_apellidos_paciente.getText();
                String genero = combobox_genero_paciente.getSelectedItem().toString();

                // Obtener la fecha de nacimiento desde el componente de la interfaz
                String fechaNacimientoStr = txt_fecha_nacimiento_paciente.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaNacimiento = dateFormat.parse(fechaNacimientoStr);

                String antecedentes = txt_antecedentes_paciente.getText();
                String enfermedades = txt_historial_enfermedades_paciente.getText();
                String visitas = txt_visitas_anteriores_pacientes.getText();
                String tratamiento = txt_tratamiento_actual.getText();

                // Crear una instancia de Pacientes_Controller y establecer los valores
                Pacientes_Controller paciente = new Pacientes_Controller();
                paciente.setDni_paciente(dni);
                paciente.setNombres_paciente(nombres);
                paciente.setApellidos_paciente(apellidos);
                paciente.setGenero_paciente(genero);
                paciente.setFecha_de_nacimiento_paciente(fechaNacimiento);
                paciente.setTelefono_paciente(Integer.parseInt(txt_telefono_paciente.getText()));
                paciente.setContacto_de_emergencia_paciente(Integer.parseInt(txt_contacto_emergencia_paciente.getText()));
                paciente.setId_historia(Integer.parseInt(txt_numero_historia_paciente.getText()));
                paciente.setAntecedentes_paciente(antecedentes);
                paciente.setEnfermedades_paciente(enfermedades);
                paciente.setVisitas_paciente(visitas);
                paciente.setTratamiento_paciente(tratamiento);

                // Guardar el paciente en la base de datos
                try (Connection conexion = Conexion.obtenerConexion()) {
                    String query = "INSERT INTO pacientes (dni_paciente, nombres_paciente, apellidos_paciente, genero_paciente, fecha_de_nacimiento_paciente, telefono_paciente, contacto_de_emergencia_paciente, id_historia, antecedentes_paciente, enfermedades_paciente, visitas_paciente, tratamiento_paciente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
                        pstmt.setInt(1, paciente.getDni_paciente());
                        pstmt.setString(2, paciente.getNombres_paciente());
                        pstmt.setString(3, paciente.getApellidos_paciente());
                        pstmt.setString(4, paciente.getGenero_paciente());
                        pstmt.setDate(5, new java.sql.Date(paciente.getFecha_de_nacimiento_paciente().getTime()));
                        pstmt.setInt(6, paciente.getTelefono_paciente());
                        pstmt.setInt(7, paciente.getContacto_de_emergencia_paciente());
                        pstmt.setInt(8, paciente.getId_historia());
                        pstmt.setString(9, paciente.getAntecedentes_paciente());
                        pstmt.setString(10, paciente.getEnfermedades_paciente());
                        pstmt.setString(11, paciente.getVisitas_paciente());
                        pstmt.setString(12, paciente.getTratamiento_paciente());
                        pstmt.executeUpdate();
                    }
                }

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Paciente registrado exitosamente.");

                // Limpiar los campos después de registrar
                limpiarCampos();

                // Agregar el paciente a la lista y actualizar la tabla para mostrar los datos registrados
                pacientes.add(paciente);
                actualizarTabla();

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Error al obtener la fecha de nacimiento: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Asegúrate de ingresar números válidos en los campos de número.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al registrar el paciente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Todos los campos son requeridos. Por favor, completa todos los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed
    private boolean camposCompletos() {
        return !txt_dni_paciente.getText().isEmpty()
                && !txt_nombres_paciente.getText().isEmpty()
                && !txt_apellidos_paciente.getText().isEmpty()
                && combobox_genero_paciente.getSelectedItem() != null
                && !txt_fecha_nacimiento_paciente.getText().isEmpty()
                && !txt_telefono_paciente.getText().isEmpty()
                && !txt_contacto_emergencia_paciente.getText().isEmpty()
                && !txt_antecedentes_paciente.getText().isEmpty()
                && !txt_historial_enfermedades_paciente.getText().isEmpty()
                && !txt_tratamiento_actual.getText().isEmpty()
                && !txt_visitas_anteriores_pacientes.getText().isEmpty();

    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (filaSeleccionada >= 0 && pacienteSeleccionado != null) {
            // Mostrar un pop-up para confirmar la edición
            int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres guardar estos cambios?", "Confirmar edición", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                // Actualizar los datos del paciente seleccionado con los datos del formulario
                pacienteSeleccionado.setDni_paciente(Integer.parseInt(txt_dni_paciente.getText()));
                pacienteSeleccionado.setNombres_paciente(txt_nombres_paciente.getText());
                pacienteSeleccionado.setApellidos_paciente(txt_apellidos_paciente.getText());
                pacienteSeleccionado.setGenero_paciente(combobox_genero_paciente.getSelectedItem().toString());
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaNacimiento = dateFormat.parse(txt_fecha_nacimiento_paciente.getText());
                    pacienteSeleccionado.setFecha_de_nacimiento_paciente(fechaNacimiento);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Error al obtener la fecha de nacimiento: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                pacienteSeleccionado.setTelefono_paciente(Integer.parseInt(txt_telefono_paciente.getText()));
                pacienteSeleccionado.setContacto_de_emergencia_paciente(Integer.parseInt(txt_contacto_emergencia_paciente.getText()));
                pacienteSeleccionado.setId_historia(Integer.parseInt(txt_numero_historia_paciente.getText()));
                pacienteSeleccionado.setAntecedentes_paciente(txt_antecedentes_paciente.getText());
                pacienteSeleccionado.setEnfermedades_paciente(txt_historial_enfermedades_paciente.getText());
                pacienteSeleccionado.setVisitas_paciente(txt_visitas_anteriores_pacientes.getText());
                pacienteSeleccionado.setTratamiento_paciente(txt_tratamiento_actual.getText());

                // Actualizar el paciente en la base de datos
                try (Connection conexion = Conexion.obtenerConexion()) {
                    String query = "UPDATE pacientes SET dni_paciente=?, nombres_paciente=?, apellidos_paciente=?, genero_paciente=?, fecha_de_nacimiento_paciente=?, telefono_paciente=?, contacto_de_emergencia_paciente=?, id_historia=?, antecedentes_paciente=?, enfermedades_paciente=?, visitas_paciente=?, tratamiento_paciente=? WHERE dni_paciente=?";
                    try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
                        pstmt.setInt(1, pacienteSeleccionado.getDni_paciente());
                        pstmt.setString(2, pacienteSeleccionado.getNombres_paciente());
                        pstmt.setString(3, pacienteSeleccionado.getApellidos_paciente());
                        pstmt.setString(4, pacienteSeleccionado.getGenero_paciente());
                        pstmt.setDate(5, new java.sql.Date(pacienteSeleccionado.getFecha_de_nacimiento_paciente().getTime()));
                        pstmt.setInt(6, pacienteSeleccionado.getTelefono_paciente());
                        pstmt.setInt(7, pacienteSeleccionado.getContacto_de_emergencia_paciente());
                        pstmt.setInt(8, pacienteSeleccionado.getId_historia());
                        pstmt.setString(9, pacienteSeleccionado.getAntecedentes_paciente());
                        pstmt.setString(10, pacienteSeleccionado.getEnfermedades_paciente());
                        pstmt.setString(11, pacienteSeleccionado.getVisitas_paciente());
                        pstmt.setString(12, pacienteSeleccionado.getTratamiento_paciente());
                        pstmt.setInt(13, dniSeleccionado);
                        pstmt.executeUpdate();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el paciente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Paciente actualizado exitosamente.");

                // Actualizar la tabla con los cambios
                actualizarTabla();

                // Limpiar los campos después de la edición
                limpiarCampos();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (filaSeleccionada >= 0 && pacienteSeleccionado != null) {
            // Mostrar un pop-up para confirmar la eliminación
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres eliminar este paciente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                // Eliminar el paciente de la base de datos
                try (Connection conexion = Conexion.obtenerConexion()) {
                    String query = "DELETE FROM pacientes WHERE dni_paciente=?";
                    try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
                        pstmt.setInt(1, dniSeleccionado);
                        pstmt.executeUpdate();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el paciente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Paciente eliminado exitosamente.");

                // Eliminar el paciente de la lista y actualizar la tabla
                pacientes.remove(filaSeleccionada);
                actualizarTabla();

                // Limpiar los campos después de la eliminación
                limpiarCampos();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        // Mostrar un cuadro de diálogo para que el usuario ingrese el DNI
        String dniStr = JOptionPane.showInputDialog(this, "Ingrese el DNI del paciente:");

        // Comprobar si el usuario ingresó un DNI
        if (dniStr != null && !dniStr.isEmpty()) {
            try {
                int dniBuscado = Integer.parseInt(dniStr);
                Pacientes_Controller pacienteEncontrado = buscarPacientePorDni(dniBuscado);

                if (pacienteEncontrado != null) {
                    // Si se encuentra un paciente con el DNI ingresado, mostrar sus datos en el formulario
                    pacienteSeleccionado = pacienteEncontrado;
                    dniSeleccionado = dniBuscado;
                    llenarFormulario(pacienteSeleccionado);
                } else {
                    // Si no se encuentra un paciente con el DNI ingresado, mostrar un mensaje de error
                    JOptionPane.showMessageDialog(this, "No se encuentra paciente con el DNI ingresado. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un DNI válido (números solamente).", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
    private Pacientes_Controller buscarPacientePorDni(int dniBuscado) {
        for (Pacientes_Controller paciente : pacientes) {
            if (paciente.getDni_paciente() == dniBuscado) {
                return paciente;
            }
        }
        return null; // Retorna null si no se encuentra el paciente con el DNI buscado
    }
    private void combobox_genero_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_genero_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_genero_pacienteActionPerformed

    private void txt_numero_historia_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numero_historia_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numero_historia_pacienteActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        PrincipalUI principal = new PrincipalUI();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void actualizarTabla() {
        // Limpiamos los datos existentes en la tabla
        modeloTabla.setRowCount(0);

        // Por cada paciente en la lista, añadir una nueva fila en la tabla
        for (Pacientes_Controller paciente : pacientes) {
            Object[] fila = {
                paciente.getDni_paciente(),
                paciente.getNombres_paciente(),
                paciente.getApellidos_paciente(),
                paciente.getGenero_paciente(),
                paciente.getFecha_de_nacimiento_paciente(),
                paciente.getTelefono_paciente(),
                paciente.getContacto_de_emergencia_paciente(),
                paciente.getId_historia(),
                paciente.getAntecedentes_paciente(),
                paciente.getEnfermedades_paciente(),
                paciente.getVisitas_paciente(),
                paciente.getTratamiento_paciente()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void limpiarCampos() {
        // Método para limpiar los campos de la interfaz después de registrar
        txt_dni_paciente.setText("");
        txt_nombres_paciente.setText("");
        txt_apellidos_paciente.setText("");
        combobox_genero_paciente.setSelectedIndex(0);
        txt_fecha_nacimiento_paciente.setText("");
        txt_telefono_paciente.setText("");
        txt_contacto_emergencia_paciente.setText("");
        txt_numero_historia_paciente.setText("");
        txt_antecedentes_paciente.setText("");
        txt_historial_enfermedades_paciente.setText("");
        txt_tratamiento_actual.setText("");
        txt_visitas_anteriores_pacientes.setText("");

    }

    private void llenarFormulario(Pacientes_Controller paciente) {
        txt_dni_paciente.setText(String.valueOf(paciente.getDni_paciente()));
        txt_nombres_paciente.setText(paciente.getNombres_paciente());
        txt_apellidos_paciente.setText(paciente.getApellidos_paciente());
        combobox_genero_paciente.setSelectedItem(paciente.getGenero_paciente());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        txt_fecha_nacimiento_paciente.setText(dateFormat.format(paciente.getFecha_de_nacimiento_paciente()));
        txt_telefono_paciente.setText(String.valueOf(paciente.getTelefono_paciente()));
        txt_contacto_emergencia_paciente.setText(String.valueOf(paciente.getContacto_de_emergencia_paciente()));
        txt_numero_historia_paciente.setText(String.valueOf(paciente.getId_historia()));
        txt_antecedentes_paciente.setText(paciente.getAntecedentes_paciente());
        txt_historial_enfermedades_paciente.setText(paciente.getEnfermedades_paciente());
        txt_visitas_anteriores_pacientes.setText(paciente.getVisitas_paciente());
        txt_tratamiento_actual.setText(paciente.getTratamiento_paciente());
    }

    private void actualizarNumeroHistoria() {
        String dniStr = txt_dni_paciente.getText().trim();
        if (!dniStr.isEmpty()) {
            try {
                int dni = Integer.parseInt(dniStr);
                txt_numero_historia_paciente.setText(String.valueOf(dni));
            } catch (NumberFormatException ex) {
                // Si el valor del campo txt_dni_paciente no es un número válido, no se realiza ninguna acción.
            }
        } else {
            txt_numero_historia_paciente.setText("");
        }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PacienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PacienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PacienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PacienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PacienteUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> combobox_genero_paciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tabla_pacientes;
    private javax.swing.JTextArea txt_antecedentes_paciente;
    private javax.swing.JTextField txt_apellidos_paciente;
    private javax.swing.JTextField txt_contacto_emergencia_paciente;
    private javax.swing.JTextField txt_dni_paciente;
    private javax.swing.JTextField txt_fecha_nacimiento_paciente;
    private javax.swing.JTextArea txt_historial_enfermedades_paciente;
    private javax.swing.JTextField txt_nombres_paciente;
    private javax.swing.JTextField txt_numero_historia_paciente;
    private javax.swing.JTextField txt_telefono_paciente;
    private javax.swing.JTextArea txt_tratamiento_actual;
    private javax.swing.JTextArea txt_visitas_anteriores_pacientes;
    // End of variables declaration//GEN-END:variables
}
