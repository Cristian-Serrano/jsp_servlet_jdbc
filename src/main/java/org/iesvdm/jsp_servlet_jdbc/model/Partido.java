package org.iesvdm.jsp_servlet_jdbc.model;

import java.util.Date;
import java.util.Objects;

public class Partido {
    private int id;
    private Date fecha;
    private String equipo1;
    private int puntos_equipo1;
    private String equipo2;
    private int puntos_equipo2;
    private String tipo_partido;

    public Partido(){

    }

    public Partido(int id, Date fecha, String equipo1, int puntos_equipo1, String equipo2, int puntos_equipo2, String tipo_partido) {
        this.id = id;
        this.fecha = fecha;
        this.equipo1 = equipo1;
        this.puntos_equipo1 = puntos_equipo1;
        this.equipo2 = equipo2;
        this.puntos_equipo2 = puntos_equipo2;
        this.tipo_partido = tipo_partido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public int getPuntos_equipo1() {
        return puntos_equipo1;
    }

    public void setPuntos_equipo1(int puntos_equipo1) {
        this.puntos_equipo1 = puntos_equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getPuntos_equipo2() {
        return puntos_equipo2;
    }

    public void setPuntos_equipo2(int puntos_equipo2) {
        this.puntos_equipo2 = puntos_equipo2;
    }

    public String getTipo_partido() {
        return tipo_partido;
    }

    public void setTipo_partido(String tipo_partido) {
        this.tipo_partido = tipo_partido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return id == partido.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Partido{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", equipo1=" + equipo1 +
                ", puntos_equipo1=" + puntos_equipo1 +
                ", equipo2=" + equipo2 +
                ", puntos_equipo2=" + puntos_equipo2 +
                ", tipo_partido='" + tipo_partido + '\'' +
                '}';
    }
}
