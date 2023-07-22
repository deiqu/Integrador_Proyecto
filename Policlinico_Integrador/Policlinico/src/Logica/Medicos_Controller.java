/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author macac
 */
public class Medicos_Controller {

    int dni_medico;
    String nombre_medico;
    String apellido_medico;
    String especialidad_medico;
    String comentario_admin_de_medico;

    public int getDni_medico() {
        return dni_medico;
    }

    public void setDni_medico(int dni_medico) {
        this.dni_medico = dni_medico;
    }

    public String getNombre_medico() {
        return nombre_medico;
    }

    public void setNombre_medico(String nombre_medico) {
        this.nombre_medico = nombre_medico;
    }

    public String getApellido_medico() {
        return apellido_medico;
    }

    public void setApellido_medico(String apellido_medico) {
        this.apellido_medico = apellido_medico;
    }

    public String getEspecialidad_medico() {
        return especialidad_medico;
    }

    public void setEspecialidad_medico(String especialidad_medico) {
        this.especialidad_medico = especialidad_medico;
    }

    public String getComentario_admin_de_medico() {
        return comentario_admin_de_medico;
    }

    public void setComentario_admin_de_medico(String comentario_admin_de_medico) {
        this.comentario_admin_de_medico = comentario_admin_de_medico;
    }
   
}
