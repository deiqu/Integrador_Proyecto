/* Diego */
package Logica;

import java.util.Date;

public class Citas_Controller {
    int id_citas;
    int dni_paciente;
    String motivo_visita;
    Date fecha_cita;

    public Citas_Controller(int id_citas, int dni_paciente, String motivo_visita, Date fecha_cita) {
        this.id_citas = id_citas;
        this.dni_paciente = dni_paciente;
        this.motivo_visita = motivo_visita;
        this.fecha_cita = fecha_cita;
    }

    public Citas_Controller() {
    }
    
    public int getDni_paciente() {
        return dni_paciente;
    }

    public void setDni_paciente(int dni_paciente) {
        this.dni_paciente = dni_paciente;
    }

    public int getId_citas() {
        return id_citas;
    }

    public void setId_citas(int id_citas) {
        this.id_citas = id_citas;
    }

    public String getMotivo_visita() {
        return motivo_visita;
    }

    public void setMotivo_visita(String motivo_visita) {
        this.motivo_visita = motivo_visita;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }
    
}
