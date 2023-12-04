package org.iesvdm.jsp_servlet_jdbc.servlet;

import jakarta.servlet.http.HttpServletRequest;
import org.iesvdm.jsp_servlet_jdbc.model.Partido;
import org.iesvdm.jsp_servlet_jdbc.model.Socio;

import java.util.Objects;
import java.util.Optional;

public class UtilServletPartido {

    public static Optional<Partido> validaGrabar(HttpServletRequest request) {

        //CÓDIGO DE VALIDACIÓN
        boolean valida = true;
        //int socioID = -1;
        java.util.Date fecha = null;
        String equipo1 = null;
        int puntos_equipo1 = -1;
        String equipo2 = null;
        int puntos_equipo2 = -1;
        String tipo_partido = null;

        try {

            Objects.requireNonNull(request.getParameter("equipo1"));

            if (request.getParameter("equipo1").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            equipo1 = request.getParameter("equipo1");

            puntos_equipo1 = Integer.parseInt(request.getParameter("puntos_equipo1"));

            Objects.requireNonNull(request.getParameter("equipo2"));

            if (request.getParameter("equipo2").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            equipo2 = request.getParameter("equipo2");

            puntos_equipo2 = Integer.parseInt(request.getParameter("puntos_equipo2"));

            Objects.requireNonNull(request.getParameter("tipo_partido"));

            if (request.getParameter("tipo_partido").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            tipo_partido = request.getParameter("tipo_partido");

            return Optional.of(new Partido(-1, fecha, equipo1, puntos_equipo1, equipo2, puntos_equipo2, tipo_partido));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //FIN CÓDIGO DE VALIDACIÓN
        return Optional.empty();

    }

    public static Optional<Socio> validaEditar(HttpServletRequest request) {

        //CÓDIGO DE VALIDACIÓN
        boolean valida = true;
        //int socioID = -1;
        String nombre = null;
        int estatura = -1;
        int edad = -1;
        String localidad = null;
        try {
            Objects.requireNonNull(request.getParameter("nombre"));
            if (request.getParameter("nombre").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            nombre = request.getParameter("nombre");

            estatura = Integer.parseInt(request.getParameter("estatura"));

            edad = Integer.parseInt(request.getParameter("edad"));

            Objects.requireNonNull(request.getParameter("localidad"));
            if (request.getParameter("localidad").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            localidad = request.getParameter("localidad");

            return Optional.of(new Socio(-1, nombre, estatura, edad, localidad));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //FIN CÓDIGO DE VALIDACIÓN
        return Optional.empty();
    }
}
