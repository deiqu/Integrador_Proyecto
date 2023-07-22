
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Reportes_Controller {
   private int id_citas;
   private int dni_doctor;
   private int p_dni;
   private String motivo_visita;
   private String fecha_cita;
   private String especialidad;

    public int getId_citas() {
        return id_citas;
    }

    public void setId_citas(int id_citas) {
        this.id_citas = id_citas;
    }

    public int getDni_doctor() {
        return dni_doctor;
    }

    public void setDni_doctor(int dni_doctor) {
        this.dni_doctor = dni_doctor;
    }

    public int getP_dni() {
        return p_dni;
    }

    public void setP_dni(int p_dni) {
        this.p_dni = p_dni;
    }

    public String getMotivo_visita() {
        return motivo_visita;
    }

    public void setMotivo_visita(String motivo_visita) {
        this.motivo_visita = motivo_visita;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
public Reportes_Controller obtenerReporte(int id_citas) {
    Reportes_Controller reportePaciente = null;

    // Realizar la búsqueda del historial del paciente en la base de datos
    String query = "SELECT c.*, m.especialidad FROM citas c "
            + "INNER JOIN medico m ON c.dni_doctor = m.dni_doctor "
            + "WHERE c.id_citas = ?";
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinico", "root", "");
            PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, id_citas);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // Si se encuentra el historial, cargar los datos en un objeto HistorialCTRL
                reportePaciente = new Reportes_Controller();
                reportePaciente.setId_citas(rs.getInt("id_citas"));
                reportePaciente.setDni_doctor(rs.getInt("dni_doctor"));
                reportePaciente.setP_dni(rs.getInt("p_dni"));
                reportePaciente.setMotivo_visita(rs.getString("motivo_visita"));
                reportePaciente.setFecha_cita(rs.getString("fecha_cita"));
                
                // Retrieve the "especialidad" from the medico table
                reportePaciente.setEspecialidad(rs.getString("especialidad"));
            }
        }
    } catch (SQLException ex) {
        // Manejo de excepciones y mensajes de error
        ex.printStackTrace();
    }

    return reportePaciente;
}
   
}
