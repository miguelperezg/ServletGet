package com.open4job.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.open4job.model.dao.BaseDatos;
import com.open4job.model.dao.ParadaTaxiDAO;
import com.open4job.model.vo.ParadaTaxiVO;

public class ServletServicios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final Logger logger = Logger.getLogger(ServletServicios.class
			.getName());

	public ServletServicios() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Controlador
		String idIn = (String) request.getParameter("id");
		int id = Integer.parseInt(idIn);

		// Modelo
		BaseDatos bbdd = new BaseDatos();
		try {
			Connection conexion = bbdd.abrirConexion();
			ParadaTaxiDAO paradaTaxi = new ParadaTaxiDAO();
			ParadaTaxiVO paradaTaxiVO = paradaTaxi.getparadataxi(id, conexion);

			// Vista
			PrintWriter out = response.getWriter();
			request.setAttribute("taxi", paradaTaxiVO);
			request.getRequestDispatcher("TaxiId.jsp").forward(request, response);
			/*
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Servicio Taxi " + paradaTaxiVO.toString()
					+ "</h1>");
			out.println("</body>");
			out.println("</html>");
			*/
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		bbdd.cerrarConexion();

	}

}
