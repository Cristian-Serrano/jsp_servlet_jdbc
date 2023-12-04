package org.iesvdm.jsp_servlet_jdbc.dao;

import org.iesvdm.jsp_servlet_jdbc.model.Partido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PartidoDAOImpl extends AbstractDAOImpl implements PartidoDAO {
    @Override
    public void create(Partido partido) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();


            //1 alternativas comentadas:
            //Ver también, AbstractDAOImpl.executeInsert ...
            //Columna fabricante.codigo es clave primaria auto_increment, por ese motivo se omite de la sentencia SQL INSERT siguiente.
            ps = conn.prepareStatement("INSERT INTO partido (fecha, equipo1, puntos_equipo1, equipo2, puntos_equipo2, tipo_partido) VALUES (?, ? , ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            int idx = 1;
            ps.setDate(idx++, (java.sql.Date)partido.getFecha());
            ps.setString(idx++, partido.getEquipo1());
            ps.setInt(idx++, partido.getPuntos_equipo1());
            ps.setString(idx++, partido.getEquipo2());
            ps.setInt(idx++, partido.getPuntos_equipo2());
            ps.setString(idx++, partido.getTipo_partido());

            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de partido con 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                partido.setId(rsGenKeys.getInt(1));

        } catch (SQLException | ClassNotFoundException  e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }

    @Override
    public List<Partido> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Partido> listPartido = new ArrayList<>();

        try {
            conn = connectDB();

            // Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM partido");
            while (rs.next()) {
                Partido partido = new Partido();

                partido.setId(rs.getInt("id"));
                partido.setEquipo1(rs.getString("equipo1"));
                partido.setPuntos_equipo1(rs.getInt("puntos_equipo1"));
                partido.setEquipo2(rs.getString("equipo2"));
                partido.setPuntos_equipo2(rs.getInt("puntos_equipo2"));
                partido.setTipo_partido(rs.getString("tipo_partido"));
                listPartido.add(partido);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return listPartido;

    }

    @Override
    public Optional<Partido> find(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM partido WHERE id = ?");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Partido partido = new Partido();

                partido.setId(rs.getInt("id"));
                partido.setEquipo1(rs.getString("equipo1"));
                partido.setPuntos_equipo1(rs.getInt("puntos_equipo1"));
                partido.setEquipo2(rs.getString("equipo2"));
                partido.setPuntos_equipo2(rs.getInt("puntos_equipo2"));
                partido.setTipo_partido(rs.getString("tipo_partido"));

                return Optional.of(partido);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return Optional.empty();

    }

    @Override
    public void update(Partido partido) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE socio SET fecha = ?, equipo1 = ?, puntos_equipo1 = ?, equipo2 = ?, puntos_equipo2 = ?, tipo_partido = ?  WHERE id = ?");
            int idx = 1;
            ps.setDate(idx++, (java.sql.Date)partido.getFecha());
            ps.setString(idx++, partido.getEquipo1());
            ps.setInt(idx++, partido.getPuntos_equipo1());
            ps.setString(idx++, partido.getEquipo2());
            ps.setInt(idx++, partido.getPuntos_equipo2());
            ps.setString(idx, partido.getTipo_partido());

            ps.setInt(idx++, partido.getId());

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Update de partido con 0 registros actualizados.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }

    @Override
    public void delete(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("DELETE FROM partido WHERE id = ?");
            int idx = 1;
            ps.setInt(idx, id);

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Delete de partido con 0 registros eliminados.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }
}
