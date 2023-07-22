/* Alex */
package Interfaces.Administrador;

import Databases.Conexion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartUtilities;

/**
 *
 * @author USER
 */
public final class GeneracionUI extends javax.swing.JFrame {
    // ...

    private final DefaultTableModel modelo;
    private final Conexion conexion;
    private JFreeChart pieChart;
    private DefaultPieDataset pieDataset;

    public GeneracionUI() {
        initComponents();
        modelo = new DefaultTableModel(null, new String[]{"N_CITA", "ENFERMEDAD"}) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        conexion = new Conexion();
        tableRegistrar1.setModel(modelo);
        cargarDatosEnTabla();
        showPieChart();
    }

    public void cargarDatosEnTabla() {
        modelo.setRowCount(0);
        try (Connection conn = conexion.getConexion();
                PreparedStatement stmt = conn.prepareStatement("SELECT id_citas, motivo_visita FROM citas")) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int nCita = rs.getInt("id_citas");
                String enfermedad = rs.getString("motivo_visita");
                modelo.addRow(new Object[]{nCita, enfermedad});
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur while accessing the database

        }
    }

    public void showPieChart() {

        DefaultPieDataset pieDataset = new DefaultPieDataset();

        HashMap<String, Integer> diseaseCount = new HashMap<>();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String enfermedad = modelo.getValueAt(i, 1).toString();
            diseaseCount.put(enfermedad, diseaseCount.getOrDefault(enfermedad, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : diseaseCount.entrySet()) {
            String enfermedad = entry.getKey();
            int count = entry.getValue();
            pieDataset.setValue(enfermedad, count);
        }

        //create chart
        pieChart = ChartFactory.createPieChart("ENFERMEDADES", pieDataset, false, true, false);
        PiePlot piePlot = (PiePlot) pieChart.getPlot();

        //changing pie chart blocks colors
        piePlot.setSectionPaint("Gripe", new Color(255, 255, 102));
        piePlot.setSectionPaint("Infecciones de oído", new Color(102, 255, 102));
        piePlot.setSectionPaint("Bronquiolitis", new Color(255, 102, 153));
        piePlot.setSectionPaint("Varicela", new Color(0, 204, 204));
        piePlot.setSectionPaint("Asma", new Color(255, 0, 0));

        piePlot.setSectionPaint("Hipertensión arterial", new Color(209, 149, 68));
        piePlot.setSectionPaint("Insuficiencia cardíaca", new Color(58, 185, 160));
        piePlot.setSectionPaint("Miocardiopatías", new Color(23, 62, 158));
        piePlot.setSectionPaint("Trombosis venosa profunda", new Color(23, 158, 135));
        piePlot.setSectionPaint("Cardiomiopatías", new Color(32, 23, 158));
        piePlot.setSectionPaint("Tromboembolismo pulmonar", new Color(158, 23, 144));

        piePlot.setSectionPaint("Enfermedades pulmonares ocupacionales", new Color(158, 23, 55));
        piePlot.setSectionPaint("Apnea del sueño", new Color(28, 199, 223));
        piePlot.setSectionPaint("Infecciones respiratorias agudas", new Color(68, 113, 80));
        piePlot.setSectionPaint("Neumonía", new Color(195, 96, 218));
        piePlot.setSectionPaint("Hipertensión arterial", new Color(39, 86, 75));
        piePlot.setSectionPaint("Diabetes tipo 2", new Color(248, 189, 82));

        piePlot.setSectionPaint("Colesterol alto", new Color(198, 126, 206));
        piePlot.setSectionPaint("Dolores musculoesqueléticos", new Color(29, 74, 32));
        piePlot.setSectionPaint("Alergias", new Color(223, 94, 51));
        piePlot.setSectionPaint("Pancreatitis", new Color(223, 243, 93));
        piePlot.setSectionPaint("Reflujo gastroesofágico", new Color(93, 150, 243));
        piePlot.setSectionPaint("Gastritis", new Color(112, 12, 60));
        piePlot.setSectionPaint("Úlceras pépticas", new Color(149, 91, 97));
        piePlot.setSectionPaint("Síndrome del intestino irritable", new Color(231, 186, 94));
        piePlot.setSectionPaint("Ojo rosado", new Color(155, 231, 94));
        piePlot.setSectionPaint("Conjuntivitis alérgica", new Color(94, 110, 231));
        piePlot.setSectionPaint("Miopía, hipermetropía y astigmatismo", new Color(108, 76, 108));
        piePlot.setSectionPaint("Glaucoma", new Color(76, 89, 108));
        piePlot.setSectionPaint("Cataratas", new Color(151, 255, 0));

        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel pieChartPanel = new ChartPanel(pieChart);
        panelBarChart.removeAll();
        panelBarChart.add(pieChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
    }

    public void generarPDF() {
        showPieChart();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();
        String fechaActual = dateFormat.format(date);
        String nombreArchivo = "Reporte_" + fechaActual + ".pdf";
        String rutaCarpeta = "E:\\PDF"; // Replace with the desired folder path
        String rutaArchivo = rutaCarpeta + File.separator + nombreArchivo;

        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
            document.open();

            // Add the header information
            addHeader(document);

            // Add the pie chart
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ChartUtilities.writeChartAsPNG(byteArrayOutputStream, pieChart, 500, 400);
            Image image = Image.getInstance(byteArrayOutputStream.toByteArray());
            document.add(image);

            // Add a table with the data
            addTable(document);

            document.close();

            JOptionPane.showMessageDialog(this, "Reporte generado exitosamente, revise sus documentos por favor.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(this, "Error al generar el PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void addHeader(Document document) throws DocumentException {
        Paragraph header = new Paragraph();
        header.add("Fecha de reporte en el PDF: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + "\n\n");
        header.add("Emisor: Policlínico Nuestra Señora del Sagrado Corazón\n");
        header.add("Codigo unico: 10814\n");
        header.add("Dirección: Av. Alfonso Ugarte & Av. Esperanza, Ate. Lima, Peru.\n\n");
        header.add("Empresa receptora: Ministerio de Salud\n");
        header.add("RUC de la empresa: 20131373237\n");
        header.add("Dirección: Av.Salaverry Nro.801, Jesus Maria. Lima, Peru.\n\n");
        document.add(header);
    }

    private void addTable(Document document) throws DocumentException {
        PdfPTable pdfTable = new PdfPTable(modelo.getColumnCount());
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            pdfTable.addCell(modelo.getColumnName(i));
        }
        for (int row = 0; row < modelo.getRowCount(); row++) {
            for (int col = 0; col < modelo.getColumnCount(); col++) {
                pdfTable.addCell(modelo.getValueAt(row, col).toString());
            }
        }
        document.add(pdfTable);
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
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        panelBarChart = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRegistrar1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generación de Reportes para MINSA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Especialidades");

        jLabel3.setText("- Pediatría");

        jLabel4.setText("- Cardiología");

        jLabel5.setText("- Neumología");

        jLabel6.setText("- Medicina General");

        jLabel7.setText("- Gastroenterología");

        jLabel8.setText("- Oftalmología");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Generar Reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(68, 68, 68))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        panelBarChart.setLayout(new java.awt.BorderLayout());

        tableRegistrar1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tableRegistrar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 993, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(panelBarChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(917, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(144, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(607, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        generarPDF();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PrincipalUI principal = new PrincipalUI();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GeneracionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneracionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneracionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneracionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneracionUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JTable tableRegistrar1;
    // End of variables declaration//GEN-END:variables
}
