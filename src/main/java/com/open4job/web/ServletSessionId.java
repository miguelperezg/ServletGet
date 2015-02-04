package com.open4job.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.open4job.model.dao.BaseDatos;
import com.open4job.model.dao.ParadaTaxiDAO;
import com.open4job.model.vo.ParadaTaxiVO;


public class ServletSessionId extends HttpServlet {
	public static final Logger logger = Logger.getLogger(ServletSessionId.class
			.getName());
	private static final long serialVersionUID = 1L;
       

    public ServletSessionId() {
        super();
  
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession(true);
		BaseDatos bbdd = new BaseDatos();
		try {
			
			Connection conexion = bbdd.abrirConexion();
			ParadaTaxiDAO paradaTaxi = new ParadaTaxiDAO();
			String idInt = (String) session.getAttribute("id");
			int id = Integer.parseInt(idInt);
			ParadaTaxiVO paradaTaxiVO = paradaTaxi.getparadataxi(id, conexion);
			
			session.setAttribute("taxi", paradaTaxiVO);
			
			request.getRequestDispatcher("TaxiIdSession.jsp").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "SQLException : " + e.getMessage());
		}

		bbdd.cerrarConexion();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
