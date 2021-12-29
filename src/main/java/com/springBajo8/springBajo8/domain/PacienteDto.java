package com.springBajo8.springBajo8.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Paciente")
public class PacienteDto {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private List<Padecimiento> padecimiento;

    public PacienteDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Padecimiento> getPadecimiento() {
        return padecimiento;
    }

    public void setPadecimiento(List<Padecimiento> padecimiento) {
        this.padecimiento = padecimiento;
    }
}
