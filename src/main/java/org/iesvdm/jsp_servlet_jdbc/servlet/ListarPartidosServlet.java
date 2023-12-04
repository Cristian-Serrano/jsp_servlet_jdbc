package org.iesvdm.jsp_servlet_jdbc.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesvdm.jsp_servlet_jdbc.dao.PartidoDAO;
import org.iesvdm.jsp_servlet_jdbc.dao.PartidoDAOImpl;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAO;
import org.iesvdm.jsp_servlet_jdbc.dao.SocioDAOImpl;
import org.iesvdm.jsp_servlet_jdbc.model.Partido;
import org.iesvdm.jsp_servlet_jdbc.model.Socio;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListarPartidosServlet", value = "/ListarPartidosServlet")
public class ListarPartidosServlet extends HttpServlet {

    private PartidoDAO partidoDAO = new PartidoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoPartidos.jsp");

        List<Partido> listado = this.partidoDAO.getAll();
        request.setAttribute("listado", listado);

        dispatcher.forward(request, response);

    }

}